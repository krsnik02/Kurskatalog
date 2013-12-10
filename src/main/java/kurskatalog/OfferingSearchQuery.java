package kurskatalog;

public class OfferingSearchQuery
{
    private String departmentCode;
    private String courseCode;
    private String section;
    private String courseName;
    private String professorFirstName;
    private String professorLastName;

    public String getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode( String deptCode ) { departmentCode = deptCode; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode( String crsCode ) { courseCode = crsCode; }

    public String getSection() { return section; }
    public void setSection( String sect ) { section = sect; }

    public String getCourseName() { return courseName; }
    public void setCourseName( String crsName ) { courseName = crsName; }

    public String getProfessorFirstName() { return professorFirstName; }
    public void setProfessorFirstName( String profName ) { professorFirstName = profName; }

    public String getProfessorLastName() { return professorLastName; }
    public void setProfessorLastName( String profName ) { professorLastName = profName; }
}
