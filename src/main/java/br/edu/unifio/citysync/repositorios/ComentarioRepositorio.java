
package br.edu.unifio.citysync.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unifio.citysync.entidades.Comentario;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Integer> {
}
