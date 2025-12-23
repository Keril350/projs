from sqlalchemy.orm import Session
from sqlalchemy import select, func
from models import Recipe, RecipeIngredient

def get_available_recipes(
    db: Session,
    product_ids: list[int]
):
    if not product_ids:
        return []

    ingredient_count_subq = (
        select(
            RecipeIngredient.recipe_id,
            func.count().label("required_count")
        )
        .group_by(RecipeIngredient.recipe_id)
        .subquery()
    )

    matched_count_subq = (
        select(
            RecipeIngredient.recipe_id,
            func.count().label("matched_count")
        )
        .where(RecipeIngredient.product_id.in_(product_ids))
        .group_by(RecipeIngredient.recipe_id)
        .subquery()
    )

    query = (
        select(Recipe)
        .join(
            ingredient_count_subq,
            Recipe.id == ingredient_count_subq.c.recipe_id
        )
        .join(
            matched_count_subq,
            Recipe.id == matched_count_subq.c.recipe_id
        )
        .where(
            ingredient_count_subq.c.required_count ==
            matched_count_subq.c.matched_count
        )
    )

    return db.scalars(query).all()
