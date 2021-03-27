package Ventana;

import Clases.*;
import Clases.Short;
import Conexion.Conexion;
import Controladores.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Ventana {
    private JPanel panelPrincipal;
    private JPanel panelPruebaConexion;
    private JButton pruebaConexionButton;
    private JTextField txtUsuarioBaseDeDatos;
    private JTabbedPane panelPestañas;
    private JPasswordField txtContraseñaBaseDeDatos;
    private JButton personalRegistrarButton;
    private JButton personalActualizarButton;
    private JButton personalEliminarButton;
    private JButton personalListarButton;
    private JButton personalBuscarButton;
    private JTable tablaPersonal;
    private JTextField txtPersonalNombre;
    private JTextField txtPersonalFechaNacimiento;
    private JTextField txtPersonalDNI;
    private JTextField txtPersonalFechaRegistro;
    private JTextField txtPersonalCargo;
    private JButton limpiarCamposPersonal;
    private JTabbedPane tabbedPane1;
    private JTextField txtEstiloCamisa;
    private JTextField txtPrecioCamisa;
    private JTextField txtColorCamisa;
    private JButton botonRegistrarCamisa;
    private JButton botonActualizarCamisa;
    private JButton botonEliminarCamisa;
    private JButton botonListarCamisa;
    private JButton botonLimpiarCamposCamisa;
    private JButton botonBuscarCamisa;
    private JTable tablaCamisas;
    private JTextField txtCodigoCamisa;
    private JTable tablaCamisasFormales;
    private JTextField txtCodigoCamisaFormal;
    private JTextField txtColorCamisaFormal;
    private JTextField txtPrecioCamisaFormal;
    private JTextField txtEstiloCamisaFormal;
    private JTextField txtCodigoCamisaSinMangas;
    private JTextField txtColorCamisaSinMangas;
    private JTextField txtPrecioCamisaSinMangas;
    private JTextField txtEstiloCamisaSinMangas;
    private JTable tablaCamisaSinMangas;
    private JTextField txtCodigoVestidos;
    private JTextField txtColorVestidos;
    private JTextField txtPrecioVestidos;
    private JTextField txtEstiloVestidos;
    private JTable tablaVestidos;
    private JTextField txtCodigoPantalones;
    private JTextField txtColorPantalones;
    private JTextField txtPrecioPantalones;
    private JTextField txtEstiloPantalones;
    private JTable tablaPantalones;
    private JTable tablaShorts;
    private JTextField txtCodigoShorts;
    private JTextField txtColorShorts;
    private JTextField txtPrecioShorts;
    private JTextField txtEstiloShorts;
    private JTextField txtCodigoCorbatas;
    private JTextField txtColorCorbatas;
    private JTextField txtPrecioCorbatas;
    private JTextField txtEstiloCorbatas;
    private JTable tablaCorbatas;
    private JTextField txtCodigoPantalonFormal;
    private JTextField txtColorPantalonFormal;
    private JTextField txtPrecioPantalonFormal;
    private JTextField txtEstiloPantalonFormal;
    private JTable tablaTelas;
    private JTextField txtCodigoTelas;
    private JTextField txtColorTelas;
    private JTextField txtPrecioTelas;
    private JTextField txtEstiloTelas;
    private JTextField txtCodigoFaldas;
    private JTextField txtColorFaldas;
    private JTextField txtPrecioFaldas;
    private JTextField txtEstiloFaldas;
    private JTable tablaFaldas;
    private JButton botonRegistrarCamisaFormal;
    private JButton botonActualizarCamisaFormal;
    private JButton botonEliminarCamisaFormal;
    private JButton botonListarCamisaFormal;
    private JButton botonBuscarCamisaFormal;
    private JButton botonLimpiarCamposCamisaFormal;
    private JButton botonRegistrarShort;
    private JButton botonActualizarShort;
    private JButton botonEliminarShort;
    private JButton botonListarShort;
    private JButton botonBuscarShort;
    private JButton botonLimpiarShort;
    private JButton botonRegistrarVestido;
    private JButton botonActualizarVestido;
    private JButton botonEliminarVestido;
    private JButton botonListarVestido;
    private JButton botonBuscarVestido;
    private JButton botonLimpiarCamposVestido;
    private JButton botonRegistrarCorbata;
    private JButton botonActualizarCorbata;
    private JButton botonEliminarCorbata;
    private JButton botonListarCorbata;
    private JButton botonBuscarCorbata;
    private JButton botonLimpiarCorbata;
    private JButton botonRegistrarPantalon;
    private JButton botonActualizarPantalon;
    private JButton botonEliminarPantalon;
    private JButton botonListarPantalon;
    private JButton botonBuscarPantalon;
    private JButton botonLimpiarPantalon;
    private JButton botonRegistrarPantalonFormal;
    private JButton botonActualizarPantalonFormal;
    private JButton botonEliminarPantalonFormal;
    private JButton botonListarPantalonFormal;
    private JButton botonBuscarPantalonFormal;
    private JButton botonLimpiarCamposPantalonFormal;
    private JTable tablaPantalonesFormales;
    private JButton botonRegistrarTela;
    private JButton botonActualizarTela;
    private JButton botonEliminarTela;
    private JButton botonListarTela;
    private JButton botonBuscarTela;
    private JButton botonLimpiarCamposTela;
    private JButton botonRegistrarFalda;
    private JButton botonActualizarFalda;
    private JButton botonEliminarFalda;
    private JButton botonListarFalda;
    private JButton botonBuscarFalda;
    private JButton botonLimpiarCamposFalda;
    private JButton botonRegistrarCamisaSinMangas;
    private JButton botonActualizarCamisaSinMangas;
    private JButton botonEliminarCamisaSinMangas;
    private JButton botonListarCamisaSinMangas;
    private JButton botonBuscarCamisaSinMangas;
    private JButton botonLimpiarCamposCamisasSinMangas;
    private JTable tablaPedidos;
    private JComboBox cajaDeSeleccion;
    private JTextField txtCodigoPedidos;
    private JTextField txtColorPedidos;
    private JTextField txtPrecioPedidos;
    private JTextField txtEstiloPedidos;
    private JTextField txtCompradorPedido;
    private JButton botonRegistrarPedido;
    private JButton botonActualizarPedido;
    private JButton botonEliminarPedido;
    private JButton botonListarPedido;
    private JButton botonBuscarPedido;
    private JButton botonLimpiarPedido;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Ventana() {
        ControladorPersonal.iniciarTablaPersonal(tablaPersonal,(DefaultTableModel) tablaPersonal.getModel());
        ControladorCamisa.iniciarTablaCamisa(tablaCamisas, (DefaultTableModel) tablaCamisas.getModel());
        ControladorCamisaFormal.iniciarTablaCamisaFormal(tablaCamisasFormales, (DefaultTableModel) tablaCamisasFormales.getModel());
        ControladorShort.iniciarTablaShorts(tablaShorts, (DefaultTableModel) tablaShorts.getModel());
        ControladorVestido.iniciarTablaVestidos(tablaVestidos, (DefaultTableModel) tablaVestidos.getModel());
        ControladorCorbatas.iniciarTablaCorbatas(tablaCorbatas, (DefaultTableModel) tablaCorbatas.getModel());
        ControladorPantalon.iniciarTablaPantalon(tablaPantalones, (DefaultTableModel) tablaPantalones.getModel());
        ControladorPantalonesFormales.iniciarTablaPantalonesFormales(tablaPantalonesFormales, (DefaultTableModel) tablaPantalonesFormales.getModel());
        ControladorTela.iniciarTablaTela(tablaTelas, (DefaultTableModel) tablaTelas.getModel());
        ControladorFalda.iniciarTablaFalda(tablaFaldas,(DefaultTableModel) tablaFaldas.getModel());
        ControladorCamisaSinMangas.iniciarTablaCamisaSinMangas(tablaCamisaSinMangas, (DefaultTableModel) tablaCamisaSinMangas.getModel());
        ControladorPedidos.iniciarTablaPedidos(tablaPedidos, (DefaultTableModel) tablaPedidos.getModel());
        llenarCajaDeSeleccion();
        //****************************************************************TablaPersonal
        pruebaConexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conexion.setUsuario(txtUsuarioBaseDeDatos.getText());
                Conexion.setClave(txtContraseñaBaseDeDatos.getText());
                Connection conexion = Conexion.obtenerConexion();
                if(conexion != null){
                    JOptionPane.showMessageDialog(null, "Conexión exitosa!",null, JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo conectar!",null, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        personalRegistrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTextoPersonal[] = {txtPersonalDNI
                ,txtPersonalNombre, txtPersonalFechaNacimiento,
                txtPersonalFechaRegistro, txtPersonalCargo};
                JTextField camposNumericosPersonal[] = {txtPersonalDNI};
               if(!validarCamposDeTexto(camposDeTextoPersonal) && !validarCamposNumericos(camposNumericosPersonal)){
                        Personal personal = new Personal();
                        personal.setDni(Long.parseLong(txtPersonalDNI.getText()));
                        personal.setNombre(txtPersonalNombre.getText());
                        personal.setFechaNacimiento(convertirTextoFecha(txtPersonalFechaNacimiento.getText()));
                        personal.setFechaRegistro(convertirTextoFecha(txtPersonalFechaRegistro.getText()));
                        personal.setCargo(txtPersonalCargo.getText());
                        new ControladorPersonal().insertar(personal);
                        leerDatosPersonal();
                        limpiarCamposDeTexto(camposDeTextoPersonal);
                }//
            }
        });
        personalActualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTextoPersonal[] = {txtPersonalDNI
                        ,txtPersonalNombre, txtPersonalFechaNacimiento,
                        txtPersonalFechaRegistro, txtPersonalCargo};
                cambiarColorDeCamposDeTexto(camposDeTextoPersonal);

                JTextField camposNumericosPersonal[] = {txtPersonalDNI};
                if(!validarCamposDeTexto(camposDeTextoPersonal) && !validarCamposNumericos(camposNumericosPersonal)){
                    Personal temp = new Personal(Long.parseLong(txtPersonalDNI.getText()),
                            txtPersonalNombre.getText(), convertirTextoFecha(txtPersonalFechaNacimiento.getText()),
                            convertirTextoFecha(txtPersonalFechaRegistro.getText()), txtPersonalCargo.getText());
                    ControladorPersonal.actualizarPersonal(temp);
                    leerDatosPersonal();
                }
            }
        });
        personalEliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtPersonalDNI.getText().equals("")){
                    Personal temp = new Personal(Long.parseLong(txtPersonalDNI.getText()),
                            txtPersonalNombre.getText(), convertirTextoFecha(txtPersonalFechaNacimiento.getText()),
                            convertirTextoFecha(txtPersonalFechaRegistro.getText()), txtPersonalCargo.getText());
                ControladorPersonal.eliminarPersonal(temp.getDni());
                leerDatosPersonal();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo DNI está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTextoPersonal[] = {txtPersonalDNI
                        ,txtPersonalNombre, txtPersonalFechaNacimiento,
                        txtPersonalFechaRegistro, txtPersonalCargo};
                cambiarColorDeCamposDeTexto(camposDeTextoPersonal);
            }
        });
        personalListarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosPersonal();
                JTextField camposDeTextoPersonal[] = {txtPersonalDNI
                        ,txtPersonalNombre, txtPersonalFechaNacimiento,
                        txtPersonalFechaRegistro, txtPersonalCargo};
                cambiarColorDeCamposDeTexto(camposDeTextoPersonal);
            }
        });
        personalBuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long DNI = Long.parseLong(JOptionPane.showInputDialog("Ingrese DNI:"));
                    ControladorPersonal.buscarPersonal(DNI, tablaPersonal, (DefaultTableModel) tablaPersonal.getModel());
                    }
                    catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                    }
                JTextField camposDeTextoPersonal[] = {txtPersonalDNI
                        ,txtPersonalNombre, txtPersonalFechaNacimiento,
                        txtPersonalFechaRegistro, txtPersonalCargo};
                cambiarColorDeCamposDeTexto(camposDeTextoPersonal);
            }
        });
        tablaPersonal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaPersonal.getSelectedRow();
                DefaultTableModel modeloTablaPersonal = (DefaultTableModel) tablaPersonal.getModel();
                txtPersonalDNI.setText(modeloTablaPersonal.getValueAt(filaSeleccionada, 0).toString());
                txtPersonalNombre.setText(modeloTablaPersonal.getValueAt(filaSeleccionada, 1).toString());
                txtPersonalFechaNacimiento.setText(modeloTablaPersonal.getValueAt(filaSeleccionada, 2).toString());
                txtPersonalFechaRegistro.setText(modeloTablaPersonal.getValueAt(filaSeleccionada, 3).toString());
                txtPersonalCargo.setText(modeloTablaPersonal.getValueAt(filaSeleccionada, 4).toString());
                JTextField camposDeTextoPersonal[] = {txtPersonalDNI
                        ,txtPersonalNombre, txtPersonalFechaNacimiento,
                        txtPersonalFechaRegistro, txtPersonalCargo};
                cambiarColorDeCamposDeTexto(camposDeTextoPersonal);
            }
        });
        //****************************************************************TablaCamisa
        botonRegistrarCamisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCamisa
                        ,txtColorCamisa, txtPrecioCamisa, txtEstiloCamisa};
                JTextField camposNumericos[] = {txtPrecioCamisa, txtCodigoCamisa};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Camisa camisa = new Camisa();
                    camisa.setCodigo(Long.parseLong(txtCodigoCamisa.getText()));
                    camisa.setColor(txtColorCamisa.getText());
                    camisa.setPrecio(Double.parseDouble(txtPrecioCamisa.getText()));
                    camisa.setEstilo(txtEstiloCamisa.getText());
                    new ControladorCamisa().insertarCamisa(camisa);
                    leerDatosCamisa();
                    limpiarCamposDeTexto(camposDeTexto);
                }//
            }
        });
        botonActualizarCamisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCamisa
                        ,txtColorCamisa, txtPrecioCamisa, txtEstiloCamisa};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericosPersonal[] = {txtCodigoCamisa, txtCodigoCamisa};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericosPersonal)){
                    Camisa temp = new Camisa(Long.parseLong(txtCodigoCamisa.getText()),
                            txtColorCamisa.getText(), Double.parseDouble(txtPrecioCamisa.getText()),
                            txtEstiloCamisa.getText());
                    ControladorCamisa.actualizarCamisa(temp);
                    leerDatosCamisa();
                }
            }
        });
        botonEliminarCamisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCodigoCamisa.getText().equals("")){
                    Camisa temp = new Camisa(Long.parseLong(txtCodigoCamisa.getText()),
                        txtColorCamisa.getText(), Double.parseDouble(txtPrecioCamisa.getText()),
                        txtEstiloCamisa.getText());
                    ControladorCamisa.eliminarCamisa(temp.getCodigo());
                    leerDatosCamisa();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Código está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoCamisa
                        ,txtColorCamisa, txtPrecioCamisa, txtEstiloCamisa};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonListarCamisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosCamisa();
                JTextField camposDeTexto[] = {txtCodigoCamisa
                        ,txtColorCamisa, txtPrecioCamisa, txtEstiloCamisa};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonBuscarCamisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese código:"));
                    ControladorCamisa.buscarCamisa(codigo, tablaCamisas, (DefaultTableModel) tablaCamisas.getModel());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoCamisa
                        ,txtColorCamisa, txtPrecioCamisa, txtEstiloCamisa};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonLimpiarCamposCamisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCamisa
                        ,txtColorCamisa, txtPrecioCamisa, txtEstiloCamisa};
                cambiarColorDeCamposDeTexto(camposDeTexto);
                limpiarCamposDeTexto(camposDeTexto);
            }
        });
        tablaCamisas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaCamisas.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaCamisas.getModel();
                txtCodigoCamisa.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtColorCamisa.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtPrecioCamisa.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtEstiloCamisa.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                JTextField camposDeTexto[] = {txtCodigoCamisa,
                        txtColorCamisa, txtPrecioCamisa, txtEstiloCamisa};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        //****************************************************************TablaCamisaFormal
        botonRegistrarCamisaFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCamisaFormal
                        ,txtColorCamisaFormal, txtPrecioCamisaFormal, txtEstiloCamisaFormal};
                JTextField camposNumericos[] = {txtPrecioCamisaFormal, txtCodigoCamisaFormal};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    CamisaFormal camisaFormal = new CamisaFormal();
                    camisaFormal.setCodigo(Long.parseLong(txtCodigoCamisaFormal.getText()));
                    camisaFormal.setColor(txtColorCamisaFormal.getText());
                    camisaFormal.setPrecio(Double.parseDouble(txtPrecioCamisaFormal.getText()));
                    camisaFormal.setEstilo(txtEstiloCamisaFormal.getText());
                    new ControladorCamisaFormal().insertarCamisaFormal(camisaFormal);
                    leerDatosCamisaFormal();
                    limpiarCamposDeTexto(camposDeTexto);
                }//
            }
        });
        botonActualizarCamisaFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCamisaFormal
                        ,txtColorCamisaFormal, txtPrecioCamisaFormal, txtEstiloCamisaFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericosPersonal[] = {txtCodigoCamisaFormal, txtCodigoCamisaFormal};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericosPersonal)){
                    CamisaFormal temp = new CamisaFormal(Long.parseLong(txtCodigoCamisaFormal.getText()),
                            txtColorCamisaFormal.getText(), Double.parseDouble(txtPrecioCamisaFormal.getText()),
                            txtEstiloCamisaFormal.getText());
                    ControladorCamisaFormal.actualizarCamisaFormal(temp);
                    leerDatosCamisaFormal();
                }
            }
        });
        botonEliminarCamisaFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCodigoCamisaFormal.getText().equals("")){
                    CamisaFormal temp = new CamisaFormal(Long.parseLong(txtCodigoCamisaFormal.getText()),
                            txtColorCamisaFormal.getText(), Double.parseDouble(txtPrecioCamisaFormal.getText()),
                            txtEstiloCamisaFormal.getText());
                    ControladorCamisaFormal.eliminarCamisaFormal(temp.getCodigo());
                    leerDatosCamisaFormal();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Código está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoCamisaFormal
                        ,txtColorCamisaFormal, txtPrecioCamisaFormal, txtEstiloCamisaFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonListarCamisaFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosCamisaFormal();
                JTextField camposDeTexto[] = {txtCodigoCamisaFormal
                        ,txtColorCamisaFormal, txtPrecioCamisaFormal, txtEstiloCamisaFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonBuscarCamisaFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese código:"));
                    ControladorCamisaFormal.buscarCamisaFormal(codigo, tablaCamisasFormales, (DefaultTableModel) tablaCamisasFormales.getModel());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoCamisaFormal
                        ,txtColorCamisaFormal, txtPrecioCamisaFormal, txtEstiloCamisaFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonLimpiarCamposCamisaFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCamisaFormal
                        ,txtColorCamisaFormal, txtPrecioCamisaFormal, txtEstiloCamisaFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);
                limpiarCamposDeTexto(camposDeTexto);
            }
        });

        tablaCamisasFormales.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaCamisasFormales.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaCamisasFormales.getModel();
                txtCodigoCamisaFormal.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtColorCamisaFormal.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtPrecioCamisaFormal.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtEstiloCamisaFormal.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                JTextField camposDeTexto[] = {txtCodigoCamisaFormal,
                        txtColorCamisaFormal, txtPrecioCamisaFormal, txtEstiloCamisaFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        //****************************************************************TablaShort
        botonRegistrarShort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoShorts
                        ,txtColorShorts, txtPrecioShorts, txtEstiloShorts};
                JTextField camposNumericos[] = {txtPrecioShorts, txtCodigoShorts};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Short shorts = new Short();
                    shorts.setCodigo(Long.parseLong(txtCodigoShorts.getText()));
                    shorts.setColor(txtColorShorts.getText());
                    shorts.setPrecio(Double.parseDouble(txtPrecioShorts.getText()));
                    shorts.setEstilo(txtEstiloShorts.getText());
                    new ControladorShort().insertarShort(shorts);
                    leerDatosShorts();
                    limpiarCamposDeTexto(camposDeTexto);
                }//
            }
        });
        botonActualizarShort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoShorts
                        ,txtColorShorts, txtPrecioShorts, txtEstiloShorts};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericos[] = {txtCodigoShorts, txtCodigoShorts};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Short temp = new Short(Long.parseLong(txtCodigoShorts.getText()),
                            txtColorShorts.getText(), Double.parseDouble(txtPrecioShorts.getText()),
                            txtEstiloShorts.getText());
                    ControladorShort.actualizarShort(temp);
                    leerDatosShorts();
                }
            }
        });
        botonEliminarShort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCodigoShorts.getText().equals("")){
                    CamisaFormal temp = new CamisaFormal(Long.parseLong(txtCodigoShorts.getText()),
                            txtColorShorts.getText(), Double.parseDouble(txtPrecioShorts.getText()),
                            txtEstiloShorts.getText());
                    ControladorShort.eliminarShort(temp.getCodigo());
                    leerDatosShorts();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Código está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoShorts
                        ,txtColorShorts, txtPrecioShorts, txtEstiloShorts};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonListarShort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosShorts();
                JTextField camposDeTexto[] = {txtCodigoShorts
                        ,txtColorShorts, txtPrecioShorts, txtEstiloShorts};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonBuscarShort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese código:"));
                    ControladorShort.buscarShort(codigo, tablaShorts, (DefaultTableModel) tablaShorts.getModel());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoShorts
                        ,txtColorShorts, txtPrecioShorts, txtEstiloShorts};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonLimpiarShort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoShorts
                        ,txtColorShorts, txtPrecioShorts, txtEstiloShorts};
                cambiarColorDeCamposDeTexto(camposDeTexto);
                limpiarCamposDeTexto(camposDeTexto);
            }
        });

        tablaShorts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaShorts.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaShorts.getModel();
                txtCodigoShorts.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtColorShorts.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtPrecioShorts.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtEstiloShorts.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                JTextField camposDeTexto[] = {txtCodigoShorts,
                        txtColorShorts, txtPrecioShorts, txtEstiloShorts};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
