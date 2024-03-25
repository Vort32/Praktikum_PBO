import java.io.*;
import java.util.*;

public class main {
    static int batasan;
    private static InputStreamReader p = new InputStreamReader(System.in);  
	private static BufferedReader input;
    private static ArrayList<Aset> dataAset = new ArrayList<>();
    private static ArrayList<Kategori> daftarKategori = new ArrayList<>();
    private static Login currentLogin;
    static {
        try {
            input = new BufferedReader(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    

    public static void main(String[] args) {
        boolean Berhasilogin = false;
        Login admin = new Login("admin", "admin123", true);

        try {
            login();
            Berhasilogin = true; 
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        if (Berhasilogin) {
            while (true) {
                try {
                    System.out.println("1. Tambah Data");
                    System.out.println("2. Tampilkan Kategori");
                    System.out.println("3. Tampilkan Data");
                    System.out.println("4. Ubah Data");
                    System.out.println("5. Hapus Data");
                    System.out.println("6. Keluar");
                    System.out.print("Masukkan pilihan anda : ");
                    int pilih = Integer.parseInt(input.readLine());
                    switch (pilih) {
                        case 1:
                            tambah_data();
                            break;
                        case 2:
                            tampilkan_kategori();
                            break;
                        case 3:
                            tampilkan_dalam_Kategori();
                            break;
                        case 4:
                            ubah_data();
                            break;
                        case 5:
                            hapus_data();
                            break;
                        case 6:
                            System.exit(0);
                        default:
                            System.out.println("Maaf, pilihan anda tidak tersedia!");
                            break;
                    }
                } catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        }
    }

static void login() throws IOException {
    while (true) {
        clear();
        System.out.println("[===================== Login =====================]");
        System.out.println("[========== Selamat Datang Di Rhine Lab ==========]");
        System.out.print("Masukkan username : ");
        String username = input.readLine();
        System.out.print("Masukkan password : ");
        String password = input.readLine();

        if (Login.authenticate(username, password)) {
            currentLogin = Login.getLoginByUsername(username);
            System.out.println("Berhasil login!");
            break;
        } else {
            System.out.println("Gagal login, silakan coba lagi!");
        }
        System.out.println("Tekan enter untuk mencoba login lagi");
        input.readLine();
    }
}


static void tambah_data() throws NumberFormatException, IOException {
    clear();
    System.out.println("Tambah Data");
    System.out.println("===========");
    System.out.println("Pilih jenis data yang ingin ditambahkan:");
    System.out.println("1. Aset");
    System.out.println("2. Aset Perusahaan");
    System.out.println("3. Aset Pribadi");
    System.out.print("Masukkan pilihan anda : ");
    int pilih = Integer.parseInt(input.readLine());
    
    System.out.print("Berapa banyak data yang ingin anda masukkan : ");
    batasan = Integer.parseInt(input.readLine());
    
    for (int i = 1; i <= batasan; i++) {
        System.out.println("[========Rhine Lab========]");
        System.out.print("Masukkan Nama : ");
        String nama = input.readLine();
        System.out.print("Masukkan Deskripsi : ");
        String deskripsi = input.readLine();

        System.out.print("Masukkan Nama Kategori : ");
        String namaKategori = input.readLine();
        System.out.print("Masukkan Deskripsi Kategori : ");
        String deskripsiKategori = input.readLine();
        Kategori kategori = new Kategori(namaKategori, deskripsiKategori);
        if (!daftarKategori.contains(kategori)) {
            daftarKategori.add(kategori);
        }

        if (pilih == 1) {
            Aset aset = new Aset(nama, kategori, deskripsi);
            dataAset.add(aset);
        } else if (pilih == 2) {
            System.out.print("Masukkan Departemen : ");
            String departemen = input.readLine();
            AsetPerusahaan asetPerusahaan = new AsetPerusahaan(nama, kategori, deskripsi, departemen);
            dataAset.add(asetPerusahaan);
        } else if (pilih == 3) {
            System.out.print("Masukkan Pemilik : ");
            String pemilik = input.readLine();
            AsetPribadi asetPribadi = new AsetPribadi(nama, kategori, deskripsi, pemilik);
            dataAset.add(asetPribadi);
        }
    }
    System.out.println("Data telah ditambahkan!!!");
    System.out.println("Tekan enter untuk kembali ke menu");
    input.readLine();
    clear();
}

static void tampilkan_kategori() {
    clear();
    System.out.println("Daftar Kategori");
    System.out.println("===============");
    try {
        for (Kategori kategori : daftarKategori) {
            System.out.println("Nama Kategori: " + kategori.getNama());
            System.out.println("Deskripsi: " + kategori.getDeskripsi());
            System.out.println("------------------------------");
        }
        System.out.println("Tekan enter untuk kembali ke menu");
        input.readLine();
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
    clear();
}


static void tampilkan_dalam_Kategori() throws IOException {
    clear();
    System.out.println("Tampilkan Data per Kategori");
    System.out.println("==========================");
    
    System.out.println("Pilih Kategori:");
    for (int i = 0; i < daftarKategori.size(); i++) {
        System.out.println((i+1) + ". " + daftarKategori.get(i).getNama());
    }
    System.out.print("Masukkan nomor kategori yang ingin ditampilkan: ");
    int nomorKategori = Integer.parseInt(input.readLine()) - 1;
    
    if (nomorKategori >= 0 && nomorKategori < daftarKategori.size()) {
        Kategori kategori = daftarKategori.get(nomorKategori);
        System.out.println("Kategori: " + kategori.getNama());
        System.out.println("-----------------------------");
        boolean adaData = false;
        for (Aset aset : dataAset) {
            if (aset.getKategori().getNama().equals(kategori.getNama())) {
                aset.display();
                if (aset instanceof AsetPerusahaan) {
                    AsetPerusahaan asetPerusahaan = (AsetPerusahaan) aset;
                    System.out.println("Departemen: " + asetPerusahaan.getDepartemen());
                    System.out.println("+-------------------+");
                } else if (aset instanceof AsetPribadi) {
                    AsetPribadi asetPribadi = (AsetPribadi) aset;
                    System.out.println("Pemilik: " + asetPribadi.getPemilik());
                    System.out.println("+-------------------+");
                }
                adaData = true;
            }
        }
        if (!adaData) {
            System.out.println("Tidak ada data untuk kategori ini.");
        }
    } else {
        System.out.println("Nomor kategori tidak valid!");
    }
    
    System.out.println("Tekan enter untuk kembali ke menu");
    input.readLine();
    clear();
}




static void ubah_data() throws IOException {
    clear();
    System.out.println("Ubah Data");
    System.out.println("===========");
    System.out.print("Masukkan nomor data yang ingin diubah : ");
    int nomor = Integer.parseInt(input.readLine());
    
    if (nomor > 0 && nomor <= dataAset.size()) {
        Aset aset = dataAset.get(nomor - 1); 
        System.out.println("Pilih Kategori:");
        for (int i = 0; i < daftarKategori.size(); i++) {
            System.out.println((i+1) + ". " + daftarKategori.get(i).getNama());
        }
        System.out.print("Pilih kategori : ");
        String namaKategoriBaru = input.readLine();
        Kategori kategoriBaru = null;
        for (Kategori kategori : daftarKategori) {
            if (kategori.getNama().equalsIgnoreCase(namaKategoriBaru)) {
                kategoriBaru = kategori;
                break;
            }
        }
        if (kategoriBaru != null) {
            System.out.print("Masukkan Nama baru : ");
            String nama = input.readLine();
            System.out.print("Masukkan Deskripsi baru : ");
            String deskripsi = input.readLine();
            aset.Nama = nama;
            aset.kategori = kategoriBaru;
            aset.Deskripsi = deskripsi;

            System.out.println("Data berhasil diubah!");
        } else {
            System.out.println("Kategori tidak ditemukan!");
        }
    } else {
        System.out.println("Nomor data tidak valid!");
    }
    
    System.out.println("Tekan enter untuk kembali ke menu");
    input.readLine();
    clear();
}



static void hapus_data() throws IOException {
    clear();
    System.out.println("Hapus Data dalam Kategori");
    System.out.println("=========================");
    System.out.print("Masukkan nama kategori yang ingin dihapus: ");
    String namaKategori = input.readLine();
    boolean kategoriDitemukan = false;
    Iterator<Aset> iterator = dataAset.iterator();
    while (iterator.hasNext()) {
        Aset aset = iterator.next();
        if (aset.getKategori().getNama().equals(namaKategori)) {
            iterator.remove();
            System.out.println("Data dalam kategori " + namaKategori + " berhasil dihapus!");
            kategoriDitemukan = true;
        }
    }
    if (kategoriDitemukan) {
        Iterator<Kategori> kategoriIterator = daftarKategori.iterator();
        while (kategoriIterator.hasNext()) {
            Kategori kategori = kategoriIterator.next();
            if (kategori.getNama().equals(namaKategori)) {
                kategoriIterator.remove();
                break;
            }
        }
    }
    if (!kategoriDitemukan) {
        System.out.println("Tidak ada data dalam kategori " + namaKategori);
    }
    System.out.println("Tekan enter untuk kembali ke menu");
    input.readLine();
    clear();
}



}