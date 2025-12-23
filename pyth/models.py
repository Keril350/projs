from sqlalchemy import Column, Integer, String, ForeignKey
from database import Base

class Recipe(Base):
    __tablename__ = "recipe"

    id = Column(Integer, primary_key=True)
    name = Column(String)


class RecipeIngredient(Base):
    __tablename__ = "recipe_ingredient"

    recipe_id = Column(Integer, ForeignKey("recipe.id"), primary_key=True)
    product_id = Column(Integer, primary_key=True)
