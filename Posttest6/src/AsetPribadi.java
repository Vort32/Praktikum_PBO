public class AsetPribadi extends Aset implements Displayable {
    private final String pemilik;
    private static int totalAset = 0;

    public AsetPribadi(String Nama, Kategori kategori, String Deskripsi, String pemilik) {
        super(Nama, kategori, Deskripsi);
        this.pemilik = pemilik;
        totalAset++;
    }

    public String getPemilik() {
        return pemilik;
    }

    @Override
    public void display() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║            Informasi Aset           ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ Nama       : " + getNama());
        System.out.println("║ Kategori   : " + getKategori().getNama());
        System.out.println("║ Deskripsi  : " + getDeskripsi());
        System.out.println("║ Pemilik    : " + pemilik);
        System.out.println("╚═════════════════════════════════════╝");
    }

    @Override
    public void showDetails() {
        System.out.println("Total aset pribadi: " + totalAset);
    }

    public static int getTotalAset() {
        return totalAset;
    }
}
