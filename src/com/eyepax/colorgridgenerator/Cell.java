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
public class Cell {
    
    private int x;
    private int y;
    
    private Cell nextCell;
    private Cell previousCell;
    private Cell topNode;
    private Cell bottomNode;
    
    public Cell getNextCell() {
        return nextCell;
    }

    public void setNextCell(Cell nextCell) {
        this.nextCell = nextCell;
    }

    public Cell getPreviousCell() {
        return previousCell;
    }

    public void setPreviousCell(Cell previousCell) {
        this.previousCell = previousCell;
    }

    public Cell getTopNode() {
        return topNode;
    }

    public void setTopNode(Cell topNode) {
        this.topNode = topNode;
    }

    public Cell getBottomNode() {
        return bottomNode;
    }

    public void setBottomNode(Cell bottomNode) {
        this.bottomNode = bottomNode;
    }

    
    
    
    private CellColor color;
    
    public Cell(int x, int y, CellColor color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CellColor getColor() {
        return color;
    }

    public void setColor(CellColor color) {
        this.color = color;
    }
    
    @Override
    public String toString(){
    
        return "x:"+this.x+",y:"+this.y+",color:"+this.color;
    }
    
}
