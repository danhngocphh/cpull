/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PC
 */
import java.io.Serializable;

/**
 *
 * @author TrungNguyen
 */
public class sjfModel implements Serializable{
    private int num;
    private int id;
    private int ArrivalTime;
    private int BurstTime;

    public sjfModel() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
        public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(int ArrivalTime) {
        this.ArrivalTime = ArrivalTime;
    }

    public int getBurstTime() {
        return BurstTime;
    }

    public void setBurstTime(int BurstTime) {
        this.BurstTime = BurstTime;
    }

    
    
    public Object[] toObject(){
        return new Object[]{
            id,ArrivalTime,BurstTime
        };
    }
}

