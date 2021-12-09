package youngenterprise.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import youngenterprise.tacocloud.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient,String> {

}
