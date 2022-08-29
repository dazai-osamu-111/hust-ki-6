/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLICUAHANGXEMAYGUI.report;

import QUANLICUAHANGXEMAYDAL.DataAccessHelper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author duy
 */
public class Report {

    public static String s1 , thang="12" , nam="2016";
    public static int number=4 ;

    public static void InHoaDon() throws FileNotFoundException, JRException {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QUANLYCUAHANGXEMAY;user=sa;password=123456";
            Connection conn = DriverManager.getConnection(dbURL);

            JasperReport report = JasperCompileManager.compileReport("src/QUANLICUAHANGXEMAYGUI/report/HoaDonKH.jrxml");

            InputStream is = new FileInputStream("src/QUANLICUAHANGXEMAYGUI/report/HoaDonKH.jasper");
            Hashtable hash = new Hashtable();

            hash.put("maHD", s1);
            try {
                JasperPrint print = JasperFillManager.fillReport(report, hash, conn);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                System.out.println("Lỗi " + e);
            }

        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }

    public static void XuatHang() throws FileNotFoundException, JRException {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QUANLYCUAHANGXEMAY;user=sa;password=123456";
            Connection conn = DriverManager.getConnection(dbURL);

            JasperReport report = JasperCompileManager.compileReport("src/QUANLICUAHANGXEMAYGUI/report/rptXuatHang.jrxml");

            Hashtable hash = new Hashtable();

            hash.put("ngayXuat", nam);
            try {
                JasperPrint print = JasperFillManager.fillReport(report, hash, conn);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                System.out.println("Lỗi " + e);
            }

        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }

    public static void HangTonKho() throws FileNotFoundException, JRException {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QUANLYCUAHANGXEMAY;user=sa;password=123456";
            Connection conn = DriverManager.getConnection(dbURL);

            JasperReport report = JasperCompileManager.compileReport("src/QUANLICUAHANGXEMAYGUI/report/rptHangTonKho.jrxml");

            Hashtable hash = new Hashtable();

            try {
                JasperPrint print = JasperFillManager.fillReport(report, hash, conn);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                System.out.println("Lỗi " + e);
            }

        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }

    public static void DoanhThu() throws FileNotFoundException, JRException {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QUANLYCUAHANGXEMAY;user=sa;password=123456";
            Connection conn = DriverManager.getConnection(dbURL);

            JasperReport report = JasperCompileManager.compileReport("src/QUANLICUAHANGXEMAYGUI/report/rptDoanhThu.jrxml");

            Hashtable hash = new Hashtable();

            hash.put("thang", thang);
            hash.put("nam",nam);
            try {
                JasperPrint print = JasperFillManager.fillReport(report, hash, conn);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                System.out.println("Lỗi " + e);
            }

        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }
    public static void TheoDoiNV() throws FileNotFoundException, JRException {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QUANLYCUAHANGXEMAY;user=sa;password=123456";
            Connection conn = DriverManager.getConnection(dbURL);

            JasperReport report = JasperCompileManager.compileReport("src/QUANLICUAHANGXEMAYGUI/report/rptNVBanHang.jrxml");

            Hashtable hash = new Hashtable();

            hash.put("thang", thang);
            hash.put("nam",nam);
            try {
                JasperPrint print = JasperFillManager.fillReport(report, hash, conn);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                System.out.println("Lỗi " + e);
            }

        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }
    public static void main(String[] args) throws FileNotFoundException, JRException {

        if (number == 0) {
            InHoaDon();
        } else if (number == 1) {
            HangTonKho();
        } else if (number == 2) {
            XuatHang();
        } else if (number == 3) {
               DoanhThu();
        }
        else if(number==4)
        {
            TheoDoiNV();
        }

    }
}
