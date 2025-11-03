package edu.io.player;

import java.util.Stack;

public class Shed {
    private final Stack<Tool> tools;

    public boolean isEmpty(){
        return tools.isEmpty();
    }

    public void add(Tool value){
        if(value == null){
            throw new IllegalArgumentException("Null tool cannot be added to Shed");
        }
        tools.push(value);
    }

    public Tool getTool(){
        if(tools.isEmpty()){
            return new NoTool();
        }
        return tools.pop();
    }

    public void dropTool(){
        tools.pop();
    }

    public Shed() {
        this.tools = new Stack<>();
    }
}
