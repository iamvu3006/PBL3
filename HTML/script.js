// document.addEventListener("DOMContentLoaded", function () {
//     const currentUser = localStorage.getItem("currentUser"); 
//     const userInfo = document.getElementById("user-info");
//     const loginLink = document.getElementById("login-link");
//     const logoutLink = document.getElementById("logout-link");

//     if (currentUser) {
//         userInfo.innerHTML = `Xin chào, ${currentUser}`;
//         loginLink.style.display = "none"; 
//         logoutLink.style.display = "inline"; // Hiện nút đăng xuất
//     }

//     logoutLink.addEventListener("click", function (event) {
//         event.preventDefault();
//         localStorage.removeItem("currentUser"); 
//         window.location.reload(); 
//     });

//     function checkLogin(event, redirectPage) {
//         if (!currentUser) {
//             event.preventDefault(); 
//             alert("Bạn cần đăng nhập để sử dụng tính năng này!");
//             window.location.href = "login.html"; 
//         } else {
//             window.location.href = redirectPage;
//         }
//     }

//     document.querySelectorAll(".require-login").forEach(button => {
//         button.addEventListener("click", function (event) {
//             checkLogin(event, this.getAttribute("data-redirect"));
//         });
//     });
// });
