/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eyepax.colorgridgenerator;

/**
 *
 * @author HandeebanSelvadurai
 */
public class CellColor {
    
    private String colorVal;

    public String getColorVal() {
        return colorVal;
    }

    public void setColorVal(String color) {
        this.colorVal = color;
    }

    public CellColor(String color) {
        this.colorVal = color;
    }
    
    
    
    @Override
    public String toString(){
        return this.colorVal;
    }
}
