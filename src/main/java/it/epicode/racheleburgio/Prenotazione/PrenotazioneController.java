package it.epicode.racheleburgio.prenotazione;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping("/prenota")
    public ResponseEntity<String> prenotaViaggio(
            @RequestParam Long dipendenteId,
            @RequestParam Long viaggioId,
            @RequestParam LocalDate dataPrenotazione) {

        String risultato = prenotazioneService.prenotaViaggio(dipendenteId, viaggioId, dataPrenotazione);

        if (risultato.startsWith("Errore")) {
            return ResponseEntity.badRequest().body(risultato);
        }

        return ResponseEntity.ok(risultato);
    }
}
