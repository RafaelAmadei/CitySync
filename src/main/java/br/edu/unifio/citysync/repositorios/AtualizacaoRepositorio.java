
package br.edu.unifio.citysync.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unifio.citysync.entidades.Atualizacao;

public interface AtualizacaoRepositorio extends JpaRepository<Atualizacao, Integer> {
}
