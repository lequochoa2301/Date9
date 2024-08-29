package mvc.repository;

import mvc.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    Optional<ProductEntity> findById(Integer id);
}
