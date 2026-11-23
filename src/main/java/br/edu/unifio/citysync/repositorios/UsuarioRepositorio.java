package br.edu.unifio.citysync.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unifio.citysync.entidades.Usuario;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);
}
