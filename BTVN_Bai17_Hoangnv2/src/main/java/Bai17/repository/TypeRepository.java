package Bai17.repository;

import Bai17.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);
}
