package br.edu.unifio.citysync.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unifio.citysync.entidades.Ocorrencia;

import java.util.List;

public interface OcorrenciaRepositorio extends JpaRepository<Ocorrencia, Integer> {

    List<Ocorrencia> findByStatus(String status);

    List<Ocorrencia> findByUsuario_Id(Integer usuarioId);
}
