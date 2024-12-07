package com.example.libertfarma.repository;
import com.example.libertfarma.model.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia,Integer> {
}
