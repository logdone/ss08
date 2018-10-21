package com.beec.ss08.entity;

import java.util.List;

public class Disaster {
    public String type ;
    public List<ChkItem> chkItemList;
    public List<ChkItem> todoItemList;


    public Disaster(String type, List<ChkItem> chkItemList, List<ChkItem> todoItemList) {
        this.type = type;
        this.chkItemList = chkItemList;
        this.todoItemList = todoItemList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ChkItem> getChkItemList() {
        return chkItemList;
    }

    public void setChkItemList(List<ChkItem> chkItemList) {
        this.chkItemList = chkItemList;
    }

    public List<ChkItem> getTodoItemList() {
        return todoItemList;
    }

    public void setTodoItemList(List<ChkItem> todoItemList) {
        this.todoItemList = todoItemList;
    }
}
