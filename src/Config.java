import java.io.*;
import java.util.*;

public class Config {
    private int tp;              
    private int nproc;         
    private List<int[]> tams; 

    public Config(String filePath) throws IOException {
        tams = new ArrayList<>();
        loadConfig(filePath);
    }
//carga
    private void loadConfig(String filePath) throws IOException {
        Properties props = new Properties();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("TP=")) {
                    tp = Integer.parseInt(line.split("=")[1]);
                } else if (line.startsWith("NPROC=")) {
                    nproc = Integer.parseInt(line.split("=")[1]);
                } else if (line.startsWith("TAMS=")) {
                    String[] matrices = line.split("=")[1].split(",");
                    for (String m : matrices) {
                        String[] dims = m.split("x");
                        int nf = Integer.parseInt(dims[0]);
                        int nc = Integer.parseInt(dims[1]);
                        tams.add(new int[]{nf, nc});
                    }
                }
            }
        }
    }

    public int getTp() {
        return tp;
    }

    public int getNproc() {
        return nproc;
    }

    public List<int[]> getTams() {
        return tams;
    }
}


