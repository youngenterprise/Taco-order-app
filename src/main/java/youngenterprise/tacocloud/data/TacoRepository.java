package youngenterprise.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import youngenterprise.tacocloud.Taco;

public interface TacoRepository extends CrudRepository<Taco,Long> {

}
