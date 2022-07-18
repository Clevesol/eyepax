/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eyepax.colorgridgenerator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author HandeebanSelvadurai
 */
public class ColorGridGenerator {

    
    private List<Cell[]> colorGrid;
    
    public ColorGridGenerator(int cols, int rows){
        this.generateColorGrid(cols, rows);
    }
    /**
     * @param args the command line arguments
     * args[0] = column count
     * args[1] = rows count
     * args[2] = p for print the grid, s for search for largest continuous color block
     */
    public static void main(String[] args) {
        if(args.length == 3){
            int cols = Integer.parseInt(args[0]);
            int rows = Integer.parseInt(args[1]);
            String operation = args[2];
            ColorGridGenerator generator = new ColorGridGenerator(cols,rows);
            switch(operation.toLowerCase()){
                //finds and outpusts most occured color along with the generated color grid
                case "s":
                   generator.findLargestContinousColor();
                    break;
                //prints outs generated color grid
                case "p":
                    generator.printColorGrid();
                    break;
            }
        }
    }
    
    void printColorGrid(){
    this.colorGrid.stream().forEach(row -> {
        Arrays.asList(row).stream().forEach(r -> {
            System.out.printf("{'x':%s, 'y':%s,color:'%s'},\n", r.getX(), r.getY(), r.getColor());
        });
    });
    }
    
    void findLargestContinousColor(){
    
        System.out.println("finding color with most adjucent nodes for below grid");
        this.printColorGrid();
        //loop through and finds out color with most adjucent nodes vertically and horizontally 
        String mostOccuredColor = null;
        
        for(int idx = 0; idx < this.colorGrid.size(); idx++){
          int occurenceCountVertical = 0;
            String mostOccuredColorVertical = null;
            Cell lastVCellOfMostOccrd = null;
            Cell startNode = this.colorGrid.get(idx)[0];
            
            while(startNode.getNextCell() != null){
                if(startNode.getColor().equals(startNode.getNextCell().getColor())){
                    mostOccuredColorVertical = startNode.getColor().getColorVal();
                    
                    occurenceCountVertical++;
                }else{
                    occurenceCountVertical = 0;
                }
                startNode = startNode.getNextCell();
                lastVCellOfMostOccrd = startNode;
            }
            
            int occurenceCountHorizontal = 0;
            String mostOccuredColorHorizontal = null;
            
            Cell lastHCellOfMostOccrd = null;
            startNode = this.colorGrid.get(idx)[0];
            
            while(startNode.getBottomNode()!= null){
                if(startNode.getColor().equals(startNode.getBottomNode().getColor())){
                    mostOccuredColorHorizontal = startNode.getColor().getColorVal();
                    occurenceCountHorizontal++;
                }else{
                    occurenceCountHorizontal = 0;
                }
                startNode = startNode.getBottomNode();
                lastHCellOfMostOccrd = startNode;
            }
            
            
            if((null !=lastHCellOfMostOccrd && null != lastVCellOfMostOccrd ) ){
            if((lastHCellOfMostOccrd.getX() == lastVCellOfMostOccrd.getX()) ||  (lastHCellOfMostOccrd.getY() == lastVCellOfMostOccrd.getY())){
                mostOccuredColor = lastHCellOfMostOccrd.getColor().getColorVal();
            }else{
                
                mostOccuredColor =  occurenceCountVertical > occurenceCountHorizontal ? lastVCellOfMostOccrd.getColor().getColorVal() : lastHCellOfMostOccrd.getColor().getColorVal();
                
            }
            }else{
                mostOccuredColor = startNode.getColor().getColorVal();
            }
            
           

        }       
        System.out.println("color with most adjucent nodes : "+mostOccuredColor);
    }
    
    private void generateColorGrid(int cols, int rows){
     
        List<Cell[]> generatedCells = new ArrayList<>();
        for(int row = 0; row < rows; row++){
            Cell[] generatedRow = new Cell[cols];
            for(int col = 0; col < cols; col++){
                Cell cell = new Cell(col, row, new CellColor(String.format("#%06x", new Random().nextInt(20/*0xff*/))));
                //if top node row avaialble
                if(row > 0){
                Cell topNode = generatedCells.get(row-1)[col];
                cell.setTopNode(topNode);
                topNode.setBottomNode(cell);
                }
                //if not the first column
                if(col > 0){
                    Cell previousCell = generatedRow[col-1];
                    cell.setPreviousCell(previousCell);
                    previousCell.setNextCell(cell);
                }
                
                generatedRow[col] = cell;
            }
            generatedCells.add(generatedRow);
        }
        
        this.colorGrid = generatedCells;
    }
    
}
