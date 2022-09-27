package org.rpc.erp.documentdetailsbackend.entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "student_subject")
public class StudentSubjectEntity {

    @Id
    private String pid = UUID.randomUUID().toString();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stuid",nullable = false)
    private StudentEntity studentEntity;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subid",nullable = false)
    private SubjectEntity subjectEntity;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public SubjectEntity getSubjectEntity() {
        return subjectEntity;
    }

    public void setSubjectEntity(SubjectEntity subjectEntity) {
        this.subjectEntity = subjectEntity;
    }
}
