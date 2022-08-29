package Backend;

import java.io.Serializable;

public class Quan extends SanPham  {
    private String kieuDangQuan;
    private String mau;
    private String loaiKhoa;
    private String phongCach;
    private String loaiQuan;

    public Quan(){

    }

    public Quan(String tenSP, Double giaNhap, Double giaBan, Integer soLuong, String size, String mauSac, String chatLieu,
                String xuatXu,  String kieuDangQuan, String mau, String loaiKhoa, String phongCach, String loaiQuan,
                String ngayNhap, String thangNhap, String namNhap) {

        super(tenSP, giaNhap, giaBan, soLuong, size, mauSac, chatLieu, xuatXu, ngayNhap, thangNhap, namNhap);
        this.kieuDangQuan = kieuDangQuan;
        this.mau = mau;
        this.loaiKhoa = loaiKhoa;
        this.phongCach = phongCach;
        this.loaiQuan = loaiQuan;
    }

    public String getKieuDangQuan() {
        return kieuDangQuan;
    }

    public void setKieuDangQuan(String kieuDangQuan) {
        this.kieuDangQuan = kieuDangQuan;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getLoaiKhoa() {
        return loaiKhoa;
    }

    public void setLoaiKhoa(String loaiKhoa) {
        this.loaiKhoa = loaiKhoa;
    }

    public String getPhongCach() {
        return phongCach;
    }

    public void setPhongCach(String phongCach) {
        this.phongCach = phongCach;
    }

    public String getLoaiQuan() {
        return loaiQuan;
    }

    public void setLoaiQuan(String loaiQuan) {
        this.loaiQuan = loaiQuan;
    }
}
