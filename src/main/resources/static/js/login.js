// login.js - đặt trong thư mục src/main/resources/static/js/

document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');

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

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        // Kiểm tra thông tin đăng nhập cơ bản
        if (!username || !password) {
            showError('Vui lòng nhập đầy đủ thông tin đăng nhập');
            return;
        }

        // Gửi request đến backend
        fetch('/api/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: username,
                password: password
            })
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    // Đăng nhập thành công
                    // Chuyển hướng đến trang chính
                    window.location.href = '/';
                } else {
                    // Đăng nhập thất bại
                    showError(data.message || 'Tên đăng nhập hoặc mật khẩu không chính xác');
                }
            })
            .catch(error => {
                showError('Có lỗi xảy ra. Vui lòng thử lại sau.');
                console.error('Error:', error);
            });
    });

    function showError(message) {
        // Tạo thông báo lỗi nếu chưa có
        let errorDiv = document.querySelector('.alert-danger');
        if (!errorDiv) {
            errorDiv = document.createElement('div');
            errorDiv.className = 'alert alert-danger';
            loginForm.parentNode.insertBefore(errorDiv, loginForm);
        }

        errorDiv.textContent = message;
    }
});