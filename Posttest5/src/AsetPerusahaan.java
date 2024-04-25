public class AsetPerusahaan extends Aset {
    private String departemen; 

    public AsetPerusahaan(String Nama, Kategori kategori, String Deskripsi, String departemen) {
        super(Nama, kategori, Deskripsi);
        this.departemen = departemen;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    @Override
    public void display() {
        System.out.println("=====================");
        System.out.println("Nama >>> " + getNama());
        System.out.println("Kategori >>> " + getKategori().getNama());
        System.out.println("Deskripsi >>> " + getDeskripsi());
        System.out.println("Departemen >>> " + departemen);
        System.out.println("=====================");
    }
}
