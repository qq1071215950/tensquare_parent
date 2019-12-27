package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jiange
 * @version 1.0
 * @date 2019/12/27 9:26
 */
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
    
}
