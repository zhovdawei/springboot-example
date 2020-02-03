package com.zdw.worker.mapper;

import com.zdw.worker.entity.WorkerNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
*
* @author MBG
* @created Create Time: Mon Feb 03 14:06:00 CST 2020
*/
@Repository
public interface WorkerNodeDao extends JpaRepository<WorkerNode, Long> {
}