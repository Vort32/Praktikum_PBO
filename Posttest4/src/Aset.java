public class Aset {
    private String Nama;
    private Kategori kategori;
    private String Deskripsi;

    // Constructor
    public Aset(String Namas, Kategori kategoris, String Deskrpsis) {
        this.Nama = Namas;
        this.kategori = kategoris;
        this.Deskripsi = Deskrpsis;
    }

    // Getter for Nama
    public String getNama() {
        return this.Nama;
    }


    public void setNama(String nama) {
        this.Nama = nama;
    }


    public Kategori getKategori() {
        return this.kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }


    public String getDeskripsi() {
        return this.Deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.Deskripsi = deskripsi;
    }

    public void display(){
        System.out.println("=====================");
        System.out.println("Nama >>> " + this.Nama);
        System.out.println("Kategori >>> " + this.kategori.getNama());
        System.out.println("Deskripsi >>> " + this.Deskripsi);
        System.out.println("=====================");
    }
}
