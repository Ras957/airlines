/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.carrasquilla.vista.planes;

import es.carrasquilla.model.Plane;
import es.carrasquilla.model.dao.PlaneDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 * 
 * @author Francisco Miguel Carrasquilla Rodríguez-Córdoba 
 * <afcarrasquilla@iesfranciscodelosrios.es>
 */
public class AirplaneTableModel extends AbstractTableModel{
    
    private List<Plane> datos = new ArrayList<>();
    
    public void updateModel() {
        datos = PlaneDAO.getAll();
    }
    
    @Override
    public String getColumnName(int column) {
        String n = "";
        switch (column){
            case 0: n = "ID"; break;
            case 1: n = "Fecha Adquisición"; break;
            case 2: n = "Precio"; break;
            case 3: n = "Autonomía"; break;
            case 4: n = "Consumición"; break;
            case 5: n = "Capacidad"; break;
            default: n = "[no]";
        }
        return n;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o = null;
        Plane p = datos.get(rowIndex);
        switch (columnIndex){
            case 0: o = p.getId(); break;
            case 1: o = p.getAcquisitionDate(); break;
            case 2: o = p.getPrice(); break;
            case 3: o = p.getAutonomy(); break;
            case 4: o = p.getConsumption(); break;
            case 5: o = p.getCapacity(); break;
            default: o = "";
        }
        return o;
    }

}
