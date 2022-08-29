package Backend;

import java.io.Serializable;

public class Ao extends SanPham  {
    private String coAo;
    private String mauAo;
    private String chieuDaiTayAo;
    private String loaiAo;

    public Ao(){

    }

    public Ao(String tenSP, Double giaNhap, Double giaBan, Integer soLuong, String size, String mauSac, String chatLieu, String xuatXu,
               String coAo, String mauAo, String chieuDaiTayAo, String loaiAo, String ngayNhap, String thangNhap, String namNhap) {
        super(tenSP, giaNhap, giaBan, soLuong, size, mauSac, chatLieu, xuatXu, ngayNhap, thangNhap, namNhap);
        this.coAo = coAo;
        this.mauAo = mauAo;
        this.chieuDaiTayAo = chieuDaiTayAo;
        this.loaiAo = loaiAo;
    }

    public String getCoAo() {
        return coAo;
    }

    public void setCoAo(String coAo) {
        this.coAo = coAo;
    }

    public String getMauAo() {
        return mauAo;
    }

    public void setMauAo(String mauAo) {
        this.mauAo = mauAo;
    }

    public String getChieuDaiTayAo() {
        return chieuDaiTayAo;
    }

    public void setChieuDaiTayAo(String chieuDaiTayAo) {
        this.chieuDaiTayAo = chieuDaiTayAo;
    }

    public String getLoaiAo() {
        return loaiAo;
    }

    public void setLoaiAo(String loaiAo) {
        this.loaiAo = loaiAo;
    }
}
