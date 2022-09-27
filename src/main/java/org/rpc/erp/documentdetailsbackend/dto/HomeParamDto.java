package org.rpc.erp.documentdetailsbackend.dto;

import org.rpc.erp.documentdetailsbackend.entity.StudentEntity;
import org.rpc.erp.documentdetailsbackend.entity.SubjectEntity;

import java.util.List;

public class HomeParamDto {
    private String pid;
    private int stuid;
    private String studentName;
    private String subjectname;
    private int subid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public int getSubid() {
        return subid;
    }

    public void setSubid(int subid) {
        this.subid = subid;
    }
}
