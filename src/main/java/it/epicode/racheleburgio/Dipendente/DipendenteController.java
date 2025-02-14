package it.epicode.racheleburgio.dipendente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = dipendenteService.uploadProfileImage(file);
            return ResponseEntity.ok("Immagine caricata con successo: " + imageUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Errore durante il caricamento dell'immagine");
        }
    }
}
