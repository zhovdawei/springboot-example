package com.zdw.worker.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
*
* @author MBG
* @created Create Time: Mon Feb 03 14:06:00 CST 2020
*/
@Data
@Entity
@Table(name="worker_node")
public class WorkerNode {
    /**
     * auto increment id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    /**
     * 
     */
    @Basic
    @Column(name="host_name")
    private String hostName;

    /**
     * 
     */
    @Basic
    @Column(name="port")
    private String port;

    /**
     * 
     */
    @Basic
    @Column(name="type")
    private Integer type;

    /**
     * 
     */
    @Basic
    @Column(name="launch_date")
    private LocalDate launchDate;

    /**
     * 
     */
    @Basic
    @Column(name="modified")
    private LocalDateTime modified;

    /**
     * 
     */
    @Basic
    @Column(name="created")
    private LocalDateTime created;
}