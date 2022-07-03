package dangthpc04349_asm_final;

/**
 *
 * @author dangthpc04349
 */
public class Marketer extends Employee  {
    
    private double doanh_so;
    private double hue_hong;
    
    public Marketer (String exam_code, String name, double salary, double doanh_so, double hue_hong) {
        super(exam_code, name, "Hành chính", salary);
        this.doanh_so = doanh_so;
        this.hue_hong = hue_hong;
    }

    public double getDoanh_so() {
        return doanh_so;
    }

    public void setDoanh_so(double doanh_so) {
        this.doanh_so = doanh_so;
    }

    public double getHue_hong() {
        return hue_hong;
    }

    public void setHue_hong(double hue_hong) {
        this.hue_hong = hue_hong;
    }
    
    

    @Override
    public double getThu_nhap() {
        return this.getSalary()+ this.doanh_so+this.hue_hong;
    }

    @Override
    public double getLuong_thuc_nhan() {
        if(this.getThu_nhap()<9000000)
            return this.getThu_nhap();
        if(this.getThu_nhap()<=15000000) 
            return this.getThu_nhap()*0.1;
        return this.getThu_nhap()*0.12;
    }
}
