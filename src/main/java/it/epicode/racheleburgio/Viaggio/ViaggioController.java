package it.epicode.racheleburgio.Viaggio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioRepository viaggioRepository;

    @Operation(summary = "Ottieni tutti i viaggi")
    @GetMapping
    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    @Operation(summary = "Ottieni un viaggio per ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Viaggio trovato"),
            @ApiResponse(responseCode = "404", description = "Viaggio non trovato")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Viaggio> getViaggioById(@PathVariable Long id) {
        Optional<Viaggio> viaggio = viaggioRepository.findById(id);
        return viaggio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea un nuovo viaggio")
    @PostMapping
    public Viaggio createViaggio(@RequestBody Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    @Operation(summary = "Elimina un viaggio per ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViaggio(@PathVariable Long id) {
        if (viaggioRepository.existsById(id)) {
            viaggioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
