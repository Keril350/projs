from fastapi import FastAPI, Depends
from sqlalchemy.orm import Session
from typing import List

from database import SessionLocal
from crud import get_available_recipes
from models import RecipeIngredient
from schemas import RecipeRequest, RecipeResponse

app = FastAPI()


def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()


@app.post(
    "/api/available-recipes",
    response_model=List[RecipeResponse]  # ← ВАЖНО
)
def available_recipes(
    req: RecipeRequest,
    db: Session = Depends(get_db)
):
    recipes = get_available_recipes(db, req.product_ids)

    response: List[RecipeResponse] = []

    for recipe in recipes:
        ingredient_ids = (
            db.query(RecipeIngredient.product_id)
            .filter(RecipeIngredient.recipe_id == recipe.id)
            .all()
        )

        response.append(
            RecipeResponse(
                recipe_id=recipe.id,
                name=recipe.name,
                required_products=[pid for (pid,) in ingredient_ids]
            )
        )

    return response
