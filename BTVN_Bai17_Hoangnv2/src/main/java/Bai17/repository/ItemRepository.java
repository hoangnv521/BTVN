package Bai17.repository;

import Bai17.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query(value = "SELECT * from item as a inner join item_category as b on a.id = b.item_id where b.category_id = ?1",nativeQuery = true)
    Page<Item> findByCategoryId(Long id, Pageable pageable);
}
