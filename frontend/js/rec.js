

document.addEventListener('DOMContentLoaded', () => {
    const recommendationForm = document.getElementById("recommendationForm");
    const apiBaseUrl = "http://localhost:8080/api/Recommendation";

    // Recommendation form submission
    recommendationForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const email = document.getElementById("email").value;
        const movie_or_tvShow = document.getElementById("movie_or_tvShow").value;
        
        const score = document.getElementById("score").value;

        try {
            const response = await fetch(apiBaseUrl, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({ email, movie_or_tvShow, score }),
            });

            const contentType = response.headers.get("Content-Type");

            if (!response.ok) {
                const errorText = contentType && contentType.includes("application/json")
                    ? await response.json()
                    : await response.text();
                throw new Error(errorText.message || "An error occurred during submission.");
            }

            const data = contentType && contentType.includes("application/json")
                ? await response.json()
                : await response.text();

            alert("Recommendation submitted successfully!");
              window.location.href = "../html/index.html";

        } catch (error) {
            console.error('Error:', error);
            alert(error.message);
        }
    });
});



