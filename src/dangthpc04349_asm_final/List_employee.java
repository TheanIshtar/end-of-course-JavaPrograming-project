package dangthpc04349_asm_final;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author dangthpc04349
 */
public class List_employee {
    private ArrayList <Employee> arrL = new ArrayList<> ();
   
   public void nhap() {
        Scanner in = new Scanner(System.in);
        String name, exam_code, type;
        double salary;
        int i = 0;
        System.out.println("\tNhập danh sách nhân viên! ");
        while (true) {
            System.out.print("Chọn loại nhân viên (HC/TT/TP): ");
            type = in.nextLine();
                i++;
                if (type.equalsIgnoreCase("HC")) {
                    System.out.printf("Nhập mã số nhân viên thứ %d: ",i);
                    exam_code = in.nextLine();
                    System.out.printf("Nhập tên nhân viên thứ %d: ",i);
                    name = in.nextLine();
                    System.out.print("Nhập lương (nghìn VNĐ): ");
                    salary = in.nextDouble();
                    arrL.add(new Administrative(exam_code,name,salary));
                    in.nextLine();    
                } else if (type.equalsIgnoreCase("TT")) {
                    double doanh_so,hue_hong;
                    System.out.printf("Nhập mã số nhân viên thứ %d: ",i);
                    exam_code = in.nextLine();
                    System.out.printf("Nhập tên nhân viên thứ %d: ",i);
                    name = in.nextLine();
                    System.out.print("Nhập lương (nghìn VNĐ): ");
                    salary = in.nextDouble();
                    System.out.print("Nhập doanh số: ");
                    doanh_so = in.nextDouble();
                    System.out.print("Nhập huê hồng: ");
                    hue_hong = in.nextDouble();
                    arrL.add(new Marketer(exam_code,name,salary,doanh_so,hue_hong));
                    in.nextLine();    
                }
                else {
                    double luong_trach_nhiem;
                    System.out.printf("Nhập mã số nhân viên thứ %d: ",i);
                    exam_code = in.nextLine();
                    System.out.printf("Nhập tên nhân viên thứ %d: ",i);
                    name = in.nextLine();
                    System.out.print("Nhập lương (nghìn VNĐ): ");
                    salary = in.nextDouble();
                    System.out.print("Nhập lương trách nhiệm: ");
                    luong_trach_nhiem = in.nextDouble();
                    arrL.add(new Manager(exam_code,name,salary,luong_trach_nhiem));
                    in.nextLine();
                }
                
                System.out.println("\tBạn có muốn nhập tiếp không? (Y/N)");
                System.out.print("Lựa chọn bạn là: ");  
                if (in.nextLine().equalsIgnoreCase("N"))
                    break;
        }
    }
    
    public void xuat () {
        Scanner in = new Scanner(System.in);
        String type;
//        while (true) {
//            System.out.print("Chọn loại nhân viên (HC/TT/TP): ");
//            type = in.nextLine();
//            if (type.equalsIgnoreCase("HC") || type.equalsIgnoreCase("TT") || type.equalsIgnoreCase("TP"))
//                break;
//        }
        System.out.println("--------------------");
        System.out.println("Danh sách nhân viên!");
        
            System.out.println("Mã nhân viên - Tên - Lương - Doanh số - Huê hồng - Lương trách nhiệm");
        for( Employee i:arrL) {
            if (i instanceof Administrative) {
                //System.out.println("\t" + i.getExam_code() + ": " + i.getName() + " - " + i.getSalary());
                System.out.printf("\t %s : %s - %f - NULL - NULL - NULL\n",i.getExam_code(), i.getName(), i.getSalary());
            }
            if (i instanceof Marketer) {
                System.out.printf("\t %s : %s - %f - %f - %f - NULL\n",i.getExam_code(), i.getName(), i.getSalary(), ((Marketer) i).getDoanh_so(), ((Marketer) i).getHue_hong());
            }
            if (i instanceof Manager){
                System.out.printf("\t %s : %s - %f - NULL - NULL - %f \n",i.getExam_code(), i.getName(), i.getSalary() , ((Manager) i).getTrach_nhiem());
            }
        } 
    }
    
    public void find() {
        Scanner in = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("Tìm và hiển thị nhân viên theo mã nhập từ bàn phím!");
        System.out.print("Nhập mã nhân viên muốn tìm kiếm: ");
        String exam_find = in.nextLine();
        boolean check = false;
        for (Employee i:arrL) {
            if (i.getExam_code().equals(exam_find)) {
                if ( i instanceof Manager)
                    System.out.printf("\t %s : %s - %f - NULL - NULL - %f \n",i.getExam_code(), i.getName(), i.getSalary() , ((Manager) i).getTrach_nhiem());
                if ( i instanceof Marketer)
                    System.out.printf("\t %s : %s - %f - %f - %f - NULL\n",i.getExam_code(), i.getName(), i.getSalary(), ((Marketer) i).getDoanh_so(), ((Marketer) i).getHue_hong());
                if ( i instanceof Administrative)
                    System.out.printf("\t %s : %s - %f - NULL - NULL - NULL\n",i.getExam_code(), i.getName(), i.getSalary());
                check = true;
            }
        }
        if (check == false) 
            System.out.println("\t Không tồn tại dữ liệu đã nhập!");
    }

