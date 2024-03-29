/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author zjhoz
 */
public class EmployeeTableModel extends AbstractTableModel{
    
    public String[] columnNames = {"ID", "First Name", "Last Name"};
    public ArrayList<Employee> empList;
    
    public EmployeeTableModel(ArrayList<Employee> empList){
        this.empList = empList;
        
        
    }
    
    @Override
    public int getRowCount() {
        return empList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0:
                return (Object) empList.get(row).getID();
            case 1: 
                return (Object) empList.get(row).getFirstName();
            case 2:
                return (Object) empList.get(row).getLastName();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int c){
        return columnNames[c];
    }
    
    @Override
    public void setValueAt(Object value, int row, int col){
        switch(col){
            case 0:
                 empList.get(row).setID((int) value);
            case 1: 
                 empList.get(row).setFirstName((String) value);
            case 2:
                 empList.get(row).setLastName((String) value);
                 
            fireTableCellUpdated(row, col);
        }
    }
    
    public void newEmployee(Employee emp){
        
        empList.add(emp);
        
        fireTableDataChanged(); //refreshes table
    }
    
    public void deleteEmployee(int index){
        this.empList.remove(index);
        fireTableDataChanged();
    }
}
