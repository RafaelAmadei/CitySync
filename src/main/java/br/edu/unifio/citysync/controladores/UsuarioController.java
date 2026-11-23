
package br.edu.unifio.citysync.controladores;

import br.edu.unifio.citysync.entidades.Usuario;
import br.edu.unifio.citysync.servicos.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.salvar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Integer id,
                             @RequestBody Usuario dados) {

        Usuario usuario = usuarioService.buscarPorId(id);

        usuario.setNome(dados.getNome());
        usuario.setEmail(dados.getEmail());
        usuario.setSenha(dados.getSenha());
        usuario.setTelefone(dados.getTelefone());

        return usuarioService.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        usuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
