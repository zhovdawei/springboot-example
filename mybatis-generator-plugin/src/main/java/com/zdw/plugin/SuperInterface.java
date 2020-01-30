package com.zdw.plugin;

public enum SuperInterface {

    JpaRepository("JpaRepository<%s,%s>", "org.springframework.data.jpa.repository.JpaRepository");

    private String superInterface;

    private String clazz;
    SuperInterface(String superInterface, String clazz) {
        this.superInterface = superInterface;
        this.clazz = clazz;
    }

    public String getSuperInterface() {
        return superInterface;
    }

    public String getClazz() {
        return clazz;
    }

}
