public class AsetPerusahaan extends Aset implements Displayable {
    private String departemen; 
    private static int totalAset = 0; 

    public AsetPerusahaan(String Nama, Kategori kategori, String Deskripsi, String departemen) {
        super(Nama, kategori, Deskripsi);
        this.departemen = departemen;
        totalAset++; 
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    @Override
    public void display() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║            Informasi Aset           ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ Nama       : " + getNama());
        System.out.println("║ Kategori   : " + getKategori().getNama());
        System.out.println("║ Deskripsi  : " + getDeskripsi());
        System.out.println("║ Departemen : " + departemen);
        System.out.println("╚═════════════════════════════════════╝");
    }

    @Override
    public void showDetails() {
        System.out.println("Total aset perusahaan: " + totalAset);
    }

    public static int getTotalAset() {
        return totalAset;
    }
}
