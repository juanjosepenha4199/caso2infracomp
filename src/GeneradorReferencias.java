import java.io.*;
import java.util.*;

public class GeneradorReferencias {
    public static void generarArchivoProceso(Proceso p) throws IOException {
        String fileName = "proc" + p.getId() + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("TP=" + p.getTp());
            writer.println("NF=" + p.getNf());
            writer.println("NC=" + p.getNc());
            writer.println("NR=" + p.getNr());
            writer.println("NP=" + p.getNp());

            for (String ref : p.getReferencias()) {
                writer.println(ref);
            }
        }
        System.out.println("Archivo generado: " + fileName);
    }
}