    public void xoa() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String exam_code = in.nextLine();
        Employee n = null;
        for(Employee i:arrL){
            if(i.getExam_code().equals(exam_code)){
                n=i;
            }
        }
        if(n!=null){
            arrL.remove(n);
            xuat();
        }
        else System.out.println("Không tìm thấy tên cần xóa");
        //xuat();
    }
    
    public void cap_nhat() {
        int d = 1;
        Scanner in = new Scanner(System.in);
        System.out.print("Nhập mã nhân viên cần chỉnh sửa: ");
        String exam_code = in.nextLine();
        Employee n = null;
        String name, type;
        double salary;
        for(Employee i:arrL){
            if(i.getExam_code().equals(exam_code)){
                n=i;
            }
        }
        if(n!=null){
            arrL.remove(n);
            System.out.println("Chọn loại nhân viên mới (HC/TT/TP): ");
            type = in.nextLine();
            if (type.equalsIgnoreCase("HC")) {
                    System.out.printf("Nhập mã số nhân viên mới: ");
                    exam_code = in.nextLine();
                    System.out.printf("Nhập tên nhân viên mới: ");
                    name = in.nextLine();
                    System.out.print("Nhập lương (nghìn VNĐ): ");
                    salary = in.nextDouble();
                    arrL.add(new Administrative(exam_code,name,salary));
                    in.nextLine();    
                } else if (type.equalsIgnoreCase("TT")) {
                    double doanh_so,hue_hong;
                    System.out.printf("Nhập mã số nhân viên mới: ");
                    exam_code = in.nextLine();
                    System.out.printf("Nhập tên nhân viên mới: ");
                    name = in.nextLine();
                    System.out.print("Nhập lương (nghìn VNĐ): ");
                    salary = in.nextDouble();
                    System.out.println("Nhập doanh số: ");
                    doanh_so = in.nextDouble();
                    System.out.println("Nhập huê hồng: ");
                    hue_hong = in.nextDouble();
                    arrL.add(new Marketer(exam_code,name,salary,doanh_so,hue_hong));
                    in.nextLine();    
                }
                else {
                    double luong_trach_nhiem;
                    System.out.printf("Nhập mã số nhân viên mới: ");
                    exam_code = in.nextLine();
                    System.out.printf("Nhập tên nhân viên mới: ");
                    name = in.nextLine();
                    System.out.print("Nhập lương (nghìn VNĐ): ");
                    salary = in.nextDouble();
                    System.out.println("Nhập lương trách nhiệm: ");
                    luong_trach_nhiem = in.nextDouble();
                    arrL.add(new Manager(exam_code,name,salary,luong_trach_nhiem));
                    in.nextLine();
                }
            xuat();
        }
        else System.out.println("Không tìm thấy tên cần chỉnh sửa");
        //xuat();
        d++;
    }
    
    public void khoang_luong() {
        Scanner in = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("Hiển thị sinh viên theo khoảng lương!");
        double start = 0, end = 0;
        do {
            System.out.print("Mời bạn nhập vào khoảng bắt đầu (min): ");
            start = in.nextDouble();
            System.out.print("Mời bạn nhập vào khoảng kết thúc (max): ");
            end = in.nextDouble();
            if (end>=start) 
                break;
            else 
                System.out.println("\tVui lòng kiểm tra lại dữ liệu!");
        } while (true);
        //check
        boolean check = false;
        for(Employee i:arrL) {
            if(i.getSalary()<=end && i.getSalary()>=start) {
                check = true;
            }
        }
        if (check) {
            System.out.println("\tTìm kiếm dữ liệu thành công!");
            System.out.println("Tên - Điểm");
            for(Employee i:arrL) {
                if(i.getSalary()<=end && i.getSalary()>=start) {
                    System.out.println(i.getExam_code() + " - " + i.getName() + " - " + i.getSalary());
                }
            }
        }
        else {
            System.out.printf("Không tồn tại lương trong khoảng từ %.1f - %.1f \n",start, end);
        }
    }
    
    public void sorts_name(){
        Collections.sort(arrL,(a,b)-> (int)(a.getName().compareTo(b.getName())));
        xuat();
    }
    
    public void sorts_earnings(){
        //Collections.sort(list, (a,b)-> (int) (b.getDiem()-a.getDiem()));
    Comparator<Employee> comp = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getEarnings(), o1.getEarnings());
            }
        };
        Collections.sort(arrL, comp);
        //xuat_thu_nhap();
        System.out.println("--------------------");
        System.out.println("Sắp xếp thành công!");
        System.out.println("Mã nhân viên - Tên - Lương - Thu nhập");
        //xuat_thu_nhap();
    }
    
    public void xuat_thu_nhap () {
        System.out.println("--------------------");
        System.out.println("Sắp xếp thành công!");
        System.out.println("Mã nhân viên - Tên - Lương - Thu nhập");
        for( Employee i:arrL) {
            //System.out.println("\t" + i.getExam_code() + ": " + i.getName() + " - " + i.getSalary());
            System.out.printf("\t %s : %s - %f - %f\n",i.getExam_code(), i.getName(), i.getSalary(),i.getEarnings());
        }
    }
    
