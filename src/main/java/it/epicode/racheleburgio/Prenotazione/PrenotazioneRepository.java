package it.epicode.racheleburgio.prenotazione;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByDipendenteIdAndDataPrenotazione(Long dipendenteId, LocalDate dataPrenotazione);
}

