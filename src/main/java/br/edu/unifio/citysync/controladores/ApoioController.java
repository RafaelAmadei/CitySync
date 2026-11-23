
package br.edu.unifio.citysync.controladores;

import br.edu.unifio.citysync.entidades.Apoio;
import br.edu.unifio.citysync.servicos.ApoioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apoios")
public class ApoioController {

    private final ApoioService apoioService;

    public ApoioController(ApoioService apoioService) {
        this.apoioService = apoioService;
    }

    @GetMapping
    public List<Apoio> listarTodos() {
        return apoioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Apoio buscarPorId(@PathVariable Integer id) {
        return apoioService.buscarPorId(id);
    }

    @PostMapping
    public Apoio cadastrar(@RequestBody Apoio apoio) {
        return apoioService.salvar(apoio);
    }

    @PutMapping("/{id}")
    public Apoio atualizar(
            @PathVariable Integer id,
            @RequestBody Apoio dados) {

        Apoio apoio = apoioService.buscarPorId(id);

        apoio.setUsuario(dados.getUsuario());
        apoio.setOcorrencia(dados.getOcorrencia());

        return apoioService.salvar(apoio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        apoioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