//    public void sorts_5_earnings () {
//        sorts_earnings();
//        //xuat
//        System.out.println("--------------------");
//        System.out.println("tìm kiếm thành công!");
//        System.out.println("Mã nhân viên - Tên - Lương - Thu nhập");
//        int d = 0;
//        for( Employee i:arrL) {
//            //System.out.println("\t" + i.getExam_code() + ": " + i.getName() + " - " + i.getSalary());
//            System.out.printf("\t%d: %s : %s - %f - %f\n",d,i.getExam_code(), i.getName(), i.getSalary(),i.getEarnings());
//            d++;
//            if (d==5) 
//                break;
//        }
//    }
    
    public void sorts_5_earnings () {
        //sorts_earnings();
        //xuat
        int d = 0;
        ArrayList<Employee> cloned_list = new ArrayList<Employee>();
        cloned_list.addAll(arrL);
        //sort
        Comparator<Employee> comp = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getEarnings(), o1.getEarnings());
            }
        };
        Collections.sort(cloned_list, comp);
        //xuat_thu_nhap();
        System.out.println("--------------------");
        System.out.println("Sắp xếp thành công!");
        System.out.println("Mã nhân viên - Tên - Lương - Thu nhập");
        for(Employee i:cloned_list) {
            //System.out.println("\t" + i.getExam_code() + ": " + i.getName() + " - " + i.getSalary());
            System.out.printf("\t%d: %s : %s - %f - %f\n",d,i.getExam_code(), i.getName(), i.getSalary(),i.getEarnings());
            d++;
            if (d==5) 
                break;
        }
        cloned_list.clear();
    }
    
    public void menu() {
        Scanner in = new Scanner(System.in);
        String chon;
        do {
            System.out.println("\t\t\t\t\t   MENU CHUONG TRINH");
            System.out.println("\t\t+-------------------------------------------------------------------+");
            System.out.println("\t\t|    Nhập 1: Nhập danh sách nhân viên                               |");
            System.out.println("\t\t|    Nhập 2: Xuất danh sách nhân viên                               |");
            System.out.println("\t\t|    Nhập 3: Tìm và hiển thị nhân viên theo mã nhập từ bàn phím     |");
            System.out.println("\t\t|    Nhập 4: Xóa nhân viên theo mã nhập từ bàn phím                 |");
            System.out.println("\t\t|    Nhập 5: Cập nhật thông tin nhân viên theo mã nhập từ bàn phím  |");
            System.out.println("\t\t|    Nhập 6: Tìm các nhân viên theo khoảng lương nhập từ bàn phím   |");
            System.out.println("\t\t|    Nhập 7: Sắp xếp nhân viên theo họ và tên                       |");
            System.out.println("\t\t|    Nhập 8: Sắp xếp nhân viên theo thu nhập                        |");
            System.out.println("\t\t|    Nhập 9: Xuất 5 nhân viên có thu nhập cao nhất                  |");
            System.out.println("\t\t|    Nhập 0: Thoát khỏi MENU chương trình                           |");
            System.out.println("\t\t+-------------------------------------------------------------------+");
            System.out.print("Lựa chọn của bạn là: ");
            chon = in.nextLine();
            switch (chon) {
                case "0":
                    System.exit(0);
                case "1":
                    nhap();
                    break;
                case "2": 
                    xuat();
                    break;
                case "3":
                    find();
                    break;
                case "4":
                    xoa();
                    break;
                case "5":
                    cap_nhat();
                    break;
                case "6":
                    khoang_luong();
                    break;
                case "7":
                    sorts_name();
                    break;
                case "8":
                    sorts_earnings();
                    xuat_thu_nhap();
                case "9":
                    sorts_5_earnings ();
                default: 
                    System.out.println("Mời bạn nhập từ 0 -> 9");
            }
        }while(chon !="0");
    }
}
