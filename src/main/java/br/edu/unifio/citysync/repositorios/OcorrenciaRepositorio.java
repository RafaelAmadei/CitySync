package br.edu.unifio.citysync.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unifio.citysync.entidades.Ocorrencia;

public interface OcorrenciaRepositorio extends JpaRepository<Ocorrencia, Integer> {
}
