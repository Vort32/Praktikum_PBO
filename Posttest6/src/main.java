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
        boolean BerhasilLogin = false;
        Login admin = new Login("admin", "admin123", true);
    
        try {
            login();
            BerhasilLogin = true;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        if (BerhasilLogin) {
            while (true) {
                try {
                    clear();
                    System.out.println("╔═════════════════════════════════════════════╗");
                    System.out.println("║                 Menu Utama                  ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║ 1. Tambah Data                              ║");
                    System.out.println("║ 2. Tampilkan Kategori                       ║");
                    System.out.println("║ 3. Tampilkan Data                           ║");
                    System.out.println("║ 4. Ubah Data                                ║");
                    System.out.println("║ 5. Hapus Data                               ║");
                    System.out.println("║ 6. Keluar                                   ║");
                    System.out.println("╠═════════════════════════════════════════════╣");
                    System.out.println("║                 RHINE LAB                   ║");
                    System.out.println("╚═════════════════════════════════════════════╝");
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
            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║              Login - Rhine Lab               ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║            Selamat Datang Di Rhine Lab       ║");
            System.out.print("║ Masukkan username : ");
            String username = input.readLine();
            System.out.print("║ Masukkan password : ");
            String password = input.readLine();
    
            if (Login.authenticate(username, password)) {
                currentLogin = Login.getLoginByUsername(username);
                System.out.println("║ Berhasil login!                           ║");
                break;
            } else {
                System.out.println("║ Gagal login, silakan coba lagi!           ║");
            }
            System.out.println("║ Tekan enter untuk mencoba login lagi         ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            input.readLine();
        }
    }
    


    static void tambah_data() throws NumberFormatException, IOException {
        clear();
        System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║               Tambah Data                   ║");
        System.out.println("╠═════════════════════════════════════════════╣");
        System.out.println("║ Pilih jenis data yang ingin ditambahkan:    ║");
        System.out.println("║ 1. Aset Perusahaan                          ║");
        System.out.println("║ 2. Aset Pribadi                             ║");
        System.out.print("║ Masukkan pilihan anda : ");
        int pilih = Integer.parseInt(input.readLine());
        
        if (pilih < 1 || pilih > 2) {
            System.out.println("║ Pilihan tidak valid!                          ║");
            System.out.println("║ Tekan enter untuk kembali ke menu             ║");
            input.readLine();
            clear();
            return;
        }
        
        System.out.print("║ Berapa banyak data yang ingin anda masukkan : ");
        int batasan = Integer.parseInt(input.readLine());
        
        if (batasan <= 0) {
            System.out.println("║ Batasan data harus lebih dari 0!              ║");
            System.out.println("║ Tekan enter untuk kembali ke menu             ║");
            input.readLine();
            clear();
            return;
        }
        
        for (int i = 1; i <= batasan; i++) {
            System.out.println("║ [========Rhine Lab========]                 ║");
            System.out.print("║ Masukkan Nama : ");
            String nama = input.readLine();
            System.out.print("║ Masukkan Deskripsi : ");
            String deskripsi = input.readLine();
    
            System.out.print("║ Masukkan Nama Kategori : ");
            String namaKategori = input.readLine();
            System.out.print("║ Masukkan Deskripsi Kategori : ");
            String deskripsiKategori = input.readLine();
            Kategori kategori = new Kategori(namaKategori, deskripsiKategori);
            if (!daftarKategori.contains(kategori)) {
                daftarKategori.add(kategori);
            }
    
            if (pilih == 1) {
                System.out.print("║ Masukkan Departemen : ");
                String departemen = input.readLine();
                AsetPerusahaan asetPerusahaan = new AsetPerusahaan(nama, kategori, deskripsi, departemen);
                dataAset.add(asetPerusahaan);
            } else if (pilih == 2) {
                System.out.print("║ Masukkan Pemilik : ");
                String pemilik = input.readLine();
                AsetPribadi asetPribadi = new AsetPribadi(nama, kategori, deskripsi, pemilik);
                dataAset.add(asetPribadi);
            }
        }
        System.out.println("║ Data telah ditambahkan!!!                   ║");
        System.out.println("║ Tekan enter untuk kembali ke menu           ║");
        input.readLine();
        clear();
    }
    






static void tampilkan_kategori() {
    clear();
    System.out.println("╔══════════════════════════════════════════════╗");
    System.out.println("║              Daftar Kategori                 ║");
    System.out.println("╠══════════════════════════════════════════════╣");
    try {
        for (Kategori kategori : daftarKategori) {
            System.out.println("║ Nama Kategori: " + kategori.getNama());
            System.out.println("║ Deskripsi    : " + kategori.getDeskripsi());
            System.out.println("║ -------------------------------------------- ║");
        }
        System.out.println("║ Tekan enter untuk kembali ke menu            ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        input.readLine();
    } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
    clear();
}



static void tampilkan_dalam_Kategori() throws IOException {
    clear();
    System.out.println("╔══════════════════════════════════════════════════════╗");
    System.out.println("║          Tampilkan Data per Kategori                 ║");
    System.out.println("╠══════════════════════════════════════════════════════╣");
    
    System.out.println("║ Pilih Kategori:                                      ║");
    for (int i = 0; i < daftarKategori.size(); i++) {
        System.out.println("║ " + (i+1) + ". " + daftarKategori.get(i).getNama());
    }
    System.out.print("║ Masukkan nomor kategori yang ingin ditampilkan: ");
    int nomorKategori = Integer.parseInt(input.readLine()) - 1;
    
    if (nomorKategori >= 0 && nomorKategori < daftarKategori.size()) {
        Kategori kategori = daftarKategori.get(nomorKategori);
        System.out.println("║ Kategori: " + kategori.getNama());
        System.out.println("║ -----------------------------                     ║");
        boolean adaData = false;
        for (Aset aset : dataAset) {
            if (aset.getKategori().getNama().equals(kategori.getNama())) {
                aset.display(); 
                System.out.println("║ -----------------------------              ║");
                adaData = true;
            }
        }
        if (!adaData) {
            System.out.println("║ Tidak ada data untuk kategori ini.              ║");
        }
    } else {
        System.out.println("║ Nomor kategori tidak valid!                         ║");
    }
    
    System.out.println("║ Tekan enter untuk kembali ke menu                       ║");
    System.out.println("╚═════════════════════════════════════════════════════════╝");
    input.readLine();
    clear();
}




static void ubah_data() throws IOException {
    clear();
    System.out.println("Ubah Data");
    System.out.println("[============Rhine Lab============]");

    System.out.println("Data saat ini:");
    for (int i = 0; i < dataAset.size(); i++) {
        System.out.println((i+1) + ". " + dataAset.get(i).getNama());
    }

    System.out.print("Masukkan nomor data yang ingin diubah : ");
    int nomor = Integer.parseInt(input.readLine());
    
    if (nomor > 0 && nomor <= dataAset.size()) {
        Aset aset = dataAset.get(nomor - 1); 
        
        System.out.println("Pilih Kategori:");
        for (int i = 0; i < daftarKategori.size(); i++) {
            System.out.println((i+1) + ". " + daftarKategori.get(i).getNama());
        }
        System.out.print("Pilih nomor kategori baru : ");
        int nomorKategoriBaru = Integer.parseInt(input.readLine()) - 1;
        
        if (nomorKategoriBaru >= 0 && nomorKategoriBaru < daftarKategori.size()) {
            Kategori kategoriBaru = daftarKategori.get(nomorKategoriBaru);
            
            System.out.print("Apakah Anda ingin mengubah data kategori? (yes/no): ");
            String ubahKategori = input.readLine();
            
            if (ubahKategori.equalsIgnoreCase("yes")) {
                System.out.print("Masukkan Nama baru untuk kategori : ");
                String namaKategoriBaru = input.readLine();
                System.out.print("Masukkan Deskripsi baru untuk kategori : ");
                String deskripsiKategoriBaru = input.readLine();
                
                kategoriBaru.setNama(namaKategoriBaru);
                kategoriBaru.setDeskripsi(deskripsiKategoriBaru);
                aset.setKategori(kategoriBaru); 
            }
            
            if (aset instanceof AsetPerusahaan) {
                System.out.print("Apakah Anda ingin mengubah departemen? (yes/no): ");
                String ubahDepartemen = input.readLine();
                
                if (ubahDepartemen.equalsIgnoreCase("yes")) {
                    System.out.print("Masukkan Departemen baru : ");
                    String departemenBaru = input.readLine();
                    ((AsetPerusahaan) aset).setDepartemen(departemenBaru);
                }
            }
            
            System.out.print("Masukkan Deskripsi baru : ");
            String deskripsi = input.readLine();
            
            aset.ubahDeskripsi(deskripsi); 

            System.out.println("Data berhasil diubah!");
        } else {
            System.out.println("Nomor kategori tidak valid!");
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
    System.out.println("╔═════════════════════════════════════════════╗");
    System.out.println("║       Hapus Data dalam Kategori             ║");
    System.out.println("╠═════════════════════════════════════════════╣");

    System.out.println("║ Data saat ini:                              ║");
    for (int i = 0; i < dataAset.size(); i++) {
        System.out.println("║ " + (i+1) + ". " + dataAset.get(i).getNama() + " - Kategori: " + dataAset.get(i).getKategori().getNama());
    }

    System.out.print("║ Masukkan nomor data yang ingin dihapus : ");
    int nomor = Integer.parseInt(input.readLine());
    
    if (nomor > 0 && nomor <= dataAset.size()) {
        Aset aset = dataAset.get(nomor - 1); 
        
        String namaKategori = aset.getKategori().getNama();
        
        Iterator<Aset> iterator = dataAset.iterator();
        while (iterator.hasNext()) {
            Aset currentAset = iterator.next();
            if (currentAset.equals(aset)) {
                iterator.remove();
                System.out.println("║ Data " + currentAset.getNama() + " dalam kategori " + namaKategori + " berhasil dihapus!║");
                break;
            }
        }
        
        Iterator<Kategori> kategoriIterator = daftarKategori.iterator();
        while (kategoriIterator.hasNext()) {
            Kategori kategori = kategoriIterator.next();
            if (kategori.getNama().equals(namaKategori)) {
                kategoriIterator.remove();
                break;
            }
        }
    } else {
        System.out.println("║ Nomor data tidak valid!                      ║");
    }
    
    System.out.println("║ Tekan enter untuk kembali ke menu           ║");
    System.out.println("╚═════════════════════════════════════════════╝");
    input.readLine();
    clear();
}





}