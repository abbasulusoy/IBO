package ulusoy.at.wicket.service;


import java.io.File;
import java.util.List;


import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import ulusoy.at.wicket.entity.BestellteArtikel;
import ulusoy.at.wicket.entity.Bestellung;



@Validated
public interface DocumentService {

    File printBestellungToDocx(@NotNull Bestellung bestellung);
    File printBestellungListToDocx(@NotNull List<Bestellung> bestellung);
    File printEinkaufListe(@NotNull List<BestellteArtikel> einkaufsliste);
}
