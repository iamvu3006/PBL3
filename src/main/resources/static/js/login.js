// <script>
//     async function login() {
//     const username = document.getElementById("username").value;
//     const password = document.getElementById("password").value;
//
//     const response = await fetch("/api/auth/login", {
//     method: "POST",
//     headers: { "Content-Type": "application/json" },
//     body: JSON.stringify({ username, password })
// });
//
//     const data = await response.json();
//
//     if (data.success) {
//     window.location.href = "/"; // chuyển về trang chủ
// } else {
//     alert(data.message);
// }
// }
// </script>
