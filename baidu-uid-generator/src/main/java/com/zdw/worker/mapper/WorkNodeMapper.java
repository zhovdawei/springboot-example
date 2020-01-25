package com.zdw.worker.mapper;

import com.zdw.worker.entity.WorkerNodeEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository(value = "workNodeMapper")
public interface WorkNodeMapper {

    @Insert({
            "insert into worker_node (host_name, ",
            "port, type, launch_date,modified,created)",
            "values (",
            "#{hostName,jdbcType=VARCHAR}, #{port,jdbcType=VARCHAR}, ",
            "#{type,jdbcType=INTEGER}, #{launchDate,jdbcType=DATE}, ",
            "NOW(), NOW())"
    })
    int addWorkerNode(WorkerNodeEntity record);


    @Select({
            "select",
            "id, host_name, port, type, launch_date, modified, created",
            "from worker_node",
            "where host_name = #{hostName,jdbcType=VARCHAR} ",
            "and port = #{port,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="host_name", property="hostName", jdbcType= JdbcType.VARCHAR),
            @Result(column="port", property="port", jdbcType= JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType= JdbcType.INTEGER),
            @Result(column="launch_date", property="launchDate", jdbcType= JdbcType.DATE),
            @Result(column="modified", property="modified", jdbcType= JdbcType.TIMESTAMP),
            @Result(column="created", property="created", jdbcType= JdbcType.TIMESTAMP)
    })
    WorkerNodeEntity getWorkerNodeByHostPort(@Param("hostName") String hostname,
                                             @Param("port") String port);

}
