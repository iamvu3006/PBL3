// document.getElementById("loginForm").addEventListener("submit", async function(e) {
//     e.preventDefault();

//     const username = this.username.value;
//     const password = this.password.value;

//     const response = await fetch("/api/auth/login", {
//         method: "POST",
//         headers: {
//             "Content-Type": "application/json"
//         },
//         body: JSON.stringify({ username, password })
//     });

//     const data = await response.json();
//     const messageElem = document.getElementById("message");

//     if (data.success) {
//         window.location.href = "/";
//     } else {
//         messageElem.textContent = data.message;
//     }
// });
