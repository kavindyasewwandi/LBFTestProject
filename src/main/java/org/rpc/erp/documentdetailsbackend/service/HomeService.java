package org.rpc.erp.documentdetailsbackend.service;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.rpc.erp.documentdetailsbackend.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HomeService {
//    ResponseEntity<?> addDepartementDocument(DpartmentDocumentDto  dpartmentDocumentDto, String username) throws  Exception;
//    List<DepartmentMasterDto> getDepartmentlist();
//    List<DocumentMasterDto> getDocumentlist();
//
//    List<DpartmentDocumentDto> getDepartmentDocumentlist();
//
//    ResponseEntity<?> deleteDocument(String pid)throws Exception;
    List<StudentDto> getStudentList();
    List<SubjectDto> getSubjectList();
    List<HomeParamDto> getStudentSubjectList();
    ResponseEntity<?> addStudentSubject(HomeParamDto homeParamDto) throws  Exception;
    ResponseEntity<?> deleteStudentSubject(String pid) throws  Exception;

}
