document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('ingredient-form');
    if (form) {
        form.addEventListener('submit', async function(event) {
            event.preventDefault();
            var ingredients = Array.from(document.querySelectorAll('input[name="ingredients"]:checked')).map(input => input.value);
            try {
                const response = await fetch('/findRecipes', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ ingredients: ingredients })
                });
                if (!response.ok) {
                    throw new Error('No matching recipes found.');
                }
                const recipes = await response.json();
                displayRecipes(recipes);
            } catch (error) {
                alert(error.message);
            }
        });
    }
});

function displayRecipes(recipes) {
    const resultContainer = document.querySelector('.result');
    resultContainer.innerHTML = '';
    if (recipes.length === 0) {
        resultContainer.innerHTML = '<p>No matching recipes found.</p>';
    } else {
        recipes.forEach(recipe => {
            let recipeDiv = document.createElement('div');
            recipeDiv.innerHTML = `<h2>${recipe.name}</h2>
                                   <p>Difficulty: ${recipe.difficulty}</p>
                                   <p>Preparation Time: ${recipe.prepTime} minutes</p>
                                   <p>Dietary Restrictions: ${recipe.dietaryRestrictions}</p>
                                   <p>Ingredients: ${recipe.ingredients.join(', ')}</p>`;
            resultContainer.appendChild(recipeDiv);
        });
    }
}
