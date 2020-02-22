package com.zdw.plugin;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.config.TableConfiguration;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JpaEntityPlugin extends PluginAdapter{

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    /**
     * 修改实体类
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        classAnnotation(topLevelClass,null);
        Set<FullyQualifiedJavaType> set = new HashSet<FullyQualifiedJavaType>();

        //引入 import
        set.add(new FullyQualifiedJavaType(Annotation.DATA.getClazz()));
        set.add(new FullyQualifiedJavaType(Annotation.Entity.getClazz()));
        set.add(new FullyQualifiedJavaType(Annotation.Table.getClazz()));
        topLevelClass.addImportedTypes(set);

        //打上注解 @Table(name = "account", schema = "vipdb", catalog = "")
        topLevelClass.addAnnotation(Annotation.DATA.getAnnotation());
        topLevelClass.addAnnotation(Annotation.Entity.getAnnotation());
        topLevelClass.addAnnotation(Annotation.Table.getAnnotation() + "(name=\""+ introspectedTable.getTableConfiguration().getTableName() + "\")");
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }

    /**
     * 修改mapper接口
     * @param interfaze
     * @param topLevelClass
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        interfazeAnnotation(interfaze, null);
        Set<FullyQualifiedJavaType> set = new HashSet<FullyQualifiedJavaType>();
        //Repository 支持的全限定类
        set.add(new FullyQualifiedJavaType(Annotation.Repository.getClazz()));
        //JpaRepository import支持
        set.add(new FullyQualifiedJavaType(SuperInterface.JpaRepository.getClazz()));
        //User import支持
        set.add(new FullyQualifiedJavaType(introspectedTable.getGeneratedKey().getColumn()
                                            +"."+introspectedTable.getTableConfiguration().getDomainObjectName()));
        interfaze.addImportedTypes(set);
        //打上 @Repository 注解
        interfaze.addAnnotation(Annotation.Repository.getAnnotation());

        //获取主键的类型
        String primaryKeyType = "Integer";
        List<IntrospectedColumn> keys = introspectedTable.getPrimaryKeyColumns();
        for (IntrospectedColumn key : keys) {
            if(key.getActualColumnName().equals("id")){
                if(key.getJdbcTypeName().equals("BIGINT")){
                    primaryKeyType = "Long";
                }
            }
        }

        // 获取 接口的类型 和 主键的类型
        TableConfiguration tcf = introspectedTable.getTableConfiguration();
        /**
        System.out.println("表名 : "+tcf.getTableName());
        System.out.println("类名 : "+tcf.getDomainObjectName());
        System.out.println("主键 : "+tcf.getGeneratedKey().getColumn());
        */
        // 拼装 父类接口类型
        String superInterface = String.format(SuperInterface.JpaRepository.getSuperInterface(),
                                              tcf.getDomainObjectName(),
                                              primaryKeyType);
        // 添加父类接口
        interfaze.addSuperInterface(new FullyQualifiedJavaType(superInterface));

        return super.clientGenerated(interfaze,topLevelClass,introspectedTable);
    }

    /**
     * 实体类字段
     * @param field
     * @param topLevelClass
     * @param introspectedColumn
     * @param introspectedTable
     * @param modelClassType
     * @return
     */
    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 生成注释
        fieldAnnotation(field, introspectedColumn.getRemarks());

        // 追加 主键区分注解
        if (introspectedColumn.getActualColumnName().equals("id")) {
            field.addAnnotation(Annotation.Id.getAnnotation());
            topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.Id.getClazz()));
            //处理自增主键注解
            field.addAnnotation(Annotation.GeneratedValue.getAnnotation()
                    + "(strategy=GenerationType.IDENTITY)");
            topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.GeneratedValue.getClazz()));
            topLevelClass.addImportedType(new FullyQualifiedJavaType("javax.persistence.GenerationType"));
        }else {
            field.addAnnotation(Annotation.Basic.getAnnotation());
            topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.Basic.getClazz()));
        }

        // 追加 字段绑定注解
        topLevelClass.addImportedType(new FullyQualifiedJavaType(Annotation.Column.getClazz()));
        field.addAnnotation(Annotation.Column.getAnnotation() + "(name=\""+ introspectedColumn.getActualColumnName() + "\")");

        // tinyint数据（Byte）转换成（Integer）类型
        String a = field.getType().getShortName();
        if (StringUtils.equals("Boolean", a)) {
            field.setType(new FullyQualifiedJavaType("java.lang.Integer"));
        }
        return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable, modelClassType);
    }

    /**
     * set方法 false 不生成
     * @param method
     * @param topLevelClass
     * @param introspectedColumn
     * @param introspectedTable
     * @param modelClassType
     * @return
     */
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /**
     * get方法 false 不生成
     * @param method
     * @param topLevelClass
     * @param introspectedColumn
     * @param introspectedTable
     * @param modelClassType
     * @return
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /**
     * 方法注释生成
     * @param method
     * @param explain
     */
    public static void methodAnnotation(Method method, String explain) {
        // 生成注释
        StringBuilder sb = new StringBuilder();
        method.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(explain);
        method.addJavaDocLine(sb.toString());
        Parameter parm = method.getParameters().get(0);
        sb.setLength(0);
        sb.append(" * @param ");
        sb.append(parm.getName());
        method.addJavaDocLine(sb.toString());
        method.addJavaDocLine(" */");
        // 生成注释结束
    }

    /**
     * 属性注释生成
     * @param field
     * @param explain
     */
    public static void fieldAnnotation(Field field, String explain) {
        // 生成注释
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(explain);
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
        // 生成注释结束
    }

    /**
     * 类注释生成
     * @param topLevelClass
     * @param explain
     */
    public static void classAnnotation(TopLevelClass topLevelClass, String explain) {
        // 生成注释
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("*");
        topLevelClass.addJavaDocLine("* @author MBG");
        topLevelClass.addJavaDocLine("* @created Create Time: " + new Date());
        topLevelClass.addJavaDocLine("*/");
        // 生成注释结束
    }

    /**
     * 接口注释生成
     * @param interfaze
     * @param explain
     */
    public static void interfazeAnnotation(Interface interfaze, String explain) {
        // 生成注释
        interfaze.addJavaDocLine("/**");
        interfaze.addJavaDocLine("*");
        interfaze.addJavaDocLine("* @author MBG");
        interfaze.addJavaDocLine("* @created Create Time: " + new Date());
        interfaze.addJavaDocLine("*/");
        // 生成注释结束
    }

    @Override
    public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientInsertMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        return false;
    }

    @Override
    public boolean providerGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        return false;
    }
}
