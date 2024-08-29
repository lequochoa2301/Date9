package mvc.repository;

import mvc.entity.OrderDetailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetailEntity, Integer> {
}
