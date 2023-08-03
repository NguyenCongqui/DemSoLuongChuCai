/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demsoluongchucai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class DemSoLuongChuCai {

    /**
     * @param args the command line arguments
     */
    public static List<String> demSoLuongChu(String inputString) {
        // Định nghĩa bảng chữ cái Tiếng Việt Telex và tương ứng chữ cái Latin
        Map<String, Character> demSo = new HashMap<>();
        demSo.put("aw", 'ă');
        demSo.put("aa", 'â');
        demSo.put("dd", 'đ');
        demSo.put("ee", 'ê');
        demSo.put("oo", 'ô');
        demSo.put("ow", 'ơ');
        demSo.put("uw", 'ư');
        // Danh sách chứa các ký tự Telex mà chúng ta tìm thấy trong chuỗi đầu vào
        List<String> list = new ArrayList<>();
        // Biến i sẽ đại diện cho chỉ số duyệt qua chuỗi đầu vào
        int i = 0;

        while (i < inputString.length()) {
            boolean found = false;
            // Duyệt qua các độ dài từ 2 đến 3 ký tự để tìm các ký tự Telex
            for (int length = 2; length <= 3 && i + length <= inputString.length(); length++) {
                // Lấy một phần chuỗi con từ vị trí i với độ dài length
                String substr = inputString.substring(i, i + length);
                // Kiểm tra xem chuỗi con này có trong bảng chữ cái Tiếng Việt Telex hay không
                if (demSo.containsKey(substr)) {
                    // Nếu tìm thấy, thêm chuỗi con vào danh sách các ký tự Telex đã tìm thấy
                    list.add(substr);
                    // Di chuyển vị trí i lên đến sau chuỗi con đã tìm thấy để tiếp tục duyệt
                    i += length;
                    // Đánh dấu là đã tìm thấy một ký tự Telex
                    found = true;
                    break;
                }
            }
            // Nếu không tìm thấy ký tự Telex, di chuyển i lên 1 ký tự
            if (!found) {
                i++;
            }
        }
    // Trả về danh sách các ký tự Telex đã tìm thấy trong chuỗi đầu vào
        return list;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        // Nhập chuỗi chữ cái Latin từ bàn phím
        System.out.println("moi ban nhap chu cai:");
        String nhap = scanner.nextLine();
        // Tìm và đếm các ký tự Telex trong chuỗi đầu vào
        List<String> listlatin = demSoLuongChu(nhap);
        int count = listlatin.size();
        String output = String.join(", ", listlatin);
// Xuất kết quả đếm và danh sách ký tự Telex đã tìm thấy
        System.out.println("Output: " + count + " (" + output + ")");
        scanner.close();
    }

}
