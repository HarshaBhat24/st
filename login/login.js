let attempts = 3; // Maximum login attempts allowed
document.getElementById("loginForm").addEventListener("submit", function(e) {
e.preventDefault(); // Prevent form from submitting by default
const username = document.getElementById("username").value.trim();
const password = document.getElementById("password").value.trim();
if (username === "Form" && password === "123") {
alert("Login successful!");
window.location.href = "success.html";
} else {
attempts--;
alert(`Invalid login. You have ${attempts} attempt(s) left.`);
if (attempts === 0) {
document.getElementById("username").disabled = true;
document.getElementById("password").disabled = true;
document.getElementById("submit").disabled = true;
alert("No attempts left. Login disabled.");
}
}
});