package Backend;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class QuanliNhanVien {

    public void insert(){
        try {
            // Nhập thông tin của sản phẩm
            System.out.println("Nhập thông tin nhân viên: ");
            Scanner inputs = new Scanner(System.in);

            
            System.out.print("Nhập tên nhân viên: ");
            String tenNV = inputs.nextLine();

            System.out.print("Số điện thoại: ");
            String sđt = inputs.nextLine();

            System.out.print("Lương( trên 1h làm việc): ");
            Integer luong = inputs.nextInt();
            


            NhanVien nhanvien = new NhanVien(tenNV, sđt, luong);
            int check = 0;
            for(int i=0;i<App.NHANVIEN.size();i++){
                if(App.NHANVIEN.get(i).equals(nhanvien)){
                    check++;
                }
            }
            if(check == 0){
                App.NHANVIEN.add(nhanvien);
                System.out.println("Đã thêm nhân viên thành công.");
            } else{
                System.out.println("Thông tin đã tồn tại, vui lòng nhập lại");
            }



        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(){
        try {
            // Nhập thông tin của sản phẩm
            System.out.println("Nhập thông tin nhân viên: ");
            Scanner inputs = new Scanner(System.in);


            System.out.print("Nhập tên nhân viên: ");
            String tenNV = inputs.nextLine();

            System.out.print("Số điện thoại: ");
            String sđt = inputs.nextLine();

            Integer luong = 0;

            NhanVien nhanvien = new NhanVien(tenNV, sđt, luong);
            int check = 0;
            for(int i=0;i<App.NHANVIEN.size();i++){
                if(checkNVIteration(App.NHANVIEN.get(i), nhanvien)){
                    System.out.println("Nhập thông tin cập nhật cho nhân viên: ");

                    System.out.print("Nhập tên nhân viên: ");
                    tenNV = inputs.nextLine();
                    App.NHANVIEN.get(i).setTenNV(tenNV);

                    System.out.print("Số điện thoại: ");
                    sđt = inputs.nextLine();
                    App.NHANVIEN.get(i).setSđt(sđt);

                    System.out.print("Lương( trên 1h làm việc): ");
                    luong = inputs.nextInt();
                    App.NHANVIEN.get(i).setLuong(luong);

                    System.out.println("Đã cập nhật thông tin thành công");
                    return;
                }
            }

            System.out.println("Không tìm thấy nhân viên này");

        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(){
        try {
            // Nhập thông tin của sản phẩm
            System.out.println("Nhập thông tin nhân viên: ");
            Scanner inputs = new Scanner(System.in);


            System.out.print("Nhập tên nhân viên: ");
            String tenNV = inputs.nextLine();

            System.out.print("Số điện thoại: ");
            String sđt = inputs.nextLine();

            Integer luong = 0;


            NhanVien nhanvien = new NhanVien(tenNV, sđt, luong);
            for(int i=0;i<App.NHANVIEN.size();i++){
                if(checkNVIteration(App.NHANVIEN.get(i),nhanvien)){
                    App.NHANVIEN.remove(i);
                    System.out.println("Đã xóa thông tin nhân viên");
                    return;
                }
            }
            System.out.println("Không tìm thấy thông tin nhân viên");




        }   catch (InputMismatchException ei) {
            System.out.println("Bạn nhập sai giá trị, vui lòng nhập lại.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void show(){
        System.out.println("Danh sách nhân viên:");
        String header = String.format("%-20s%-20s%-20s", "Họ và tên", "Số điện thoại", "Lương");
        System.out.println(header);
        for(int i=0;i<App.NHANVIEN.size();i++){
            String row = String.format("%-20s%-20s%-20d", App.NHANVIEN.get(i).getTenNV(),App.NHANVIEN.get(i).getSđt(),
                    App.NHANVIEN.get(i).getLuong());
            System.out.println(row);
        }
    }

    public boolean checkNVIteration(NhanVien nv1, NhanVien nv2){
        if(nv1.getTenNV().equals(nv2.getTenNV()) && nv1.getSđt().equals(nv2.getSđt())){
            return true;
        } else {
            return false;
        }
    }

}
