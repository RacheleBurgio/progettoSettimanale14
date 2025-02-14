package it.epicode.racheleburgio.prenotazione;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public String prenotaViaggio(Long dipendenteId, Long viaggioId, LocalDate dataPrenotazione) {
        boolean esistePrenotazione = prenotazioneRepository.existsByDipendenteIdAndDataPrenotazione(dipendenteId, dataPrenotazione);

        if (esistePrenotazione) {
            return "Errore: Il dipendente ha già un viaggio prenotato in questa data!";
        }


        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendenteId);
        prenotazione.setViaggio(viaggioId);
        prenotazione.setDataRichiesta(dataPrenotazione);

        prenotazioneRepository.save(prenotazione);
        return "Prenotazione effettuata con successo!";
    }
}
