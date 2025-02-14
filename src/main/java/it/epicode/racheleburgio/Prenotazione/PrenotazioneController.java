package it.epicode.racheleburgio.Prenotazione;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Operation(summary = "Ottieni tutte le prenotazioni")
    @GetMapping
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    @Operation(summary = "Ottieni una prenotazione per ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prenotazione trovata"),
            @ApiResponse(responseCode = "404", description = "Prenotazione non trovata")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable Long id) {
        Optional<Prenotazione> prenotazione = prenotazioneRepository.findById(id);
        return prenotazione.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea una nuova prenotazione")
    @PostMapping
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    @Operation(summary = "Elimina una prenotazione per ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrenotazione(@PathVariable Long id) {
        if (prenotazioneRepository.existsById(id)) {
            prenotazioneRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
