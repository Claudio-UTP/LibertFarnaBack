package com.example.libertfarma.repository;
import com.example.libertfarma.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
