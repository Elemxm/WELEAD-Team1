package gr.athtech.spring.app.repository;

import gr.athtech.spring.app.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long>{

}
