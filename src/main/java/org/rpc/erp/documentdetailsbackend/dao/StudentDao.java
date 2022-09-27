/*
 * @author KavindySewwandi on 21/10/2020.
 */

package org.rpc.erp.documentdetailsbackend.dao;

import org.rpc.erp.documentdetailsbackend.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<StudentEntity, String> {

     List<StudentEntity> findAll();
     StudentEntity findById(int id);



}
