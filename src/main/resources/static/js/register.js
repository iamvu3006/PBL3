// register.js - đặt trong thư mục src/main/resources/static/js/

document.addEventListener('DOMContentLoaded', function() {
    const registerForm = document.getElementById('registerForm');

    // Kiểm tra xem đã đăng nhập chưa
    fetch('/api/auth/check-session')
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                // Đã đăng nhập, chuyển hướng về trang chủ
                window.location.href = '/';
            }
        })
        .catch(error => {
            console.error('Error checking session:', error);
        });

    registerForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const username = document.getElementById('username').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        // Kiểm tra cơ bản
        if (!username || !email || !password || !confirmPassword) {
            showError('Vui lòng nhập đầy đủ thông tin');
            return;
        }

        if (password !== confirmPassword) {
            showError('Mật khẩu xác nhận không khớp');
            return;
        }

        // Kiểm tra định dạng email
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email)) {
            showError('Email không hợp lệ');
            return;
        }

        // Gửi request đăng ký đến backend
        fetch('/api/auth/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: username,
                email: email,
                password: password
            })
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    // Hiển thị thông báo thành công
                    showSuccess(data.message || 'Đăng ký thành công! Vui lòng đăng nhập');

                    // Xóa form
                    registerForm.reset();

                    // Tự động chuyển hướng sau 2 giây
                    setTimeout(() => {
                        window.location.href = '/login';
                    }, 2000);
                } else {
                    // Đăng ký thất bại
                    showError(data.message || 'Đăng ký thất bại');
                }
            })
            .catch(error => {
                showError('Có lỗi xảy ra. Vui lòng thử lại sau.');
                console.error('Error:', error);
            });
    });

    function showError(message) {
        // Xóa thông báo thành công nếu có
        const successDiv = document.querySelector('.alert-success');
        if (successDiv) {
            successDiv.remove();
        }

        // Tạo thông báo lỗi nếu chưa có
        let errorDiv = document.querySelector('.alert-danger');
        if (!errorDiv) {
            errorDiv = document.createElement('div');
            errorDiv.className = 'alert alert-danger';
            registerForm.parentNode.insertBefore(errorDiv, registerForm);
        }

        errorDiv.textContent = message;
    }

    function showSuccess(message) {
        // Xóa thông báo lỗi nếu có
        const errorDiv = document.querySelector('.alert-danger');
        if (errorDiv) {
            errorDiv.remove();
        }

        // Tạo thông báo thành công
        let successDiv = document.querySelector('.alert-success');
        if (!successDiv) {
            successDiv = document.createElement('div');
            successDiv.className = 'alert alert-success';
            registerForm.parentNode.insertBefore(successDiv, registerForm);
        }

        successDiv.textContent = message;
    }
});