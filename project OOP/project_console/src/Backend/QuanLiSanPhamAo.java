package Backend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLiSanPhamAo {
    public void insert(){
        try {
            // Nhập thông tin của sản phẩm
            System.out.println("Nhập thông tin sản phẩm: ");
            Scanner inputs = new Scanner(System.in);

            System.out.print("Nhập tên sản phẩm: ");
            String tenSP = inputs.nextLine();

            System.out.print("Giá nhập: ");
            Double giaNhap = inputs.nextDouble();

            System.out.print("Giá bán: ");
            Double giaBan = inputs.nextDouble();

            System.out.print("Số lượng: ");
            Integer soLuong = inputs.nextInt();


            inputs.nextLine();

            System.out.print("Size: ");
            String size = inputs.nextLine();

            System.out.print("Màu Sắc: ");
            String mauSac = inputs.nextLine();

            System.out.print("Chất liệu:");
            String chatLieu = inputs.nextLine();

            System.out.print("Xuất xứ:");
            String xuatXu = inputs.nextLine();

            System.out.print("Cổ áo: ");
            String coAo = inputs.nextLine();

            System.out.print("Mẫu Áo: ");
            String mauAo = inputs.nextLine();

            System.out.print("Chiếu dài tay áo: ");
            String chieuDaiTayAo = inputs.nextLine();

            System.out.print("Loại Áo: ");
            String loaiAo = inputs.nextLine();

            System.out.println("Ngày nhập: ");
            String ngayNhap = inputs.nextLine();

            System.out.println("Tháng nhập: ");
            String thangNhap = inputs.nextLine();

            System.out.println("Năm nhập: ");
            String namNhap = inputs.nextLine();


            Ao ao = new Ao(tenSP, giaNhap, giaBan, soLuong, size, mauSac, chatLieu, xuatXu,
                    coAo, mauAo, chieuDaiTayAo, loaiAo, ngayNhap, thangNhap, namNhap);

            for(int i=0;i<App.SANPHAMAO.size();i++){
                if(checkIteration(App.SANPHAMAO.get(i), ao)){
                    int soluong = App.SANPHAMAO.get(i).getSoLuong();
                    App.SANPHAMAO.get(i).setSoLuong(soluong + soLuong);
                    System.out.println("Đã thêm sản phẩm thành công.");
                    return;
                }
            }

            App.SANPHAMAO.add(ao);
            System.out.println("Đã thêm sản phẩm thành công.");


        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



    public void show(){
        System.out.println("Danh sách các sản phẩm Áo.");
        String header = String.format("%-5s%-20s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-20s%-10s%-20s%-20s%-20s","STT",
                "Tên", "Giá Nhập", "Giá Bán", "Số lượng", "Size", "Màu Sắc", "Chất Liệu", "Xuất Xứ",
                "Cổ áo", "Mẫu Áo", "Chiều dài tay áo", "Loại áo", "Ngày nhập");
        System.out.println(header);
        int i = 0;
        for(Ao a : App.SANPHAMAO){
            String row = String.format("%-5d%-20s%-10.1f%-10.1f%-10d%-10s%-10s%-10s%-10s%-20s%-10s%-20s%-20s%s-%s-%s", i+1,
                    a.getTenSP(), a.getGiaNhap(), a.getGiaBan(), a.getSoLuong(), a.getSize(), a.getMauSac(), a.getChatLieu()
                    , a.getXuatXu(), a.getCoAo(), a.getMauAo(), a.getChieuDaiTayAo(), a.getLoaiAo(), a.getNgayNhap(),
                    a.getThangNhap(), a.getNamNhap());
            System.out.println(row);
            i++;
        }
    }

    public void update(){
        try {
            Scanner inputs = new Scanner(System.in);
            System.out.println("Danh sách sản phẩm");
            show();
            System.out.println("Chọn số thứ tự sản phẩm cần chỉnh sửa thông tin: ");
            int stt = inputs.nextInt();
            inputs.nextLine();
            if(stt > 0 && stt <= App.SANPHAMAO.size()){
                System.out.println("Nhập thông tin chỉnh sửa cho sản phẩm");

                System.out.print("Nhập tên sản phẩm: ");
                String tenSP = inputs.nextLine();
                App.SANPHAMAO.get(stt -1).setTenSP(tenSP);

                System.out.print("Giá nhập: ");
                Double giaNhap = inputs.nextDouble();
                App.SANPHAMAO.get(stt -1).setGiaNhap(giaNhap);

                System.out.print("Giá bán: ");
                Double giaBan = inputs.nextDouble();
                App.SANPHAMAO.get(stt -1).setGiaBan(giaBan);

                System.out.print("Số lượng: ");
                Integer soLuong = inputs.nextInt();
                App.SANPHAMAO.get(stt -1).setSoLuong(soLuong);

                inputs.nextLine();

                System.out.print("Size: ");
                String size = inputs.nextLine();
                App.SANPHAMAO.get(stt -1).setSize(size);

                System.out.print("Màu Sắc: ");
                String mauSac = inputs.nextLine();
                App.SANPHAMAO.get(stt -1).setMauSac(mauSac);

                System.out.print("Chất liệu:");
                String chatLieu = inputs.nextLine();
                App.SANPHAMAO.get(stt -1).setChatLieu(chatLieu);

                System.out.print("Xuất xứ:");
                String xuatXu = inputs.nextLine();
                App.SANPHAMAO.get(stt -1).setXuatXu(xuatXu);

                System.out.print("Cổ áo: ");
                String coAo = inputs.nextLine();
                App.SANPHAMAO.get(stt -1).setCoAo(coAo);

                System.out.print("Mẫu áo: ");
                String  mauAo = inputs.nextLine();
                App.SANPHAMAO.get(stt -1).setMauAo(mauAo);

                System.out.print("Chiều dài tay áo: ");
                String chieuDaiTayAo = inputs.nextLine();
                App.SANPHAMAO.get(stt -1).setChieuDaiTayAo(chieuDaiTayAo);

                System.out.print("Loại áo: ");
                String loaiAo = inputs.nextLine();
                App.SANPHAMAO.get(stt -1).setLoaiAo(loaiAo);

                System.out.println("Ngày nhập: ");
                String ngayNhap = inputs.nextLine();
                App.SANPHAMAO.get(stt - 1).setNgayNhap(ngayNhap);

                System.out.println("Tháng nhập: ");
                String thangNhap = inputs.nextLine();
                App.SANPHAMAO.get(stt - 1).setThangNhap(thangNhap);

                System.out.println("Năm nhập: ");
                String namNhap = inputs.nextLine();
                App.SANPHAMAO.get(stt - 1).setNamNhap(namNhap);


                System.out.println("Đã cập nhật thông tin  sản phẩm.");
            } else {
                System.out.println("Số thứ tự không phù hợp.");
            }
            return;
        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void delete(){

        try {
            Scanner inputs = new Scanner(System.in);
            System.out.println("Danh sách sản phẩm");
            show();
            System.out.println("Chọn số thứ tự sản phẩm cần chỉnh sửa thông tin: ");
            int stt = inputs.nextInt();

            if(stt > 0 && stt <= App.SANPHAMAO.size()){
                App.SANPHAMAO.remove(stt -1);
                System.out.println("Đã xóa sản phẩm.");
            } else {
                System.out.println("Số thứ tự không phù hợp.");
            }

        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean checkIteration(Ao a1, Ao a2){
        boolean check ;

        if(a1.getTenSP().equals(a2.getTenSP()) && a1.getGiaNhap().equals(a2.getGiaNhap()) && a1.getGiaBan().equals(a2.getGiaBan())
                 && a1.getSize().equals(a2.getSize() ) &&
                a1.getMauSac().equals(a2.getMauSac()) && a1.getChatLieu().equals(a2.getChatLieu()) &&
                a1.getXuatXu().equals(a2.getXuatXu())
                && a1.getCoAo().equals(a2.getCoAo()) && a1.getMauAo().equals(a2.getMauAo() )
                && a1.getChieuDaiTayAo().equals(a2.getChieuDaiTayAo()) &&
                a1.getLoaiAo().equals(a2.getLoaiAo()) && a1.getNgayNhap().equals(a2.getNgayNhap())
                && a1.getThangNhap().equals(a2.getThangNhap()) && a1.getNamNhap().equals(a2.getNamNhap())){
            check = true;
        } else {
            check = false;
        }

        return check;
    }


}
