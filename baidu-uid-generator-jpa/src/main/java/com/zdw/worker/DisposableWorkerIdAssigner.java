/*
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserve.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zdw.worker;

import com.zdw.utils.DockerUtils;
import com.zdw.utils.NetUtils;
import com.zdw.worker.entity.WorkerNode;
import com.zdw.worker.mapper.WorkerNodeDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * Represents an implementation of {@link WorkerIdAssigner}, 
 * the worker id will be discarded after assigned to the UidGenerator
 * 
 * @author yutianbao
 */
@Slf4j
public class DisposableWorkerIdAssigner implements WorkerIdAssigner {

    @Autowired
    private WorkerNodeDao workerNodeDao;

    /**
     * Assign worker id base on database.<p>
     * If there is host name & port in the environment, we considered that the node runs in Docker container<br>
     * Otherwise, the node runs on an actual machine.
     * 
     * @return assigned worker id
     */
    @Override
    @Transactional
    public long assignWorkerId() {
        // build worker node entity
        WorkerNode workerNode = buildWorkerNode();
        System.out.println();
        // add worker node for new (ignore the same IP + PORT)
        workerNodeDao.saveAndFlush(workerNode);
        log.info("Add worker node:" + workerNode);

        return workerNode.getId();
    }

    /**
     * Build worker node entity by IP and PORT
     */
    private WorkerNode buildWorkerNode() {
        WorkerNode workerNode = new WorkerNode();
        if (DockerUtils.isDocker()) {
            workerNode.setType(WorkerNodeType.CONTAINER.value());
            workerNode.setHostName(DockerUtils.getDockerHost());
            workerNode.setPort(DockerUtils.getDockerPort());
        } else {
            workerNode.setType(WorkerNodeType.ACTUAL.value());
            workerNode.setHostName(NetUtils.getLocalAddress());
            workerNode.setPort(System.currentTimeMillis() + "-" + RandomUtils.nextInt(100,100000));
        }
        workerNode.setLaunchDate(LocalDate.now());
        workerNode.setModified(LocalDateTime.now());
        workerNode.setCreated(LocalDateTime.now());
        return workerNode;
    }

}
