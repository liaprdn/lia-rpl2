/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelmahasiswabaru;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author liaprdn
 */
public class ControllerMahasiswa {
    ArrayList<ModelMahasiswaBaru> ArrayData;
    DefaultTableModel tabelModel;
    
    public ControllerMahasiswa() {
        ArrayData = new ArrayList<ModelMahasiswaBaru>();
    }
    public void InsertData(String npm, String nama, int tinggi, boolean pindahan) {
        ModelMahasiswaBaru mhs = new ModelMahasiswaBaru(npm, nama, tinggi, pindahan);
        ArrayData.add(mhs);
    }
    
    public DefaultTableModel showData(){
        String[] kolom = {"NPM", "Nama", "Tinggi", "Pindah"};
        Object[][] objData = new Object[ArrayData.size()][4];
        int i = 0;
        
        for(ModelMahasiswaBaru n : ArrayData) {
            Object[] arrData = {n.getNPM(), n.getNama(), n.getTinggi(), n.isPindahan()};
            objData[i] = arrData;
            i++;
        }
        
        tabelModel = new DefaultTableModel(objData, kolom) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
       return tabelModel;
    }
}
