/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 *
 * @author nektarios
 */
public class OperateStep extends RecipeStep {
    private String processor;
    private int duration;
    
    public OperateStep(String processor, int duration){
        this.processor=processor;
        this.duration = duration;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString(){
        return "OPERATE "+ this.processor + " " + this.duration;
    }

    public void print() {
        System.out.println("OPERATE " + this.processor + " "+ this.duration);
    }
}
