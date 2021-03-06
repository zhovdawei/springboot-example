package com.zdw.plugin;

/**
 * 开发公司：青岛海豚数据技术有限公司
 * 版权：青岛海豚数据技术有限公司
 * <p>
 * Annotation
 *
 * @author 刘志强
 * @created Create Time: 2019/1/16
 */
public enum Annotation {
    DATA("@Data", "lombok.Data"),
    Mapper("@Mapper", "org.apache.ibatis.annotations.Mapper"),
    Repository("@Repository", "org.springframework.stereotype.Repository"),
    Entity("@Entity", "javax.persistence.Entity"),
    Table("@Table", "javax.persistence.Table"),
    Id("@Id", "javax.persistence.Id"),
    Basic("@Basic", "javax.persistence.Basic"),
    Column("@Column", "javax.persistence.Column"),
    GeneratedValue("@GeneratedValue", "javax.persistence.GeneratedValue"),
    Param("@Param", "org.apache.ibatis.annotations.Param"),
    ApiModel("@ApiModel", "io.swagger.annotations.ApiModel"),
    ApiModelProperty("@ApiModelProperty", "io.swagger.annotations.ApiModelProperty"),
    JsonFormat("@JsonFormat", "com.fasterxml.jackson.annotation.JsonFormat");

    private String annotation;

    private String clazz;
    Annotation(String annotation, String clazz) {
        this.annotation = annotation;
        this.clazz = clazz;
    }

    public String getAnnotation() {
        return annotation;
    }

    public String getClazz() {
        return clazz;
    }
}
