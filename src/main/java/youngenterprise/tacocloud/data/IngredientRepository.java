package youngenterprise.tacocloud.data;

import youngenterprise.tacocloud.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient>findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
