package Backend;

import java.util.Scanner;

public class QuanLiDoanhThu {
    public void show(){
        Scanner inputs = new Scanner(System.in);
        System.out.println("Thời điểm bắt đầu tính:");
        System.out.println("Nhập năm");
        String nam1 = inputs.nextLine();

        System.out.println("Nhập tháng");
        String thang1 = inputs.nextLine();

        System.out.println("Nhập ngày:");
        String ngay1 = inputs.nextLine();

        System.out.println("Thời điểm kết thúc tính:");
        System.out.println("Nhập năm");
        String nam2 = inputs.nextLine();

        System.out.println("Nhập tháng");
        String thang2 = inputs.nextLine();

        System.out.println("Nhập ngày:");
        String ngay2 = inputs.nextLine();

        String nam = "";
        String thang = "";
        String ngay = "";

        Double luong = 0.0;
        Double TienMuaHang = 0.0;
        Double TienHang = 0.0;
        Double TienThu = 0.0;
        Double TienChiPhiPhu = 0.0;
        Double tienLai = 0.0;
        for(int i=0;i<App.CONG.size();i++){
            nam = App.CONG.get(i).getCaLamViec().getNam();
            thang = App.CONG.get(i).getCaLamViec().getThang();
            ngay = App.CONG.get(i).getCaLamViec().getNgay();
            if((nam1.compareTo(nam) <= 0 && nam.compareTo(nam2) <= 0 )
            && (thang1.compareTo(thang) <= 0 && thang.compareTo(thang2) <= 0)
            && (ngay1.compareTo(ngay) <= 0 && ngay.compareTo(ngay2) <= 0)){
                luong = luong + App.CONG.get(i).getNhanVien().getLuong()*5;
            }
        }

        for(int i=0;i<App.HOADON.size();i++){
            nam = App.HOADON.get(i).getNam();
            thang = App.HOADON.get(i).getThang();
            ngay = App.HOADON.get(i).getNgay();
            if((nam1.compareTo(nam) <= 0 && nam.compareTo(nam2) <= 0 )
                    && (thang1.compareTo(thang) <= 0 && thang.compareTo(thang2) <= 0)
                    && (ngay1.compareTo(ngay) <= 0 && ngay.compareTo(ngay2) <= 0)){
                for(int j=0;j<App.HOADON.get(i).getSanPhamVaSoLuongs().size();j++){
                    TienHang = TienHang + App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSanPhamAo().getGiaNhap()*
                            App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSoLuongAo() +

                            App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSanPhamQuan().getGiaNhap()*
                                    App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSoLuongQuan() +

                            App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSanPhamGiay().getGiaNhap()*
                                    App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSoLuongGiay();

                    TienThu = TienThu + App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSanPhamAo().getGiaBan()*
                            App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSoLuongAo() +

                            App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSanPhamQuan().getGiaBan()*
                                    App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSoLuongQuan() +

                            App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSanPhamGiay().getGiaBan()*
                                    App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSoLuongGiay();
                }
            }
        }

        for(int i=0;i<App.CHIPHIPHU.size();i++){
            nam = App.CHIPHIPHU.get(i).getNam();
            thang = App.CHIPHIPHU.get(i).getThang();
            ngay = App.CHIPHIPHU.get(i).getNgay();
            if((nam1.compareTo(nam) <= 0 && nam.compareTo(nam2) <= 0 )
                    && (thang1.compareTo(thang) <= 0 && thang.compareTo(thang2) <= 0)
                    && (ngay1.compareTo(ngay) <= 0 && ngay.compareTo(ngay2) <= 0)){
                TienChiPhiPhu = TienChiPhiPhu + App.CHIPHIPHU.get(i).getTien();
            }
        }

        for(int i=0;i<App.SANPHAMQUAN.size();i++){
            nam = App.SANPHAMQUAN.get(i).getNamNhap();
            thang = App.SANPHAMQUAN.get(i).getThangNhap();
            ngay = App.SANPHAMQUAN.get(i).getNgayNhap();

            if((nam1.compareTo(nam) <= 0 && nam.compareTo(nam2) <= 0 )
                    && (thang1.compareTo(thang) <= 0 && thang.compareTo(thang2) <= 0)
                    && (ngay1.compareTo(ngay) <= 0 && ngay.compareTo(ngay2) <= 0)){
                TienMuaHang += App.SANPHAMQUAN.get(i).getGiaNhap();
            }

        }

        for(int i=0;i<App.SANPHAMAO.size();i++){
            nam = App.SANPHAMAO.get(i).getNamNhap();
            thang = App.SANPHAMAO.get(i).getThangNhap();
            ngay = App.SANPHAMAO.get(i).getNgayNhap();

            if((nam1.compareTo(nam) <= 0 && nam.compareTo(nam2) <= 0 )
                    && (thang1.compareTo(thang) <= 0 && thang.compareTo(thang2) <= 0)
                    && (ngay1.compareTo(ngay) <= 0 && ngay.compareTo(ngay2) <= 0)){
                TienMuaHang += App.SANPHAMAO.get(i).getGiaNhap();
            }

        }

        for(int i=0;i<App.SANPHAMGIAY.size();i++){
            nam = App.SANPHAMGIAY.get(i).getNamNhap();
            thang = App.SANPHAMGIAY.get(i).getThangNhap();
            ngay = App.SANPHAMGIAY.get(i).getNgayNhap();

            if((nam1.compareTo(nam) <= 0 && nam.compareTo(nam2) <= 0 )
                    && (thang1.compareTo(thang) <= 0 && thang.compareTo(thang2) <= 0)
                    && (ngay1.compareTo(ngay) <= 0 && ngay.compareTo(ngay2) <= 0)){
                TienMuaHang += App.SANPHAMGIAY.get(i).getGiaNhap();
            }

        }


        tienLai = TienThu - TienHang - luong - TienChiPhiPhu;
        System.out.println("Tổng tiền hàng đã nhập: " + TienMuaHang);
        System.out.println("Tiền các sản phẩm đã bán: " + TienHang);
        System.out.println("Tiền lương trả nhân viên: " + luong);
        System.out.println("Tổng tiền thu được: " + TienThu);
        System.out.println("Tổng chi phí khác: " + TienChiPhiPhu);
        System.out.println("Tiền lãi: " + tienLai);

    }
}
