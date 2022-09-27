package org.rpc.erp.documentdetailsbackend.controller;
import org.rpc.erp.documentdetailsbackend.dto.HomeParamDto;
import org.rpc.erp.documentdetailsbackend.dto.StudentDto;
import org.rpc.erp.documentdetailsbackend.dto.SubjectDto;
import org.rpc.erp.documentdetailsbackend.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("home")
public class HomeController {
    @Autowired
    private HomeService homeService;


    @GetMapping("/getStudentList")
    public ResponseEntity getStudentList (){
        List<StudentDto> studentDtoList= homeService.getStudentList ();
        return ResponseEntity.ok(studentDtoList);
    }

    @GetMapping("/getSubjectList")
    public ResponseEntity getSubjectList (){
        List<SubjectDto> subjectDtoList= homeService.getSubjectList ();
        return ResponseEntity.ok(subjectDtoList);
    }

    @PostMapping("/add}")
    public ResponseEntity<?> addStudentSubject(@RequestBody HomeParamDto homeParamDto) {
        System.out.println("ok");
        try {

            return homeService.addStudentSubject(homeParamDto);
        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<Object> (e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }

    @GetMapping("/getStudentSubjectList")
    public ResponseEntity getStudentSubjectList (){
        List<HomeParamDto> homeParamDtos= homeService.getStudentSubjectList ();
        return ResponseEntity.ok(homeParamDtos);
    }

    @DeleteMapping(value = "/delete/{pid}")
    public ResponseEntity<?> deleteStudentSubject(@PathVariable("pid") String pid) {
        try {

            return homeService.deleteStudentSubject(pid);
        }
        catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<Object> (e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }

    }
}
