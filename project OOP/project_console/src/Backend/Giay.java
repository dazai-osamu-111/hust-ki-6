package Backend;

public class Giay extends SanPham{
    private  String kieuCoGiay;
    private  String dip;
    private  String loaiGiay;

    public  Giay(){

    }

    public Giay(String tenSP, Double giaNhap, Double giaBan, Integer soLuong, String size, String mauSac, String chatLieu, String xuatXu,
                 String kieuCoGiay, String dip, String loaiGiay, String ngayNhap, String thangNhap, String namNhap) {
        super(tenSP, giaNhap, giaBan, soLuong, size, mauSac, chatLieu, xuatXu, ngayNhap, thangNhap, namNhap);
        this.kieuCoGiay = kieuCoGiay;
        this.dip = dip;
        this.loaiGiay = loaiGiay;
    }

    public String getKieuCoGiay() {
        return kieuCoGiay;
    }

    public void setKieuCoGiay(String kieuCoGiay) {
        this.kieuCoGiay = kieuCoGiay;
    }

    public String getDip() {
        return dip;
    }

    public void setDip(String dip) {
        this.dip = dip;
    }

    public String getLoaiGiay() {
        return loaiGiay;
    }

    public void setLoaiGiay(String loaiGiay) {
        this.loaiGiay = loaiGiay;
    }
}
