package com.pkg.code.mutant.repository;


import com.pkg.code.mutant.entity.Mutante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MutanteRepository extends JpaRepository<Mutante,Long> {

   @Query("Select u from Mutante u WHERE u.secuencia=?1")
   Optional<Mutante> findByMutanteSecuencia(String secuencia);
}
