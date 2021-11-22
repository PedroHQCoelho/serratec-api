package org.serratec.backend.h2banco.repository;

import org.serratec.backend.h2banco.domain.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{

}
