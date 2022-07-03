package dangthpc04349_asm_final;

/**
 *
 * @author dangthpc04349
 */
public class Administrative extends Employee{
    public Administrative(String exam_code, String name, double salary){
        super(exam_code, name,"Hành Chính", salary);
    }

    public Administrative() {
    }

    

    @Override
    public double getLuong_thuc_nhan() {
        if(this.getThu_nhap()<9000000)
            return this.getThu_nhap();
        if(this.getThu_nhap()<=15000000) 
            return this.getThu_nhap()*0.1;
        return this.getThu_nhap()*0.12;
    }

    @Override
    public double getThu_nhap() {
        return this.getSalary();
    }
}
