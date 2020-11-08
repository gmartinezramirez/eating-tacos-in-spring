package com.gmartinezramirez.eatingTacos.repository.impl;

import com.gmartinezramirez.eatingTacos.model.Ingredient;
import com.gmartinezramirez.eatingTacos.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public JdbcIngredientRepository(JdbcTemplate aJdbcTemplate) {
    this.jdbcTemplate = aJdbcTemplate;
  }

  @Override
  public Iterable<Ingredient> findAll() {
    return jdbcTemplate.query("select id, name, type from Ingredient", this::mapRowToIngredient);
  }

  @Override
  public Ingredient findOne(String id) {
    return jdbcTemplate.queryForObject(
        "select id, name, type from Ingredient where id=?", this::mapRowToIngredient, id);
  }

  @Override
  public Ingredient save(Ingredient ingredient) {
    jdbcTemplate.update(
        "insert into Ingredient (id, name, type) values (?, ?, ?)",
        ingredient.getId(),
        ingredient.getName(),
        ingredient.getType().toString());
    return ingredient;
  }

  private Ingredient mapRowToIngredient(ResultSet resultSet, int rowNum) throws SQLException {
    return new Ingredient(
        resultSet.getLong("id"),
        resultSet.getString("name"),
        Ingredient.Type.valueOf(resultSet.getString("type")));
  }
}
