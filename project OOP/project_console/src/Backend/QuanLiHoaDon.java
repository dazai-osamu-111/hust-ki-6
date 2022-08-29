package Backend;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QuanLiHoaDon {
    public void insert(){
        try {
            Scanner inputs = new Scanner(System.in);
            // Nhập thông tin của ca làm việc
            System.out.println("Nhập thông tin hóa đơn...: ");

            System.out.println("Danh sách sản phẩm:");
            System.out.println("Danh sách các sản phẩm quần.");
            String header = String.format("%-10s%-30s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-20s%-10s%-20s%-20s%-20s","STT",
                    "Tên", "Giá Nhập", "Giá Bán", "Số lượng", "Size", "Màu Sắc", "Chất Liệu", "Xuất Xứ",
                    "Kiểu Dáng Quần", "Mẫu", "Loại Khóa", "Phong Cách", "Loại Quần");
            System.out.println(header);
            int i=0;
            for(Quan q : App.SANPHAMQUAN){
                String row = String.format("%-10d%-30s%-10.1f%-10.1f%-10d%-10s%-10s%-10s%-10s%-20s%-10s%-20s%-20s%-20s",i+1,
                        q.getTenSP(), q.getGiaNhap(), q.getGiaBan(), q.getSoLuong(), q.getSize(), q.getMau(), q.getChatLieu()
                        , q.getXuatXu(), q.getKieuDangQuan(), q.getMau(), q.getLoaiKhoa(), q.getPhongCach(), q.getLoaiQuan());
                System.out.println(row);
                i++;
            }

            System.out.println("Danh sách các sản phẩm Áo.");
            header = String.format("%-10s%-30s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-20s%-10s%-20s%-20s","STT",
                    "Tên", "Giá Nhập", "Giá Bán", "Số lượng", "Size", "Màu Sắc", "Chất Liệu", "Xuất Xứ",
                    "Cổ áo", "Mẫu Áo", "Chiều dài tay áo", "Loại áo");
            System.out.println(header);

            for(Ao a : App.SANPHAMAO){
                String row = String.format("%-10d%-30s%-10.1f%-10.1f%-10d%-10s%-10s%-10s%-10s%-20s%-10s%-20s%-20s",i+1,
                        a.getTenSP(), a.getGiaNhap(), a.getGiaBan(), a.getSoLuong(), a.getSize(), a.getMauSac(), a.getChatLieu()
                        , a.getXuatXu(), a.getCoAo(), a.getMauAo(), a.getChieuDaiTayAo(), a.getLoaiAo());
                System.out.println(row);
                i++;
            }

            System.out.println("Danh sách các sản phẩm Giay.");
            header = String.format("%-10s%-30s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-20s%-10s%-20s","STT",
                    "Tên", "Giá Nhập", "Giá Bán", "Số lượng", "Size", "Màu Sắc", "Chất Liệu", "Xuất Xứ",
                    "Kiểu cổ giày", "Dịp", "Loại Giày");
            System.out.println(header);

            for(Giay g : App.SANPHAMGIAY){
                String row = String.format("%-10d%-30s%-10.1f%-10.1f%-10d%-10s%-10s%-10s%-10s%-20s%-10s%-20s", i+1,
                        g.getTenSP(), g.getGiaNhap(), g.getGiaBan(), g.getSoLuong(), g.getSize(), g.getMauSac(), g.getChatLieu()
                        , g.getXuatXu(), g.getKieuCoGiay(), g.getDip(), g.getLoaiGiay());
                System.out.println(row);
                i++;
            }
            List<SanPhamVaSoLuong> sanPhamVaSoLuongList = new ArrayList<SanPhamVaSoLuong>();
            Quan quan = new Quan();
            Ao ao = new Ao();
            Giay giay = new Giay();
            Integer soLuongQuan = 0;
            Integer soLuongAo = 0;
            Integer soLuongGiay = 0;

            System.out.println("Nhập thông tin các sản phẩm cần bán.");
            Integer STTSanPham = 1;
            while(true) {
                System.out.println("Nhập thông tin các sản phẩm và số lượng( nhập '0' để thoát)");
                System.out.println("Nhập số thứ tự sản phẩm: ");
                STTSanPham = inputs.nextInt();
                if(STTSanPham == 0){
                    break;
                }
                System.out.println("Nhập số lượng:");
                Integer soLuong = inputs.nextInt();
                if(STTSanPham <= App.SANPHAMQUAN.size()){
                    Integer slq = App.SANPHAMQUAN.get(STTSanPham-1).getSoLuong();
                    if(soLuong > slq){
                        System.out.println("Sản phẩm trong kho không đủ, vui lòng nhập lại");
                        continue;
                    }
                    SanPhamVaSoLuong spvsl1 = new SanPhamVaSoLuong(App.SANPHAMQUAN.get(STTSanPham-1),ao,
                            giay, soLuong, soLuongAo, soLuongGiay);
                    sanPhamVaSoLuongList.add(spvsl1);
                    App.SANPHAMQUAN.get(STTSanPham-1).setSoLuong(slq - soLuong);
                } else {
                    if(STTSanPham <= App.SANPHAMQUAN.size() + App.SANPHAMAO.size()){
                        Integer sla = App.SANPHAMAO.get(STTSanPham-App.SANPHAMQUAN.size()-1).getSoLuong();
                        if(soLuong > sla){
                            System.out.println("Sản phẩm trong kho không đủ, vui lòng nhập lại");
                            continue;
                        }

                        SanPhamVaSoLuong spvsl2 = new SanPhamVaSoLuong(quan,App.SANPHAMAO.get(STTSanPham-App.SANPHAMQUAN.size()-1),giay,
                                soLuongQuan, soLuong, soLuongGiay);
                        sanPhamVaSoLuongList.add(spvsl2);
                        App.SANPHAMAO.get(STTSanPham-App.SANPHAMQUAN.size()-1).setSoLuong(sla - soLuong);
                    } else {
                        Integer slg = App.SANPHAMGIAY.get(STTSanPham-App.SANPHAMQUAN.size()
                                - App.SANPHAMAO.size()-1).getSoLuong();
                        if(soLuong > slg){
                            System.out.println("Sản phẩm trong kho không đủ, vui lòng nhập lại");
                            continue;
                        }

                        if(STTSanPham <= App.SANPHAMQUAN.size() + App.SANPHAMAO.size() + App.SANPHAMGIAY.size()){
                            SanPhamVaSoLuong spvsl3 = new SanPhamVaSoLuong(quan, ao,App.SANPHAMGIAY.get(STTSanPham-App.SANPHAMQUAN.size()-1
                                    - App.SANPHAMAO.size()), soLuongQuan, soLuongAo, soLuong);
                            sanPhamVaSoLuongList.add(spvsl3);
                            App.SANPHAMGIAY.get(STTSanPham-App.SANPHAMQUAN.size()
                                    - App.SANPHAMAO.size()-1).setSoLuong(slg - soLuong);
                        }
                    }
                }
            }

            inputs.nextLine();

            System.out.println("Nhập ngày:");
            String ngay = inputs.nextLine();

            System.out.println("Nhập tháng:");
            String thang = inputs.nextLine();

            System.out.println("Nhập năm:");
            String nam = inputs.nextLine();

            System.out.println("Tiền khách trả:");
            Double tienKhachTra = inputs.nextDouble();

            Double tongTien = 0.0;
            for(i=0;i<sanPhamVaSoLuongList.size();i++){
                tongTien = tongTien +
                        sanPhamVaSoLuongList.get(i).getSanPhamQuan().getGiaBan()*sanPhamVaSoLuongList.get(i).getSoLuongQuan()
                + sanPhamVaSoLuongList.get(i).getSanPhamAo().getGiaBan()*sanPhamVaSoLuongList.get(i).getSoLuongAo()
                + sanPhamVaSoLuongList.get(i).getSanPhamGiay().getGiaBan()*sanPhamVaSoLuongList.get(i).getSoLuongGiay();
            }
            Double tienTraLai = tienKhachTra-tongTien;
            HoaDon hoaDon = new HoaDon(sanPhamVaSoLuongList,nam,thang,ngay,tongTien,tienKhachTra,tienTraLai);
            App.HOADON.add(hoaDon);
            System.out.println("Hoàn thành.");
            System.out.println("Đã tạo xong hóa đơn.");

        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void show(){

        System.out.println("Danh sách hóa đơn:");
        for(int i=0;i<App.HOADON.size();i++) {
            String header = String.format("%s%d", "Hóa đơn ", i + 1);
            System.out.println(header);
            System.out.println("Các sản phẩm");
            for (int j = 0; j < App.HOADON.get(i).getSanPhamVaSoLuongs().size(); j++) {
                if(App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSoLuongQuan() > 0) {
                    Quan q = App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSanPhamQuan();
                    String row = String.format("%-10d%-30s%-10.1f%-10.1f%-10s%-10s%-10s%-10s%-20s%-10s%-20s%-20s%-20s", j + 1,
                            q.getTenSP(), q.getGiaNhap(), q.getGiaBan(), q.getSize(), q.getMau(), q.getChatLieu()
                            , q.getXuatXu(), q.getKieuDangQuan(), q.getMau(), q.getLoaiKhoa(), q.getPhongCach(), q.getLoaiQuan());
                    System.out.println(row);
                }
                if(App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSoLuongAo() > 0) {
                    Ao a = App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSanPhamAo();
                    String row = String.format("%-10d%-30s%-10.1f%-10.1f%-10s%-10s%-10s%-10s%-20s%-10s%-20s%-20s", j + 1,
                            a.getTenSP(), a.getGiaNhap(), a.getGiaBan(), a.getSize(), a.getMauSac(), a.getChatLieu()
                            , a.getXuatXu(), a.getCoAo(), a.getMauAo(), a.getChieuDaiTayAo(), a.getLoaiAo());
                    System.out.println(row);
                }

                if(App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSoLuongGiay() > 0) {
                    Giay g = App.HOADON.get(i).getSanPhamVaSoLuongs().get(j).getSanPhamGiay();
                    String row = String.format("%-10d%-30s%-10.1f%-10.1f%-10s%-10s%-10s%-10s%-20s%-10s%-20s", j + 1,
                            g.getTenSP(), g.getGiaNhap(), g.getGiaBan(), g.getSize(), g.getMauSac(), g.getChatLieu()
                            , g.getXuatXu(), g.getKieuCoGiay(), g.getDip(), g.getLoaiGiay());
                    System.out.println(row);
                }
            }
            System.out.println("Ngày " + App.HOADON.get(i).getNgay() + " Tháng " + App.HOADON.get(i).getThang() + " năm "
            + App.HOADON.get(i).getNam());
            System.out.println("Tổng tiền:" + App.HOADON.get(i).getTongTien());
            System.out.println("Tiền khách trả: " + App.HOADON.get(i).getTienKhachTra());
            System.out.println("Tiền trả lại: " + App.HOADON.get(i).getTienTraLai());
            System.out.println("-------------------------------------------------------------------------");
        }
    }

}
