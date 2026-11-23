
package br.edu.unifio.citysync.controladores;

import br.edu.unifio.citysync.entidades.Comentario;
import br.edu.unifio.citysync.servicos.ComentarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public List<Comentario> listarTodos() {
        return comentarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Comentario buscarPorId(@PathVariable Integer id) {
        return comentarioService.buscarPorId(id);
    }

    @PostMapping
    public Comentario cadastrar(@RequestBody Comentario comentario) {
        return comentarioService.salvar(comentario);
    }

    @PutMapping("/{id}")
    public Comentario atualizar(
            @PathVariable Integer id,
            @RequestBody Comentario dados) {

        Comentario comentario = comentarioService.buscarPorId(id);
        comentario.setTexto(dados.getTexto());

        return comentarioService.salvar(comentario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        comentarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