//****************************************************************TablaVestido
        botonRegistrarVestido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoVestidos
                        ,txtColorVestidos, txtPrecioVestidos, txtEstiloVestidos};
                JTextField camposNumericos[] = {txtPrecioVestidos, txtCodigoVestidos};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Vestido vestido = new Vestido();
                    vestido.setCodigo(Long.parseLong(txtCodigoVestidos.getText()));
                    vestido.setColor(txtColorVestidos.getText());
                    vestido.setPrecio(Double.parseDouble(txtPrecioVestidos.getText()));
                    vestido.setEstilo(txtEstiloVestidos.getText());
                    new ControladorVestido().insertarVestido(vestido);
                    leerDatosVestido();
                    limpiarCamposDeTexto(camposDeTexto);
                }//
            }
        });
        botonActualizarVestido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoVestidos
                        ,txtColorVestidos, txtPrecioVestidos, txtEstiloVestidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericos[] = {txtCodigoVestidos, txtCodigoVestidos};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Vestido temp = new Vestido(Long.parseLong(txtCodigoVestidos.getText()),
                            txtColorVestidos.getText(), Double.parseDouble(txtPrecioVestidos.getText()),
                            txtEstiloVestidos.getText());
                    ControladorVestido.actualizarVestido(temp);
                    leerDatosVestido();
                }
            }
        });
        botonEliminarVestido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCodigoVestidos.getText().equals("")){
                    CamisaFormal temp = new CamisaFormal(Long.parseLong(txtCodigoVestidos.getText()),
                            txtColorVestidos.getText(), Double.parseDouble(txtPrecioVestidos.getText()),
                            txtEstiloVestidos.getText());
                    ControladorVestido.eliminarVestido(temp.getCodigo());
                    leerDatosVestido();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Código está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoVestidos
                        ,txtColorVestidos, txtPrecioVestidos, txtEstiloVestidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonListarVestido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosVestido();
                JTextField camposDeTexto[] = {txtCodigoVestidos
                        ,txtColorVestidos, txtPrecioVestidos, txtEstiloVestidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonBuscarVestido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese código:"));
                    ControladorVestido.buscarVestido(codigo, tablaVestidos, (DefaultTableModel) tablaVestidos.getModel());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoVestidos
                        ,txtColorVestidos, txtPrecioVestidos, txtEstiloVestidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonLimpiarCamposVestido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoVestidos
                        ,txtColorVestidos, txtPrecioVestidos, txtEstiloVestidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);
                limpiarCamposDeTexto(camposDeTexto);
            }
        });

        tablaVestidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaVestidos.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaVestidos.getModel();
                txtCodigoVestidos.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtColorVestidos.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtPrecioVestidos.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtEstiloVestidos.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                JTextField camposDeTexto[] = {txtCodigoVestidos,
                        txtColorVestidos, txtPrecioVestidos, txtEstiloVestidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
//****************************************************************TablaCorbata
        botonRegistrarCorbata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCorbatas
                        ,txtColorCorbatas, txtPrecioCorbatas, txtEstiloCorbatas};
                JTextField camposNumericos[] = {txtPrecioCorbatas, txtCodigoCorbatas};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Corbata corbata = new Corbata();
                    corbata.setCodigo(Long.parseLong(txtCodigoCorbatas.getText()));
                    corbata.setColor(txtColorCorbatas.getText());
                    corbata.setPrecio(Double.parseDouble(txtPrecioCorbatas.getText()));
                    corbata.setEstilo(txtEstiloCorbatas.getText());
                    new ControladorCorbatas().insertarCorbata(corbata);
                    leerDatosCorbata();
                    limpiarCamposDeTexto(camposDeTexto);
                }//
            }
        });
        botonActualizarCorbata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCorbatas
                        ,txtColorCorbatas, txtPrecioCorbatas, txtEstiloCorbatas};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericos[] = {txtCodigoCorbatas, txtCodigoCorbatas};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Corbata temp = new Corbata(Long.parseLong(txtCodigoCorbatas.getText()),
                            txtColorCorbatas.getText(), Double.parseDouble(txtPrecioCorbatas.getText()),
                            txtEstiloCorbatas.getText());
                    ControladorCorbatas.actualizarCorbata(temp);
                    leerDatosCorbata();
                }
            }
        });
        botonEliminarCorbata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCodigoCorbatas.getText().equals("")){
                    CamisaFormal temp = new CamisaFormal(Long.parseLong(txtCodigoCorbatas.getText()),
                            txtColorCorbatas.getText(), Double.parseDouble(txtPrecioCorbatas.getText()),
                            txtEstiloCorbatas.getText());
                    ControladorCorbatas.eliminarCorbata(temp.getCodigo());
                    leerDatosCorbata();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Código está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoCorbatas
                        ,txtColorCorbatas, txtPrecioCorbatas, txtEstiloCorbatas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonListarCorbata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosCorbata();
                JTextField camposDeTexto[] = {txtCodigoCorbatas
                        ,txtColorCorbatas, txtPrecioCorbatas, txtEstiloCorbatas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonBuscarCorbata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese código:"));
                    ControladorCorbatas.buscarCorbata(codigo, tablaCorbatas, (DefaultTableModel) tablaCorbatas.getModel());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoCorbatas
                        ,txtColorCorbatas, txtPrecioCorbatas, txtEstiloCorbatas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonLimpiarCorbata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCorbatas
                        ,txtColorCorbatas, txtPrecioCorbatas, txtEstiloCorbatas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
                limpiarCamposDeTexto(camposDeTexto);
            }
        });

        tablaCorbatas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaCorbatas.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaCorbatas.getModel();
                txtCodigoCorbatas.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtColorCorbatas.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtPrecioCorbatas.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtEstiloCorbatas.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                JTextField camposDeTexto[] = {txtCodigoCorbatas,
                        txtColorCorbatas, txtPrecioCorbatas, txtEstiloCorbatas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        //****************************************************************TablaPantalon
        botonRegistrarPantalon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoPantalones
                        ,txtColorPantalones, txtPrecioPantalones, txtEstiloPantalones};
                JTextField camposNumericos[] = {txtPrecioPantalones, txtCodigoPantalones};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Pantalon pantalon = new Pantalon();
                    pantalon.setCodigo(Long.parseLong(txtCodigoPantalones.getText()));
                    pantalon.setColor(txtColorPantalones.getText());
                    pantalon.setPrecio(Double.parseDouble(txtPrecioPantalones.getText()));
                    pantalon.setEstilo(txtEstiloPantalones.getText());
                    new ControladorPantalon().insertarPantalon(pantalon);
                    leerDatosPantalon();
                    limpiarCamposDeTexto(camposDeTexto);
                }//
            }
        });
        botonActualizarPantalon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoPantalones
                        ,txtColorPantalones, txtPrecioPantalones, txtEstiloPantalones};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericos[] = {txtCodigoPantalones, txtCodigoPantalones};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Pantalon temp = new Pantalon(Long.parseLong(txtCodigoPantalones.getText()),
                            txtColorPantalones.getText(), Double.parseDouble(txtPrecioPantalones.getText()),
                            txtEstiloPantalones.getText());
                    ControladorPantalon.actualizarPantalon(temp);
                    leerDatosPantalon();
                }
            }
        });
        botonEliminarPantalon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCodigoPantalones.getText().equals("")){
                    Pantalon temp = new Pantalon(Long.parseLong(txtCodigoPantalones.getText()),
                            txtColorPantalones.getText(), Double.parseDouble(txtPrecioPantalones.getText()),
                            txtEstiloPantalones.getText());
                    ControladorPantalon.eliminarPantalon(temp.getCodigo());
                    leerDatosPantalon();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Código está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoPantalones
                        ,txtColorPantalones, txtPrecioPantalones, txtEstiloPantalones};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonListarPantalon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosPantalon();
                JTextField camposDeTexto[] = {txtCodigoPantalones
                        ,txtColorPantalones, txtPrecioPantalones, txtEstiloPantalones};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonBuscarPantalon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese código:"));
                    ControladorPantalon.buscarPantalon(codigo, tablaPantalones, (DefaultTableModel) tablaPersonal.getModel());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoPantalones
                        ,txtColorPantalones, txtPrecioPantalones, txtEstiloPantalones};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonLimpiarPantalon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoPantalones
                        ,txtColorPantalones, txtPrecioPantalones, txtEstiloPantalones};
                cambiarColorDeCamposDeTexto(camposDeTexto);
                limpiarCamposDeTexto(camposDeTexto);
            }
        });

        tablaPantalones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaPantalones.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaPantalones.getModel();
                txtCodigoPantalones.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtColorPantalones.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtPrecioPantalones.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtEstiloPantalones.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                JTextField camposDeTexto[] = {txtCodigoPantalones,
                        txtColorPantalones, txtPrecioPantalones, txtEstiloPantalones};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        //****************************************************************TablaPantalonFormal
        botonRegistrarPantalonFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoPantalonFormal
                        ,txtColorPantalonFormal, txtPrecioPantalonFormal, txtEstiloPantalonFormal};
                JTextField camposNumericos[] = {txtPrecioPantalonFormal, txtCodigoPantalonFormal};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    PantalonFormal pantalonFormal = new PantalonFormal();
                    pantalonFormal.setCodigo(Long.parseLong(txtCodigoPantalonFormal.getText()));
                    pantalonFormal.setColor(txtColorPantalonFormal.getText());
                    pantalonFormal.setPrecio(Double.parseDouble(txtPrecioPantalonFormal.getText()));
                    pantalonFormal.setEstilo(txtEstiloPantalonFormal.getText());
                    new ControladorPantalonesFormales().insertarPantalonFormal(pantalonFormal);
                    leerDatosPantalonFormal();
                    limpiarCamposDeTexto(camposDeTexto);
                }//
            }
        });
        botonActualizarPantalonFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoPantalonFormal
                        ,txtColorPantalonFormal, txtPrecioPantalonFormal, txtEstiloPantalonFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericos[] = {txtCodigoPantalonFormal, txtCodigoPantalonFormal};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    PantalonFormal temp = new PantalonFormal(Long.parseLong(txtCodigoPantalonFormal.getText()),
                            txtColorPantalonFormal.getText(), Double.parseDouble(txtPrecioPantalonFormal.getText()),
                            txtEstiloPantalonFormal.getText());
                    ControladorPantalonesFormales.actualizarPantalonFormal(temp);
                    leerDatosPantalonFormal();
                }
            }
        });
        botonEliminarPantalonFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCodigoPantalonFormal.getText().equals("")){
                    PantalonFormal temp = new PantalonFormal(Long.parseLong(txtCodigoPantalonFormal.getText()),
                            txtColorPantalonFormal.getText(), Double.parseDouble(txtPrecioPantalonFormal.getText()),
                            txtEstiloPantalonFormal.getText());
                    ControladorPantalonesFormales.eliminarPantalonFormal(temp.getCodigo());
                    leerDatosPantalonFormal();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Código está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoPantalonFormal
                        ,txtColorPantalonFormal, txtPrecioPantalonFormal, txtEstiloPantalonFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonListarPantalonFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosPantalonFormal();
                JTextField camposDeTexto[] = {txtCodigoPantalonFormal
                        ,txtColorPantalonFormal, txtPrecioPantalonFormal, txtEstiloPantalonFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonBuscarPantalonFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese código:"));
                    ControladorPantalonesFormales.buscarPantalonFormal(codigo, tablaPantalonesFormales, (DefaultTableModel) tablaPantalonesFormales.getModel());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoPantalonFormal
                        ,txtColorPantalonFormal, txtPrecioPantalonFormal, txtEstiloPantalonFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonLimpiarCamposPantalonFormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoPantalonFormal
                        ,txtColorPantalonFormal, txtPrecioPantalonFormal, txtEstiloPantalonFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);
                limpiarCamposDeTexto(camposDeTexto);
            }
        });

        tablaPantalonesFormales.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaPantalonesFormales.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaPantalonesFormales.getModel();
                txtCodigoPantalonFormal.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtColorPantalonFormal.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtPrecioPantalonFormal.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtEstiloPantalonFormal.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                JTextField camposDeTexto[] = {txtCodigoPantalonFormal,
                        txtColorPantalonFormal, txtPrecioPantalonFormal, txtEstiloPantalonFormal};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        //****************************************************************TablaTela
        botonRegistrarTela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoTelas
                        ,txtColorTelas, txtPrecioTelas, txtEstiloTelas};
                JTextField camposNumericos[] = {txtPrecioTelas, txtCodigoTelas};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Tela tela = new Tela();
                    tela.setCodigo(Long.parseLong(txtCodigoTelas.getText()));
                    tela.setColor(txtColorTelas.getText());
                    tela.setPrecio(Double.parseDouble(txtPrecioTelas.getText()));
                    tela.setEstilo(txtEstiloTelas.getText());
                    new ControladorTela().insertarTela(tela);
                    leerDatosTela();
                    limpiarCamposDeTexto(camposDeTexto);
                }//
            }
        });
        botonActualizarTela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoTelas
                        ,txtColorTelas, txtPrecioTelas, txtEstiloTelas};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericos[] = {txtCodigoTelas, txtCodigoTelas};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Tela temp = new Tela(Long.parseLong(txtCodigoTelas.getText()),
                            txtColorTelas.getText(), Double.parseDouble(txtPrecioTelas.getText()),
                            txtEstiloTelas.getText());
                    ControladorTela.actualizarTela(temp);
                    leerDatosTela();
                }
            }
        });
        botonEliminarTela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCodigoTelas.getText().equals("")){
                    PantalonFormal temp = new PantalonFormal(Long.parseLong(txtCodigoTelas.getText()),
                            txtColorTelas.getText(), Double.parseDouble(txtPrecioTelas.getText()),
                            txtEstiloTelas.getText());
                    ControladorTela.eliminarTela(temp.getCodigo());
                    leerDatosTela();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Código está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoTelas
                        ,txtColorTelas, txtPrecioTelas, txtEstiloTelas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonListarTela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosTela();
                JTextField camposDeTexto[] = {txtCodigoTelas
                        ,txtColorTelas, txtPrecioTelas, txtEstiloTelas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonBuscarTela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese código:"));
                    ControladorTela.buscarCamisaTela(codigo, tablaTelas, (DefaultTableModel) tablaTelas.getModel());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoTelas
                        ,txtColorTelas, txtPrecioTelas, txtEstiloTelas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonLimpiarCamposTela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoTelas
                        ,txtColorTelas, txtPrecioTelas, txtEstiloTelas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
                limpiarCamposDeTexto(camposDeTexto);
            }
        });

        tablaTelas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaTelas.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaTelas.getModel();
                txtCodigoTelas.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtColorTelas.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtPrecioTelas.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtEstiloTelas.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                JTextField camposDeTexto[] = {txtCodigoTelas,
                        txtColorTelas, txtPrecioTelas, txtEstiloTelas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        //****************************************************************TablaFalda
        botonRegistrarFalda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoFaldas
                        ,txtColorFaldas, txtPrecioFaldas, txtEstiloFaldas};
                JTextField camposNumericos[] = {txtPrecioFaldas, txtCodigoFaldas};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Falda falda = new Falda();
                    falda.setCodigo(Long.parseLong(txtCodigoFaldas.getText()));
                    falda.setColor(txtColorFaldas.getText());
                    falda.setPrecio(Double.parseDouble(txtPrecioFaldas.getText()));
                    falda.setEstilo(txtEstiloFaldas.getText());
                    new ControladorFalda().insertarFalda(falda);
                    leerDatosFalda();
                    limpiarCamposDeTexto(camposDeTexto);
                }//
            }
        });
        botonActualizarFalda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoFaldas
                        ,txtColorFaldas, txtPrecioFaldas, txtEstiloFaldas};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericos[] = {txtCodigoFaldas, txtCodigoFaldas};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    Falda temp = new Falda(Long.parseLong(txtCodigoFaldas.getText()),
                            txtColorFaldas.getText(), Double.parseDouble(txtPrecioFaldas.getText()),
                            txtEstiloFaldas.getText());
                    ControladorFalda.actualizarFalda(temp);
                    leerDatosFalda();
                }
            }
        });
        botonEliminarFalda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCodigoFaldas.getText().equals("")){
                    PantalonFormal temp = new PantalonFormal(Long.parseLong(txtCodigoFaldas.getText()),
                            txtColorFaldas.getText(), Double.parseDouble(txtPrecioFaldas.getText()),
                            txtEstiloFaldas.getText());
                    ControladorFalda.eliminarFalda(temp.getCodigo());
                    leerDatosFalda();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Código está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoFaldas
                        ,txtColorFaldas, txtPrecioFaldas, txtEstiloFaldas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonListarFalda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosFalda();
                JTextField camposDeTexto[] = {txtCodigoFaldas
                        ,txtColorFaldas, txtPrecioFaldas, txtEstiloFaldas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonBuscarFalda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese código:"));
                    ControladorFalda.buscarFalda(codigo, tablaFaldas, (DefaultTableModel) tablaFaldas.getModel());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoFaldas
                        ,txtColorFaldas, txtPrecioFaldas, txtEstiloFaldas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonLimpiarCamposFalda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoFaldas
                        ,txtColorFaldas, txtPrecioFaldas, txtEstiloFaldas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
                limpiarCamposDeTexto(camposDeTexto);
            }
        });

        tablaFaldas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaFaldas.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaFaldas.getModel();
                txtCodigoFaldas.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtColorFaldas.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtPrecioFaldas.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtEstiloFaldas.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                JTextField camposDeTexto[] = {txtCodigoFaldas,
                        txtColorFaldas, txtPrecioFaldas, txtEstiloFaldas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        //****************************************************************CamisaSinMangas
        botonRegistrarCamisaSinMangas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCamisaSinMangas
                        ,txtColorCamisaSinMangas, txtPrecioCamisaSinMangas, txtEstiloCamisaSinMangas    };
                JTextField camposNumericos[] = {txtPrecioCamisaSinMangas, txtCodigoCamisaSinMangas};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    CamisaSinMangas camisaSinMangas = new CamisaSinMangas();
                    camisaSinMangas.setCodigo(Long.parseLong(txtCodigoCamisaSinMangas.getText()));
                    camisaSinMangas.setColor(txtColorCamisaSinMangas.getText());
                    camisaSinMangas.setPrecio(Double.parseDouble(txtPrecioCamisaSinMangas.getText()));
                    camisaSinMangas.setEstilo(txtEstiloCamisaSinMangas.getText());
                    new ControladorCamisaSinMangas().insertarCamisaSinMangas(camisaSinMangas);
                    leerDatosCamisaSinMangas();
                    limpiarCamposDeTexto(camposDeTexto);
                }//
            }
        });
        botonActualizarCamisaSinMangas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCamisaSinMangas
                        ,txtColorCamisaSinMangas, txtPrecioCamisaSinMangas, txtEstiloCamisaSinMangas};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericosPersonal[] = {txtCodigoCamisaSinMangas, txtCodigoCamisaSinMangas};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericosPersonal)){
                    CamisaSinMangas temp = new CamisaSinMangas(Long.parseLong(txtCodigoCamisaSinMangas.getText()),
                            txtColorCamisaSinMangas.getText(), Double.parseDouble(txtPrecioCamisaSinMangas.getText()),
                            txtEstiloCamisaSinMangas.getText());
                    ControladorCamisaSinMangas.actualizarCamisaSinMangas(temp);
                    leerDatosCamisaSinMangas();
                }
            }
        });
        botonEliminarCamisaSinMangas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCodigoCamisaSinMangas.getText().equals("")){
                    Camisa temp = new Camisa(Long.parseLong(txtCodigoCamisaSinMangas.getText()),
                            txtColorCamisaSinMangas.getText(), Double.parseDouble(txtPrecioCamisaSinMangas.getText()),
                            txtEstiloCamisaSinMangas.getText());
                    ControladorCamisaSinMangas.eliminarCamisaSinMangas(temp.getCodigo());
                    leerDatosCamisaSinMangas();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Código está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoCamisaSinMangas
                        ,txtColorCamisaSinMangas, txtPrecioCamisaSinMangas, txtEstiloCamisaSinMangas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonListarCamisaSinMangas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosCamisaSinMangas();
                JTextField camposDeTexto[] = {txtCodigoCamisaSinMangas
                        ,txtColorCamisaSinMangas, txtPrecioCamisaSinMangas, txtEstiloCamisaSinMangas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonBuscarCamisaSinMangas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese código:"));
                    ControladorCamisaSinMangas.buscarCamisaSinMangas(codigo, tablaCamisaSinMangas, (DefaultTableModel) tablaCamisaSinMangas.getModel());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCodigoCamisaSinMangas
                        ,txtColorCamisaSinMangas, txtPrecioCamisaSinMangas, txtEstiloCamisaSinMangas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonLimpiarCamposCamisasSinMangas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCodigoCamisaSinMangas
                        ,txtColorCamisaSinMangas, txtPrecioCamisaSinMangas, txtEstiloCamisaSinMangas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
                limpiarCamposDeTexto(camposDeTexto);
            }
        });
        tablaCamisaSinMangas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaCamisaSinMangas.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaCamisaSinMangas.getModel();
                txtCodigoCamisaSinMangas.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtColorCamisaSinMangas.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtPrecioCamisaSinMangas.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtEstiloCamisaSinMangas.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                JTextField camposDeTexto[] = {txtCodigoCamisaSinMangas,
                        txtColorCamisaSinMangas, txtPrecioCamisaSinMangas, txtEstiloCamisaSinMangas};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        //****************************************************************Pedidos
        botonRegistrarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCompradorPedido, txtCodigoPedidos,
                        txtColorPedidos, txtPrecioPedidos, txtEstiloPedidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericos[] = {txtCodigoPedidos, txtPrecioPedidos};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericos)){
                    if(cajaDeSeleccion.getSelectedItem() != null) {
                        Pedidos temp = new Pedidos();
                        temp.setNombreProducto(cajaDeSeleccion.getSelectedItem().toString());
                        temp.setComprador(txtCompradorPedido.getText());
                        temp.setCodigo(Long.parseLong(txtCodigoPedidos.getText()));
                        temp.setColor(txtColorPedidos.getText());
                        temp.setPrecio(Double.parseDouble(txtPrecioPedidos.getText()));
                        temp.setEstilo(txtEstiloPedidos.getText());
                        ControladorPedidos.insertarPedido(temp);
                        leerDatosPedidos();
                    }else{JOptionPane.showMessageDialog(null, "Debe seleccionar un producto!",null, JOptionPane.INFORMATION_MESSAGE);}
                }//
            }
        });
        botonActualizarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCompradorPedido, txtCodigoPedidos,
                        txtColorPedidos, txtPrecioPedidos, txtEstiloPedidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);

                JTextField camposNumericosPersonal[] = {txtCodigoPedidos, txtPrecioPedidos};
                if(!validarCamposDeTexto(camposDeTexto) && !validarCamposNumericos(camposNumericosPersonal)){
                    if(cajaDeSeleccion.getSelectedItem() != null) {
                        Pedidos temp = new Pedidos();
                        temp.setNombreProducto(cajaDeSeleccion.getSelectedItem().toString());
                        temp.setComprador(txtCompradorPedido.getText());
                        temp.setCodigo(Long.parseLong(txtCodigoPedidos.getText()));
                        temp.setColor(txtColorPedidos.getText());
                        temp.setPrecio(Double.parseDouble(txtPrecioPedidos.getText()));
                        temp.setEstilo(txtEstiloPedidos.getText());
                        ControladorPedidos.actualizarPedido(temp);
                        leerDatosPedidos();
                    }else{JOptionPane.showMessageDialog(null, "Debe seleccionar un producto!",null, JOptionPane.INFORMATION_MESSAGE);}
                }
            }
        });
        botonEliminarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtCodigoPedidos.getText().equals("")){
                    ControladorPedidos.eliminarPedido(Long.parseLong(txtCodigoPedidos.getText()));
                    leerDatosPedidos();
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Código está vacío!",null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCompradorPedido, txtCodigoPedidos,
                        txtColorPedidos, txtPrecioPedidos, txtEstiloPedidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonListarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatosPedidos();
                JTextField camposDeTexto[] = {txtCompradorPedido, txtCodigoPedidos,
                        txtColorPedidos, txtPrecioPedidos, txtEstiloPedidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonBuscarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese código:"));
                    ControladorPedidos.buscarPedido(codigo, tablaPedidos, (DefaultTableModel) tablaPedidos.getModel());
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido!", null, JOptionPane.ERROR_MESSAGE);
                }
                JTextField camposDeTexto[] = {txtCompradorPedido, txtCodigoPedidos,
                        txtColorPedidos, txtPrecioPedidos, txtEstiloPedidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
        botonLimpiarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField camposDeTexto[] = {txtCompradorPedido, txtCodigoPedidos,
                        txtColorPedidos, txtPrecioPedidos, txtEstiloPedidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);
                limpiarCamposDeTexto(camposDeTexto);
            }
        });
        tablaPedidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaPedidos.getSelectedRow();
                DefaultTableModel modeloTabla = (DefaultTableModel) tablaPedidos.getModel();
                txtCompradorPedido.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
                txtCodigoPedidos.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtColorPedidos.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtPrecioPedidos.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                txtEstiloPedidos.setText(modeloTabla.getValueAt(filaSeleccionada, 5).toString());
                JTextField camposDeTexto[] = {txtCompradorPedido, txtCodigoPedidos,
                        txtColorPedidos, txtPrecioPedidos, txtEstiloPedidos};
                cambiarColorDeCamposDeTexto(camposDeTexto);
            }
        });
    }//Fin de ventana.

    //Para que los campos de texto no se queden color Rosa y se quite la advertencia!
    private void cambiarColorDeCamposDeTexto(JTextField arregloCamposDeTexto[]){
        for (JTextField campoDeTexto: arregloCamposDeTexto) {
            if(campoDeTexto.getBackground().equals(Color.PINK)){
                campoDeTexto.setBackground(Color.WHITE);
            }
        }
    }//Fin del método: cambiarColorDeCampooTexto
    //Para no hacer código repetitivo. retorna true si los campos tienen texto.
    private boolean validarCamposDeTexto(JTextField arregloCamposDeTexto[]){
        cambiarColorDeCamposDeTexto(arregloCamposDeTexto);
        boolean camposVacios = false;
        for (JTextField campoDeTexto: arregloCamposDeTexto) {
            if(campoDeTexto.getText().equals("")){
                campoDeTexto.setBackground(Color.PINK);
                camposVacios = true;
            }
        }//Fin del for.
        if(camposVacios == true){
            JOptionPane.showMessageDialog(null, "Hay campos sin rellenar!",null, JOptionPane.ERROR_MESSAGE);}
        return camposVacios;
    }//Fin del método: validarCamposDeTexto

    private Date convertirTextoFecha(String textoFecha ){
        Date fecha = null;
        try {
            fecha = sdf.parse(textoFecha);
        }catch (ParseException pe){
            JOptionPane.showMessageDialog(null, "Ingrese formto de fecha: Día/Mes/Año", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return fecha;
    }//Fin del método: convertirTextoFecha

    private void leerDatosPersonal() {
        try {
            DefaultTableModel modeloTablaPersonal = (DefaultTableModel) tablaPersonal.getModel();
            List<Personal> listaPersonal =  ControladorPersonal.leerPersonal();
            modeloTablaPersonal.setRowCount(0);
            for (Personal personal: listaPersonal) {
                Object[] registroLeido = {personal.getDni(), personal.getNombre(),
                sdf.format(personal.getFechaNacimiento()), sdf.format(personal.getFechaRegistro()), personal.getCargo()};
                modeloTablaPersonal.addRow(registroLeido);
            }
            tablaPersonal.setModel(modeloTablaPersonal);
        }catch (Exception e){}
    }//Fin del método: leerDatos.
    private void leerDatosCamisa() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaCamisas.getModel();
            List<Camisa> listaCamisa =  ControladorCamisa.leerCamisa();
            modeloTabla.setRowCount(0);
            for (Camisa camisa: listaCamisa) {
                Object[] registroLeido = {camisa.getNombre(), camisa.getCodigo(),
                camisa.getColor(), camisa.getPrecio(), camisa.getEstilo()};
                modeloTabla.addRow(registroLeido);
            }
            tablaCamisas.setModel(modeloTabla);
        }catch (Exception e){}
    }//Fin del método: leerDatosCamisa.
    private void leerDatosCamisaFormal() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaCamisasFormales.getModel();
            List<CamisaFormal> listaCamisaFormal =  ControladorCamisaFormal.leerCamisaFormal();
            modeloTabla.setRowCount(0);
            for (CamisaFormal camisaFormal: listaCamisaFormal) {
                Object[] registroLeido = {camisaFormal.getNombre(), camisaFormal.getCodigo(),
                        camisaFormal.getColor(), camisaFormal.getPrecio(), camisaFormal.getEstilo()};
                modeloTabla.addRow(registroLeido);
            }
            tablaCamisasFormales.setModel(modeloTabla);
        }catch (Exception e){}
    }//Fin del método: leerDatosCamisaFormal
    private void leerDatosShorts() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaShorts.getModel();
            List<Short> listaShorts =  ControladorShort.leerShort();
            modeloTabla.setRowCount(0);
            for (Short shorts: listaShorts) {
                Object[] registroLeido = {shorts.getNombre(), shorts.getCodigo(),
                        shorts.getColor(), shorts.getPrecio(), shorts.getEstilo()};
                modeloTabla.addRow(registroLeido);
            }
            tablaShorts.setModel(modeloTabla);
        }catch (Exception e){}
    }//Fin del método: leerDatosShorts
    private void leerDatosVestido() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaVestidos.getModel();
            List<Vestido> listaVestidos =  ControladorVestido.leerVestido();
            modeloTabla.setRowCount(0);
            for (Vestido vestidos: listaVestidos) {
                Object[] registroLeido = {vestidos.getNombre(), vestidos.getCodigo(),
                        vestidos.getColor(), vestidos.getPrecio(), vestidos.getEstilo()};
                modeloTabla.addRow(registroLeido);
            }
            tablaVestidos.setModel(modeloTabla);
        }catch (Exception e){}
    }//Fin del método: leerDatosVestido
    private void leerDatosCorbata() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaCorbatas.getModel();
            List<Corbata> listaCorbata =  ControladorCorbatas.leerCorbata();
            modeloTabla.setRowCount(0);
            for (Corbata corbata: listaCorbata) {
                Object[] registroLeido = {corbata.getNombre(), corbata.getCodigo(),
                        corbata.getColor(), corbata.getPrecio(), corbata.getEstilo()};
                modeloTabla.addRow(registroLeido);
            }
            tablaCorbatas.setModel(modeloTabla);
        }catch (Exception e){}
    }//Fin del método: leerDatosCorbata
    private void leerDatosPantalon() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaPantalones.getModel();
            List<Pantalon> listaPantalon =  ControladorPantalon.leerPantalon();
            modeloTabla.setRowCount(0);
            for (Pantalon pantalon: listaPantalon) {
                Object[] registroLeido = {pantalon.getNombre(), pantalon.getCodigo(),
                        pantalon.getColor(), pantalon.getPrecio(), pantalon.getEstilo()};
                modeloTabla.addRow(registroLeido);
            }
            tablaPantalones.setModel(modeloTabla);
        }catch (Exception e){}
    }//Fin del método: leerDatosPantalon
    private void leerDatosTela() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaTelas.getModel();
            List<Tela> listaTelas=  ControladorTela.leerTela();
            modeloTabla.setRowCount(0);
            for (Tela tela: listaTelas) {
                Object[] registroLeido = {tela.getNombre(), tela.getCodigo(),
                        tela.getColor(), tela.getPrecio(), tela.getEstilo()};
                modeloTabla.addRow(registroLeido);
            }
            tablaTelas.setModel(modeloTabla);
        }catch (Exception e){}
    }//Fin del método: leerDatosTelas
    private void leerDatosFalda() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaTelas.getModel();
            List<Falda> listaFalda=  ControladorFalda.leerFalda();
            modeloTabla.setRowCount(0);
            for (Falda falda: listaFalda) {
                Object[] registroLeido = {falda.getNombre(), falda.getCodigo(),
                        falda.getColor(), falda.getPrecio(), falda.getEstilo()};
                modeloTabla.addRow(registroLeido);
            }
            tablaFaldas.setModel(modeloTabla);
        }catch (Exception e){}
    }//Fin del método: leerDatosFalda
    private void leerDatosCamisaSinMangas() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaCamisaSinMangas.getModel();
            List<CamisaSinMangas> listaCamisaSinMangas =  ControladorCamisaSinMangas.leerCamisaSinMangas();
            modeloTabla.setRowCount(0);
            for (CamisaSinMangas camisaSinMangas: listaCamisaSinMangas) {
                Object[] registroLeido = {camisaSinMangas.getNombre(), camisaSinMangas.getCodigo(),
                        camisaSinMangas.getColor(), camisaSinMangas.getPrecio(), camisaSinMangas.getEstilo()};
                modeloTabla.addRow(registroLeido);
            }
            tablaCamisaSinMangas.setModel(modeloTabla);
        }catch (Exception e){}
    }//Fin del método: leerDatosCamisaSinMangas.
    private void leerDatosPedidos() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaPedidos.getModel();
            List<Pedidos> listaPedido =  ControladorPedidos.leerPedido();
            modeloTabla.setRowCount(0);
            for (Pedidos pedido: listaPedido) {
                Object[] registroLeido = {pedido.getNombreProducto(), pedido.getComprador(), pedido.getCodigo(),
                pedido.getColor(), pedido.getPrecio(), pedido.getEstilo()};
                modeloTabla.addRow(registroLeido);
            }
            tablaPedidos.setModel(modeloTabla);
        }catch (Exception e){}
    }//Fin del método: leerDatosPedidos.

    private void leerDatosPantalonFormal() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaPantalonesFormales.getModel();
            List<PantalonFormal> listaPantalonFormal =  ControladorPantalonesFormales.leerPantalonFormal();
            modeloTabla.setRowCount(0);
            for (PantalonFormal pantalonFormal: listaPantalonFormal) {
                Object[] registroLeido = {pantalonFormal.getNombre(), pantalonFormal.getCodigo(),
                        pantalonFormal.getColor(), pantalonFormal.getPrecio(), pantalonFormal.getEstilo()};
                modeloTabla.addRow(registroLeido);
            }
            tablaPantalonesFormales.setModel(modeloTabla);
        }catch (Exception e){}
    }//Fin del método: leerDatosPantalonFormal
    //Borra el texto de los campos de texto.
    public void limpiarCamposDeTexto(JTextField camposDeTexto[]){
        for (JTextField campoDeTexto : camposDeTexto) {
            campoDeTexto.setText("");
        }
    }//Fin del método: Limpiar campos de texto.

    //Para comprobar que se ingresen números, en campos numericos.
    public boolean validarCamposNumericos(JTextField camposDeTexto[]){
        boolean validar = false;
            try{
                for (JTextField campoDeTexto : camposDeTexto) {
                    Double.parseDouble(campoDeTexto.getText());
                }
            }catch (NumberFormatException ex){validar = true;
            JOptionPane.showMessageDialog(null,
                    "Se deben ingresar números en los campos numéricos!",
                    null, JOptionPane.ERROR_MESSAGE);}
        return validar;
    }//Fin del método: validarCamposNumericos

    public void llenarCajaDeSeleccion(){
        cajaDeSeleccion.addItem("Camisa");
        cajaDeSeleccion.addItem("Camisa Formal");
        cajaDeSeleccion.addItem("Camisa Sin Mangas");
        cajaDeSeleccion.addItem("Corbata");
        cajaDeSeleccion.addItem("Falda");
        cajaDeSeleccion.addItem("Pantalón");
        cajaDeSeleccion.addItem("Pantalón Formal");
        cajaDeSeleccion.addItem("Personal");
        cajaDeSeleccion.addItem("Short");
        cajaDeSeleccion.addItem("Tela");
        cajaDeSeleccion.addItem("Vestido");
    }//Fin del método: llenarCajaDeSeleccion

    public static void main(String[] args){
        JFrame frame = new JFrame("Máquina Textil");
        frame.setContentPane(new Ventana().panelPrincipal);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}//Fin de la clase: Ventana.
