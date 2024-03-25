public class AsetPribadi extends Aset {
    private String pemilik;

    public AsetPribadi(String Nama, Kategori kategori, String Deskripsi, String pemilik) {
        super(Nama, kategori, Deskripsi);
        this.pemilik = pemilik;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

}
