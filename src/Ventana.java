import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana {
    Lista listado=  new Lista();
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JComboBox cboCiudad;
    private JTextField txtNombre;
    private JButton btnBuscar;
    private JTextArea txtBuscar;
    private JButton btnSumaRecursivo;
    private JComboBox cboSumaRecursivo;
    private JTextArea txtSumaRecursivo;
    private JButton btnListar;
    private JTextArea txtListar;

    public Ventana() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudad= cboCiudad.getSelectedItem().toString();
                String nombre= txtNombre.getText();

                StringBuilder builder= new StringBuilder();

                ArrayList <Paquete> paquetes= listado.ciudadNombre(ciudad,nombre);
                if(paquetes.size()==0){
                    txtBuscar.setText("no hay");
                }else {
                    for(Paquete p:paquetes){
                        builder.append(p.toString());
                    }
                    txtBuscar.setText(builder.toString());
                }



            }
        });
        btnSumaRecursivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudad= cboCiudad.getSelectedItem().toString();
                txtSumaRecursivo.setText("la suma por ciudad es de "+ listado.suma(ciudad));
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listado.odernar();
                StringBuilder builder = new StringBuilder();
                for (Paquete p : listado.getListadoPaquete()) {
                    builder.append(p.toString());
                }
                txtListar.setText(builder.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
