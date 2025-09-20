import java.util.*;

public class Proceso {
    private int id;
    private int nf;
    private int nc;
    private int tp;
    private int nr;
    private int np;
    private List<String> referencias;

    public Proceso(int id, int nf, int nc, int tp) {
        this.id = id;
        this.nf = nf;
        this.nc = nc;
        this.tp = tp;
        this.referencias = new ArrayList<>();
        generarReferencias();
    }

    private void generarReferencias() {
        int totalEnteros = 3 * nf * nc;
        int memoriaTotal = totalEnteros * 4;
        np = (int) Math.ceil((double) memoriaTotal / tp);
        nr = nf * nc * 3;

 
        int baseM1 = 0;
        int baseM2 = nf * nc * 4;
        int baseM3 = 2 * nf * nc * 4;

        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
         
                referencias.add(formatearReferencia("M1", i, j, baseM1 + (i * nc + j) * 4, "r"));
       
                referencias.add(formatearReferencia("M2", i, j, baseM2 + (i * nc + j) * 4, "r"));
     
                referencias.add(formatearReferencia("M3", i, j, baseM3 + (i * nc + j) * 4, "w"));
            }
        }
    }

    private String formatearReferencia(String matriz, int fila, int col, int direccionVirtual, String rw) {
        int pagina = direccionVirtual / tp;
        int offset = direccionVirtual % tp;
        return String.format("%s:[%d-%d],%d,%d,%s", matriz, fila, col, pagina, offset, rw);
    }

    public int getNf() { return nf; }
    public int getNc() { return nc; }
    public int getNr() { return nr; }
    public int getNp() { return np; }
    public List<String> getReferencias() { return referencias; }
    public int getTp() { return tp; }
    public int getId() { return id; }
}
