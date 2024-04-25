public class AsetPribadi extends Aset {
    private final String pemilik;

    public AsetPribadi(String Nama, Kategori kategori, String Deskripsi, String pemilik) {
        super(Nama, kategori, Deskripsi);
        this.pemilik = pemilik;
    }

    public String getPemilik() {
        return pemilik;
    }

    @Override
    public void display() {
        System.out.println("=====================");
        System.out.println("Nama >>> " + getNama());
        System.out.println("Kategori >>> " + getKategori().getNama());
        System.out.println("Deskripsi >>> " + getDeskripsi());
        System.out.println("Pemilik >>> " + pemilik);
        System.out.println("=====================");
    }
}
