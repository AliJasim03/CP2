///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package ComboBox;
//
//import Logic.*;
//import java.awt.Color;
//import java.awt.Component;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableCellRenderer;
//
///**
// *
// * @author alija
// */
//public class ComboBoxCellRender extends DefaultTableCellRenderer {
//
//    private ComboBoxSuggestion combo;
//
//    public ComboBoxCellRender() {
//        // Perform the rendering operation once
//        combo = new ComboBoxSuggestion();
//        for (Employee emp : GymSystem.employees) {
//            combo.addItem(emp.getFullName());
//        }
//    }
//
//    @Override
//    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
//        System.out.println(o);
//        for (Employee emp : GymSystem.employees) {
//            combo.addItem(emp.getFullName());
//        }
//        combo.setSelectedItem(o);
//        return combo;
//    }
//}
