package br.edu.univas.si7.topicos.process.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.univas.si7.topicos.process.entity.ProcessEntity;

@Repository
public interface ProcessRepository extends JpaRepository<ProcessEntity, Long> {
		
}
