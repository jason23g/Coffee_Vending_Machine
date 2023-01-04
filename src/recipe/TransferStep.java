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
public class TransferStep extends RecipeStep{
    private String from;
    private String to;
    private String what;
    private  int quantity;
    
    public TransferStep(String f, String t, String w, int q){
        this.from=f;
        this.to =t;
        this.what=w;
        this.quantity=q;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString(){
        return "TRANSFER "+ this.from + " " + this.to + " " + this.what + " " + this.quantity;
    }

    public void print() {
        System.out.println("TRANSFER " + this.from + " " + this.to + " " + this.what + " "+this.quantity);
    }
}
