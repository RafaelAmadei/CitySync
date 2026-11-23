
package br.edu.unifio.citysync.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unifio.citysync.entidades.Foto;

public interface FotoRepositorio extends JpaRepository<Foto, Integer> {
}
