package dangthpc04349_asm_final;

/**
 *
 * @author dangthpc04349
 */
public class Manager extends Employee {
    
    private double trach_nhiem;
    
    public Manager (String exam_code, String name, double salary,double trach_nhiem) {
        super(exam_code, name, "Trưởng phòng", salary);
        this.trach_nhiem = trach_nhiem;
    }
    
    public Manager() {
        
    }

    @Override
    public double getThu_nhap() {
        return this.getSalary() + this.trach_nhiem;
    }

    public double getTrach_nhiem() {
        return trach_nhiem;
    }

    public void setTrach_nhiem(double trach_nhiem) {
        this.trach_nhiem = trach_nhiem;
    }
    
    @Override
    public double getLuong_thuc_nhan() {
        if(this.getThu_nhap()<9000000)
            return this.getThu_nhap();
        if(this.getThu_nhap()<=15000000) 
            return this.getThu_nhap()- this.getThu_nhap()*0.1;
        return this.getThu_nhap()- this.getThu_nhap()*0.12;
    }
}
