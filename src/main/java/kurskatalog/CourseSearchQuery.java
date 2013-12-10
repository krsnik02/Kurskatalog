package kurskatalog;

public class CourseSearchQuery
{
    private String departmentCode;
    private String courseCode;
    private String name;

    public String getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode( String dptCode ) { departmentCode = dptCode; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode( String crsCode ) { courseCode = crsCode; }

    public String getName() { return name; }
    public void setName( String name_ ) { name = name_; }
}
