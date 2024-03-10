public class Aset {
    String Nama;
    Kategori kategori;
    String Deskripsi;

    Aset(String Namas, Kategori kategoris, String Deskrpsis) {
        this.Nama = Namas;
        this.kategori = kategoris;
        this.Deskripsi = Deskrpsis;
    }

    Kategori getKategori() {
        return this.kategori; 
    }

    void display(){
        System.out.println("=====================");
        System.out.println("Nama >>> " + this.Nama);
        System.out.println("Kategori >>> " + this.kategori.getNama());
        System.out.println("Deskripsi >>> " + this.Deskripsi);
        System.out.println("=====================");
    }
}
