package dangthpc04349_asm_final;

/**
 * @author dangthpc04349
 */
public abstract class Employee {
    private String name;
    private String exam_code;
    private double salary;
    private double tax;
    private double earnings;
    private String type;
    
    
    
    public double getTax() {
        if (this.salary >15000000)
            return this.salary * 0.12;
        if (this.salary <=15000000 && this.salary>=9000000)
            return this.salary * 0.1;
        return 0;
    }
    
    public double getEarnings() {
        return this.salary - getTax();
    }
    
    public Employee() {
        this.exam_code = null;
        this.name = null;
        this.type = null;
        this.salary = 0;
    }

    public Employee(String exam_code,String name , double salary) {
        this.exam_code = exam_code;
        this.name = name;
        this.salary = salary;
    }
    
    public Employee(String name,String exam_code) {
        this.name = name;
        this.exam_code = exam_code;
        this.salary = salary;
    }
    
    public Employee(String exam_code, String name, String type, double salary) {
        this.type = type;
        this.name = name;
        this.exam_code = exam_code;
        this.salary = salary;
    }
    
    public Employee(String exam_code, double slary) {
        this.exam_code = exam_code;
        this.salary = salary;
    }
    
    public Employee(String exam_code) {
        this.exam_code = exam_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExam_code() {
        return exam_code;
    }

    public void setExam_code(String exam_code) {
        this.exam_code = exam_code;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    abstract public double getThu_nhap();
    
    abstract public double getLuong_thuc_nhan();
            
   
}
