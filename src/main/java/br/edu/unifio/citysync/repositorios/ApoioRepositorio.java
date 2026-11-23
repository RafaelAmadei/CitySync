package br.edu.unifio.citysync.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unifio.citysync.entidades.Apoio;

public interface ApoioRepositorio extends JpaRepository<Apoio, Integer> {

    boolean existsByUsuario_IdAndOcorrencia_Id(
        Integer usuarioId,
        Integer ocorrenciaId
    );

    boolean existsByUsuario_IdAndOcorrencia_IdAndIdNot(
        Integer usuarioId,
        Integer ocorrenciaId,
        Integer id
    );
}
