package di.autowire.byconstructor;

public class EmployeeBean {
    private String fullName;

    public EmployeeBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }

    private DepartmentBean departmentBean;

    public DepartmentBean getDepartmentBean() {
        return departmentBean;
    }

    public void setDepartmentBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}