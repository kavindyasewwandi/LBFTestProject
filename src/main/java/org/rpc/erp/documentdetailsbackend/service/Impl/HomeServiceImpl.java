
package org.rpc.erp.documentdetailsbackend.service.Impl;


import org.rpc.erp.documentdetailsbackend.dao.StudentSubjectDao;
import org.rpc.erp.documentdetailsbackend.dao.StudentDao;
import org.rpc.erp.documentdetailsbackend.dao.SubjectDao;
import org.rpc.erp.documentdetailsbackend.dto.*;
import org.rpc.erp.documentdetailsbackend.entity.*;
import org.rpc.erp.documentdetailsbackend.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional()
public class HomeServiceImpl implements HomeService {
    @Autowired
    StudentDao studentDao;

    @Autowired
    SubjectDao subjectDao;

    @Autowired
    StudentSubjectDao studentSubjectDao;


    @Override
    public List<StudentDto> getStudentList() {
        List<StudentDto> studentDtos= new ArrayList<>();
        List<StudentEntity> studentEntities= studentDao.findAll();
        studentEntities.forEach(params->{
            StudentDto studentDto=new StudentDto();
            studentDto.setId(params.getId());
            studentDto.setName(params.getName());


            studentDtos.add(studentDto);
        });
        return studentDtos;
    }

    @Override
    public List<SubjectDto> getSubjectList() {
        List<SubjectDto> subjectDtos= new ArrayList<>();
        List<SubjectEntity> subjectEntities= subjectDao.findAll();
        subjectEntities.forEach(params->{
            SubjectDto subjectDto=new SubjectDto();
            subjectDto.setId(params.getId());
            subjectDto.setSubject(params.getSubject());


            subjectDtos.add(subjectDto);
        });
        return  subjectDtos;
    }

    @Override
    public List<HomeParamDto> getStudentSubjectList() {
        List<HomeParamDto> homeParamDtos= new ArrayList<>();
        List<StudentSubjectEntity> studentSubjectEntities= studentSubjectDao.findAll();
        studentSubjectEntities.forEach(params->{
            StudentEntity studentEntity =params.getStudentEntity();
            SubjectEntity subjectEntity= params.getSubjectEntity();

            HomeParamDto homeParamDto=new HomeParamDto();
            homeParamDto.setPid(params.getPid());
            homeParamDto.setStuid(studentEntity.getId());
            homeParamDto.setSubid(subjectEntity.getId());
            homeParamDto.setStudentName(studentEntity.getName());
            homeParamDto.setSubjectname(subjectEntity.getSubject());


            homeParamDtos.add(homeParamDto);
        });
        return  homeParamDtos;
    }

    @Override
    public ResponseEntity<?> addStudentSubject(HomeParamDto homeParamDto) throws Exception {

            StudentSubjectEntity studentSubjectEntity=new StudentSubjectEntity();
            studentSubjectEntity.setPid(UUID.randomUUID().toString());
            StudentEntity studentEntity= studentDao.findById(homeParamDto.getStuid());
            SubjectEntity subjectEntity= subjectDao.findById(homeParamDto.getSubid());
            studentSubjectEntity.setStudentEntity(studentEntity);
            studentSubjectEntity.setSubjectEntity(subjectEntity);


        if (null == studentSubjectDao.save(studentSubjectEntity)) {
            return new ResponseEntity<Object>("204", HttpStatus.NOT_MODIFIED);
        } else {

            return new ResponseEntity<Object>("200", HttpStatus.OK);

        }

        //return new ResponseEntity<Object>("200", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteStudentSubject(String pid) throws Exception {
        studentSubjectDao.deleteByPid(pid);
        return new ResponseEntity<Object>("200", HttpStatus.OK);
    }

}
