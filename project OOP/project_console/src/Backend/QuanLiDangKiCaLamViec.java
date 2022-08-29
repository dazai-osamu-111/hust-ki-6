package Backend;

import Backend.App;
import Backend.DangKiCaLamViec;
import Backend.QuanLiCaLamViec;
import Backend.QuanliNhanVien;

import java.util.InputMismatchException;
import java.util.Scanner;

public  class QuanLiDangKiCaLamViec {
    public void insert(){
        try {
            Scanner inputs = new Scanner(System.in);
            // Nhập thông tin của ca làm việc
            System.out.println("Nhập thông tin đăng kí ca làm việc...: ");

            System.out.println("Danh sách ca làm việc:");
            String header = String.format("%-10s%-20s%-20s%-20s","STT", "Ngày", "Giờ bắt đầu", "Giờ kết thúc");
            System.out.println(header);
            for(int i = 0; i< App.CALAMVIEC.size(); i++){
                String row = String.format("%-10d%s-%s-%-16s%-20s%-20s", i+1, App.CALAMVIEC.get(i).getNam(),App.CALAMVIEC.get(i).getThang(),
                        App.CALAMVIEC.get(i).getNgay(), App.CALAMVIEC.get(i).getGioBatDau(), App.CALAMVIEC.get(i).getGioKetThuc());
                System.out.println(row);
            }

            System.out.println("Danh sách nhân viên:");
            header = String.format("%-10s%-20s%-20s%-20s","STT", "Họ và tên", "Số điện thoại", "Lương");
            System.out.println(header);
            for(int i=0;i<App.NHANVIEN.size();i++){
                String row = String.format("%-10d%-20s%-20s%-20d", i+1, App.NHANVIEN.get(i).getTenNV(),App.NHANVIEN.get(i).getSđt(),
                        App.NHANVIEN.get(i).getLuong());
                System.out.println(row);
            }

            System.out.println("Nhập số thứ tự ca làm việc: ");
            Integer STTCaLamViec = inputs.nextInt();
            System.out.println("Nhập số thứ tự nhân viên:");
            Integer STTNhanVien = inputs.nextInt();

            DangKiCaLamViec dkclv = new DangKiCaLamViec(App.CALAMVIEC.get(STTCaLamViec-1), App.NHANVIEN.get(STTNhanVien-1));

            int check = 0;

            for(int i=0;i<App.DANGKICALAMVIEC.size();i++){
                if(checkIteration(App.DANGKICALAMVIEC.get(i), dkclv)){
                    System.out.println("Thông tin đăng kí đã tồn tại");
                    return;
                }
            }
            App.DANGKICALAMVIEC.add(dkclv);
            System.out.println("Hoàn thành");


        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

        public void update(){
            try {
                Scanner inputs = new Scanner(System.in);
                // Nhập thông tin của ca làm việc
                System.out.println("Nhập thông tin đăng kí ca làm việc...: ");

                System.out.println("Danh sách ca làm việc:");
                String header = String.format("%-10s%-20s%-20s%-20s","STT", "Ngày", "Giờ bắt đầu", "Giờ kết thúc");
                System.out.println(header);
                for(int i = 0; i< App.CALAMVIEC.size(); i++){
                    String row = String.format("%-10d%s-%s-%-16s%-20s%-20s", i+1, App.CALAMVIEC.get(i).getNam(),App.CALAMVIEC.get(i).getThang(),
                            App.CALAMVIEC.get(i).getNam(), App.CALAMVIEC.get(i).getGioBatDau(), App.CALAMVIEC.get(i).getGioKetThuc());
                    System.out.println(row);
                }

                System.out.println("Danh sách nhân viên:");
                header = String.format("%-10s%-20s%-20s%-20s","STT", "Họ và tên", "Số điện thoại", "Lương");
                System.out.println(header);
                for(int i=0;i<App.NHANVIEN.size();i++){
                    String row = String.format("%-10d%-20s%-20s%-20d", i+1, App.NHANVIEN.get(i).getTenNV(),App.NHANVIEN.get(i).getSđt(),
                            App.NHANVIEN.get(i).getLuong());
                    System.out.println(row);
                }

                System.out.println("Danh sách đăng kí");
                show();

                System.out.println("Chọn ca đăng kí cần sửa:");
                Integer STTCaDK = inputs.nextInt();

                System.out.println("Nhập số thứ tự ca làm việc: ");
                Integer STTCaLamViec = inputs.nextInt();
                System.out.println("Nhập số thứ tự nhân viên:");
                Integer STTNhanVien = inputs.nextInt();

                DangKiCaLamViec dkclv = new DangKiCaLamViec(App.CALAMVIEC.get(STTCaLamViec-1), App.NHANVIEN.get(STTNhanVien-1));

                if(STTCaDK > 0 && STTCaDK <= App.DANGKICALAMVIEC.size()){
                    App.DANGKICALAMVIEC.get(STTCaDK-1).setCaLamViec(App.CALAMVIEC.get(STTCaLamViec-1));
                    App.DANGKICALAMVIEC.get(STTCaDK-1).setNhanVien(App.NHANVIEN.get(STTNhanVien-1));
                } else {
                    System.out.println("Số thứ tự không phù hợp.");
                    return;
                }

                System.out.println("Hoàn thành");


            }   catch (InputMismatchException ei) {
                System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        public void delete(){
            try {
                Scanner inputs = new Scanner(System.in);

                System.out.println("Danh sách đăng kí");
                show();

                System.out.println("Chọn ca đăng kí cần xóa:");
                Integer STTCaDK = inputs.nextInt();

                if(STTCaDK > 0 && STTCaDK <= App.DANGKICALAMVIEC.size()){
                    App.DANGKICALAMVIEC.remove(STTCaDK-1);
                    System.out.println("Đã xóa");
                } else{
                    System.out.println("không tìm thấy thông tin.");
                }


            }   catch (InputMismatchException ei) {
                System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    public void show(){
        System.out.println("Danh sách đăng kí ca làm việc");
        String header = String.format("%-10s%-50s%-50s", "STT","Nhân viên", "Ca đăng kí");
        System.out.println(header);
        for(int i=0;i<App.DANGKICALAMVIEC.size();i++){
            DangKiCaLamViec dkclv = App.DANGKICALAMVIEC.get(i);
            String row = String.format("%-10d%-20s%-20s%-20d", i+1, dkclv.getNhanVien().getTenNV(), dkclv.getNhanVien().getSđt()
                    , dkclv.getNhanVien().getLuong());
            System.out.print(row);

            row = String.format("%s-%s-%-16s%-20s%-20s", dkclv.getCaLamViec().getNam(),dkclv.getCaLamViec().getThang(),
                    dkclv.getCaLamViec().getNgay(), dkclv.getCaLamViec().getGioBatDau(), dkclv.getCaLamViec().getGioKetThuc());
            System.out.println(row);
        }
    }

    public boolean checkIteration(DangKiCaLamViec d1, DangKiCaLamViec d2){
        QuanliNhanVien qlnv = new QuanliNhanVien();
        QuanLiCaLamViec qlclv = new QuanLiCaLamViec();
        if(qlnv.checkNVIteration(d1.getNhanVien(), d2.getNhanVien()) && qlclv.checkIteration(d1.getCaLamViec(), d2.getCaLamViec())){
            return true;
        } else return false;
    }
}
