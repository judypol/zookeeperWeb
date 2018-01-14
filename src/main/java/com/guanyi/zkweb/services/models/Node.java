package com.guanyi.zkweb.services.models;

public class Node {
    public Node(String name,String zkPath){
        this.name=name;
        this.zkPath=zkPath;
    }
    String name;
    String zkPath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZkPath() {
        return zkPath;
    }

    public void setZkPath(String zkPath) {
        this.zkPath = zkPath;
    }
}
