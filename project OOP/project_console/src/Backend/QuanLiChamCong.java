package Backend;

import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QuanLiChamCong {
    public void insert(){
        try {
            Scanner inputs = new Scanner(System.in);
            QuanLiDangKiCaLamViec qldkclv = new QuanLiDangKiCaLamViec();
            qldkclv.show();
            System.out.println("Chọn các ca làm việc đăng kí đạt yêu cầu...");
            Integer STT = 1;
            while(STT>0){
                System.out.println("Chọn ca đăng kí đạt yêu cầu( chọn 0 để thoát)");
                STT = inputs.nextInt();
                if(STT > 0 && STT <= App.DANGKICALAMVIEC.size()) {
                    App.CONG.add(App.DANGKICALAMVIEC.get(STT - 1));
                    System.out.println("Đã thêm ca đăng kí này.");
                } else if(STT != 0){
                    System.out.println("Số thứ tự không phù hợp.");
                }
            }
            System.out.println("Hoàn thành chấm công");


        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void show(){
        try {

            System.out.println("-----Danh sách chấm công---------");

            String header = String.format("%-10s%-75s%-60s", "STT", "Ca làm việc", "Nhân viên");
            System.out.println(header);

            for(int i=0;i<App.CONG.size();i++){
                DangKiCaLamViec dkclv = App.CONG.get(i);
                String  row = String.format("%-10d%s-%s-%-16s%-20s%-20s|%-20s%-15s%-10d", i+1, dkclv.getCaLamViec().getNam(),dkclv.getCaLamViec().getThang(),
                dkclv.getCaLamViec().getNgay(), dkclv.getCaLamViec().getGioBatDau(), dkclv.getCaLamViec().getGioKetThuc(),
                        dkclv.getNhanVien().getTenNV(), dkclv.getNhanVien().getSđt(), dkclv.getNhanVien().getLuong());
                System.out.println(row);
            }


        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(){
        try {
            Scanner inputs = new Scanner(System.in);
            Integer STT = 5;
            show();
            inputs.nextLine();
            while(STT > 0) {
                System.out.println("Chọn STT công muốn xóa:( chọn 0 để thoát) ");
                STT = inputs.nextInt();
                if (STT > 0 && STT <= App.CONG.size()) {
                    App.CONG.remove(STT - 1);
                    System.out.println("Đã xóa công này");
                } else if(STT != 0){
                    System.out.println("Số thứ tự không phù hợp");
                }
            }


        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void tinhLuong(){
        List<DangKiCaLamViec> congTrongThang = new ArrayList<DangKiCaLamViec>();
        Scanner inputs = new Scanner(System.in);
        System.out.println("Nhập năm:");
        String nam = inputs.nextLine();
        System.out.println("Nhập tháng:");
        String thang = inputs.nextLine();
        System.out.println("Danh sách lương của nhân viên trong tháng " + thang + " Năm " + nam );
        Integer sum=0;
        for(int i=0;i<App.CONG.size();i++){
            if(App.CONG.get(i).getCaLamViec().getNam().equals(nam) && App.CONG.get(i).getCaLamViec().getThang().equals(thang)){
                congTrongThang.add(App.CONG.get(i));
            }
        }
        QuanliNhanVien qlnv = new QuanliNhanVien();
        String header = String.format("%-20s%-20s%-20s", "Họ và tên", "Số điện thoại", "Lương");
        System.out.println(header);
        for(int i=0;i<App.NHANVIEN.size();i++){
            for(int j=0;j<congTrongThang.size();j++){
                if(qlnv.checkNVIteration(congTrongThang.get(j).getNhanVien(), App.NHANVIEN.get(i))){
                    sum = sum + App.NHANVIEN.get(i).getLuong() * 5;
                }
            }
            String row = String.format("%-20s%-20s%-20d", App.NHANVIEN.get(i).getTenNV(),App.NHANVIEN.get(i).getSđt(), sum);
            sum = 0;
            System.out.println(row);

        }

    }

}
