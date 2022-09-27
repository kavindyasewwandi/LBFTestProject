/*
 * @author KavindySewwandi on 02/11/2020.
 */

package org.rpc.erp.documentdetailsbackend.dao;

import org.rpc.erp.documentdetailsbackend.entity.StudentEntity;
import org.rpc.erp.documentdetailsbackend.entity.StudentSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSubjectDao extends JpaRepository<StudentSubjectEntity, String> {
    List<StudentSubjectEntity> findAll();
    void deleteByPid(String pid);
}
