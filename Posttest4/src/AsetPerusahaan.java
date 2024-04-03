public class AsetPerusahaan extends Aset {
    private String departemen;

    public AsetPerusahaan(String Namas, Kategori kategoris, String Deskrpsis, String departemen) {
        super(Namas, kategoris, Deskrpsis);
        this.departemen = departemen;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

}
