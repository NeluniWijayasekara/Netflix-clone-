const logregBox = document.querySelector(".logreg-box");
const loginLink = document.querySelector(".login-link");
const registerLink = document.querySelector(".register-link");

registerLink.addEventListener("click", () => {
  logregBox.classList.add("active");
});
loginLink.addEventListener("click", () => {
  logregBox.classList.remove("active");
});

document.addEventListener('DOMContentLoaded', () => {
    const registerForm = document.getElementById("registerForm");
    const loginForm = document.getElementById("loginForm");
    const apiBaseUrl = "http://localhost:8080/api/User";

    // Registration form submission
    registerForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const firstName = document.getElementById("firstName").value;
        const lastName = document.getElementById("lastName").value;
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;
        const terms = document.getElementById("terms").checked;

        if (!terms) {
            alert("You must agree to the terms and conditions.");
            return;
        }

        try {
            const response = await fetch(apiBaseUrl, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({firstName,lastName,email,password }),
            });

            const contentType = response.headers.get("Content-Type");

            if (!response.ok) {
                const errorText = contentType && contentType.includes("application/json")
                    ? await response.json()
                    : await response.text();
                throw new Error(errorText.message || "An error occurred during registration.");
            }

            const data = contentType && contentType.includes("application/json")
                ? await response.json()
                : await response.text();
            alert("User registered successfully!");
            
            window.location.href = "index.html";
            
        } catch (error) {
            console.error('Error:', error);
            alert(error.message);
        }
    });

    // Login form submission
    loginForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const email = document.querySelector("#loginForm input[name='email']").value;
        const password = document.querySelector("#loginForm input[name='password']").value;

        try {
            const response = await fetch(`${apiBaseUrl}/login`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({email, password }),
            });

            const contentType = response.headers.get("Content-Type");

            if (!response.ok) {
                const errorText = contentType && contentType.includes("application/json")
                    ? await response.json()
                    : await response.text();
                throw new Error(errorText.message || "Invalid credentials");
            }

            const data = contentType && contentType.includes("application/json")
                ? await response.json()
                : await response.text();
            
            // Assuming successful login, redirect to a different page
            alert("Login successful!");
            window.location.href = "../html/index.html"; // Redirect to the dashboard or another page

        } catch (error) {
            console.error('Error:', error);
            alert(error.message);
        }
    });
});
