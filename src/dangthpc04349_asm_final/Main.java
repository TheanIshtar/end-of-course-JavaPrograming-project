package dangthpc04349_asm_final;
/*
Giai đoạn 2: Thực hiện viết mã.
Xây dựng lớp NhanVien mô tả nhân viên hành chính.
Sử dụng ArrayList<NhanVien> để nắm giữ danh sách nhân viên nhập từ bàn phím.
Bổ sung mã nguồn vào các hàm chức năng đã dựng ở giai đoạn 1 để hoàn thiện
việc quản lý nhân viên hành chính.

Y1. Nhập danh sách nhân viên từ bàn phím.
Y2. Xuất danh sách nhân viên ra màn hình.
Y3. Tìm và hiển thị nhân viên theo mã nhập từ bàn phím.
Y4. Xóa nhân viên theo mã nhập từ bàn phím.
Y5. Cập nhật thông tin nhân viên theo mã nhập từ bàn phím
Y6. Tìm các nhân viên theo khoảng lương nhập từ bàn phím.
Y7. Sắp xếp nhân viên theo họ và tên.
Y8. Sắp xếp nhân viên theo thu nhập.
Y9. Xuất 5 nhân viên có thu nhập cao nhất
*/


/**
 * @author dangthpc04349
 */


public class Main {
    public static void main(String[] args) {
        List_employee employee = new List_employee (); 
        employee.menu();
    }
    
}
