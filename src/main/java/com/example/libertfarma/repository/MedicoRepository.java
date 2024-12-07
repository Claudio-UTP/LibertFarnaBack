package com.example.libertfarma.repository;
import com.example.libertfarma.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MedicoRepository extends JpaRepository<Medico,Integer> {
}
