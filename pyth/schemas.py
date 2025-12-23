from pydantic import BaseModel
from typing import List


class RecipeRequest(BaseModel):
    product_ids: List[int]


class RecipeResponse(BaseModel):
    recipe_id: int
    name: str
    required_products: List[int]

    class Config:
        from_attributes = True  # для SQLAlchemy / ORM
