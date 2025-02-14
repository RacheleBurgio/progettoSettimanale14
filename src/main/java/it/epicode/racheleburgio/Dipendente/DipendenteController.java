package it.epicode.racheleburgio.Dipendente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Operation(summary = "Ottieni tutti i dipendenti")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista di dipendenti ottenuta con successo")
    })
    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    @Operation(summary = "Aggiungi un dipendente")
    @PostMapping
    public Dipendente createDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }
}
