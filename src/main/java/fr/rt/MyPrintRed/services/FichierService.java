package fr.rt.MyPrintRed.services;

import fr.rt.MyPrintRed.entities.Fichier;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FichierService {

    Fichier store(MultipartFile file) throws IOException;

    Fichier getFile(Integer id);

    Stream<Fichier> getFichiers();
}
