import java.io.*;
import java.util.*;

public class MainOpcion1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java MainOpcion1 <archivo_config>");
            return;
        }

        try {
            Config config = new Config(args[0]);
            int tp = config.getTp();
            List<int[]> tams = config.getTams();

            for (int i = 0; i < config.getNproc(); i++) {
                int[] dims = tams.get(i);
                Proceso proceso = new Proceso(i, dims[0], dims[1], tp);
                GeneradorReferencias.generarArchivoProceso(proceso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
