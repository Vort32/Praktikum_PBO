public abstract class Aset {
    private final String Nama;
    private Kategori kategori; 
    private String Deskripsi;

    public Aset(String Nama, Kategori kategori, String Deskripsi) {
        this.Nama = Nama;
        this.kategori = kategori;
        this.Deskripsi = Deskripsi;
    }


    public final String getNama() {
        return Nama;
    }

    public final Kategori getKategori() {
        return kategori;
    }

    public final void setKategori(Kategori kategori) { 
        this.kategori = kategori;
    }

    public final String getDeskripsi() {
        return Deskripsi;
    }

    public void ubahDeskripsi(String deskripsiBaru) {
        this.Deskripsi = deskripsiBaru;
    }

    public void display() {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║            Informasi Aset           ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ Nama      : " + Nama);
        System.out.println("║ Kategori  : " + kategori.getNama());
        System.out.println("║ Deskripsi : " + Deskripsi);
        System.out.println("╚═════════════════════════════════════╝");
    }
    
}
