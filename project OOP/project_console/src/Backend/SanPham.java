package Backend;

public class SanPham {
    private String tenSP;
    private Double giaNhap;
    private Double giaBan;
    private Integer soLuong;
    private String size;
    private String mauSac;
    private String chatLieu;
    private String xuatXu;
    private String ngayNhap;
    private String thangNhap;
    private String namNhap;
    public SanPham(){
        this.giaBan = 0.0;
        this.giaNhap = 0.0;
    }

    public SanPham(String tenSP, Double giaNhap, Double giaBan, Integer soLuong, String size,
                   String mauSac, String chatLieu, String xuatXu, String ngayNhap, String thangNhap, String namNhap) {
        this.tenSP = tenSP;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.size = size;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.xuatXu = xuatXu;
        this.ngayNhap = ngayNhap;
        this.thangNhap = thangNhap;
        this.namNhap = namNhap;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getThangNhap() {
        return thangNhap;
    }

    public void setThangNhap(String thangNhap) {
        this.thangNhap = thangNhap;
    }

    public String getNamNhap() {
        return namNhap;
    }

    public void setNamNhap(String namNhap) {
        this.namNhap = namNhap;
    }
}