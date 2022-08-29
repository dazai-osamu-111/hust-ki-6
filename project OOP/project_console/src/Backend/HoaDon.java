package Backend;

import java.util.ArrayList;
import java.util.List;

public class HoaDon {

    private List<SanPhamVaSoLuong> sanPhamVaSoLuongs = new ArrayList<SanPhamVaSoLuong>();
    private String nam;
    private String thang;
    private String ngay;
    private Double tongTien;
    private Double tienKhachTra;
    private Double tienTraLai;

    public HoaDon(List<SanPhamVaSoLuong> sanPhamVaSoLuongs, String nam,
                  String thang, String ngay, Double tongTien, Double tienKhachTra, Double tienTraLai) {
        this.sanPhamVaSoLuongs = sanPhamVaSoLuongs;
        this.nam = nam;
        this.thang = thang;
        this.ngay = ngay;
        this.tongTien = tongTien;
        this.tienKhachTra = tienKhachTra;
        this.tienTraLai = tienTraLai;
    }

    public List<SanPhamVaSoLuong> getSanPhamVaSoLuongs() {
        return sanPhamVaSoLuongs;
    }

    public void setSanPhamVaSoLuongs(List<SanPhamVaSoLuong> sanPhamVaSoLuongs) {
        this.sanPhamVaSoLuongs = sanPhamVaSoLuongs;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Double getTienKhachTra() {
        return tienKhachTra;
    }

    public void setTienKhachTra(Double tienKhachTra) {
        this.tienKhachTra = tienKhachTra;
    }

    public Double getTienTraLai() {
        return tienTraLai;
    }

    public void setTienTraLai(Double tienTraLai) {
        this.tienTraLai = tienTraLai;
    }
}
