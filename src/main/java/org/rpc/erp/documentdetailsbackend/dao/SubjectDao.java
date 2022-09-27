/*
 * @author KavindySewwandi on 02/11/2020.
 */

package org.rpc.erp.documentdetailsbackend.dao;

import org.rpc.erp.documentdetailsbackend.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubjectDao extends JpaRepository<SubjectEntity, String> {

    List<SubjectEntity> findAll();
    SubjectEntity findById(int id);
}
