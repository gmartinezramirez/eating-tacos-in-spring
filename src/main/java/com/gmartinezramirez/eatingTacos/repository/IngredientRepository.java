package com.gmartinezramirez.eatingTacos.repository;

import com.gmartinezramirez.eatingTacos.model.Ingredient;

public interface IngredientRepository {

  Iterable<Ingredient> findAll();

  Ingredient findOne(String id);

  Ingredient save(Ingredient ingredient);
}
