
package br.edu.unifio.citysync.controladores;

import br.edu.unifio.citysync.entidades.Ocorrencia;
import br.edu.unifio.citysync.servicos.OcorrenciaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

    private final OcorrenciaService ocorrenciaService;

    public OcorrenciaController(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }

    @GetMapping
    public List<Ocorrencia> listarTodas() {
        return ocorrenciaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Ocorrencia buscarPorId(@PathVariable Integer id) {
        return ocorrenciaService.buscarPorId(id);
    }

    @PostMapping
    public Ocorrencia cadastrar(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.salvar(ocorrencia);
    }

    @PutMapping("/{id}")
    public Ocorrencia atualizar(@PathVariable Integer id,
                                @RequestBody Ocorrencia dados) {
        return ocorrenciaService.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        ocorrenciaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
