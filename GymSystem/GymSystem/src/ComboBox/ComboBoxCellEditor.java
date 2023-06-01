///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package ComboBox;
//
//import Logic.Employee;
//import Logic.GymSystem;
//import java.awt.Component;
//import javax.swing.DefaultCellEditor;
//import javax.swing.JTable;
//
///**
// *
// * @author alija
// */
//public class ComboBoxCellEditor extends DefaultCellEditor {
//
//    private ComboBoxActionEvent event;
//
//    public ComboBoxCellEditor(ComboBoxActionEvent event) {
//        super(new ComboBox.ComboBoxSuggestion());
//        this.event = event;
//    }
//
//    @Override
//    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
//        ComboBoxSuggestion action = new ComboBoxSuggestion();
//        for (Employee emp : GymSystem.employees) {
//            action.addItem(emp.getFullName());
//        }
//
//        return action;
//    }
//}
