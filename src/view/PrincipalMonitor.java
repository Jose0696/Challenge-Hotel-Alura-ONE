package view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import controller.ControllerReserve;
import model.Reserve;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class PrincipalMonitor extends JFrame implements ActionListener{
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JComboBox<String> comboBox;
    private JButton btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3, btnNewButton_4, btnNewButton_5, btnNewButton_6, btnNewButton_7;
    private JTable table;
    private DefaultTableModel modelo;
    private JDateChooser entrada;
    private JDateChooser salida;
    private JLabel lblNewLabel_9;

    private ControllerReserve reservaController;
    private JTable table_1;
    private JTextField textField_6;

    /**
     * Create the panel.
     */
    public PrincipalMonitor() {

        this.reservaController= new ControllerReserve();

        getContentPane().setForeground(new Color(0, 0, 160));
        getContentPane().setBackground(new Color(208, 196, 176));
        getContentPane().setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 40, 1200, 720);
        setUndecorated(true);//retira la barra superior de la ventana

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 15));
        textField.setBounds(83, 66, 186, 30);
        textField.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.yellow));
        textField.setForeground(Color.yellow);
        textField.setOpaque(false);
        getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Arial", Font.BOLD, 15));
        textField_1.setBounds(333, 66, 186, 30);
        textField_1.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.yellow));
        textField_1.setForeground(Color.yellow);
        textField_1.setOpaque(false);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Arial", Font.BOLD, 15));
        textField_2.setBounds(580, 66, 81, 30);
        textField_2.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.yellow));
        textField_2.setForeground(Color.yellow);
        textField_2.setOpaque(false);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Arial", Font.BOLD, 15));
        textField_3.setBounds(727, 66, 152, 30);
        textField_3.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.yellow));
        textField_3.setForeground(Color.yellow);
        textField_3.setOpaque(false);
        getContentPane().add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Arial", Font.BOLD, 15));
        textField_4.setBounds(962, 66, 145, 30);
        textField_4.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.yellow));
        textField_4.setForeground(Color.yellow);
        textField_4.setOpaque(false);
        getContentPane().add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setEditable(false);
        textField_5.setFont(new Font("Arial", Font.BOLD, 15));
        textField_5.setBounds(840, 150, 145, 30);
        getContentPane().add(textField_5);
        textField_5.setColumns(10);

        comboBox = new JComboBox<String>();
        comboBox.setBackground(new Color(255, 255, 255));
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Tarjeta crédito", "Tarjeta débito", "Efectivo"}));
        comboBox.setFont(new Font("Arial", Font.BOLD, 15));
        comboBox.setBounds(613, 150, 180, 30);
        getContentPane().add(comboBox);

        entrada= new JDateChooser();
        entrada.getCalendarButton().setIcon(new ImageIcon(PrincipalMonitor.class.getResource("/img/calendar_icon.png")));
        entrada.setBounds(200, 150, 150, 30);
        entrada.setOpaque(false);
        entrada.getCalendarButton().setBounds(267, 1, 21, 31);
        entrada.getCalendarButton().setBackground(Color.white);
        entrada.setDateFormatString("yyyy-MM-dd");
        entrada.setFont(new Font("Arial", Font.BOLD, 15));
        entrada.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(246, 196, 14)));
        getContentPane().add(entrada);

        salida= new JDateChooser();
        salida.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(246, 196, 14)));
        salida.addPropertyChangeListener(new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                calculateValue(entrada, salida);
            }
        });
        salida.setBounds(400, 150, 150, 30);
        salida.getCalendarButton().setIcon(new ImageIcon(PrincipalMonitor.class.getResource("/img/calendar_icon.png")));
        salida.setDateFormatString("yyyy-MM-dd");
        salida.getCalendarButton().setBackground(Color.white);
        salida.setFont(new Font("Arial", Font.BOLD, 15));
        getContentPane().add(salida);

        btnNewButton_1 = new JButton("Modificar");
        btnNewButton_1.setForeground(new Color(0, 0, 0));
        btnNewButton_1.setBackground(new Color(246, 196, 14));
        btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 13));
        btnNewButton_1.setBounds(960, 240, 100, 27);
        btnNewButton_1.addActionListener(this);
        getContentPane().add(btnNewButton_1);

        btnNewButton_2 = new JButton("Eliminar");
        btnNewButton_2.setForeground(new Color(0, 0, 0));
        btnNewButton_2.setBackground(new Color(246, 196, 14));
        btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 13));
        btnNewButton_2.setBounds(1070, 240, 100, 27);
        btnNewButton_2.addActionListener(this);
        getContentPane().add(btnNewButton_2);

        btnNewButton_3 = new JButton("");
        btnNewButton_3.setIcon(new ImageIcon(PrincipalMonitor.class.getResource("/img/log-out.png")));
        btnNewButton_3.setBounds(8, 10, 30, 30);
        btnNewButton_3.addActionListener(this);
        getContentPane().add(btnNewButton_3);

        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setForeground(new Color(246, 196, 14));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel.setBounds(135, 40, 80, 25);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Apellido");
        lblNewLabel_1.setForeground(new Color(246, 196, 14));
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_1.setBounds(390, 40, 80, 25);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Edad");
        lblNewLabel_2.setForeground(new Color(246, 196, 14));
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_2.setBounds(595, 40, 50, 25);
        getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("País");
        lblNewLabel_3.setForeground(new Color(246, 196, 14));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_3.setBounds(765, 40, 70, 25);
        getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Teléfono");
        lblNewLabel_4.setForeground(new Color(166, 132, 1));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_4.setBounds(990, 40, 90, 25);
        getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Total a pagar");
        lblNewLabel_5.setForeground(new Color(166, 132, 1));
        lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_5.setBounds(846, 124, 130, 25);
        getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Forma de pago");
        lblNewLabel_6.setForeground(new Color(246, 196, 14));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_6.setBounds(628, 124, 150, 25);
        getContentPane().add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Fecha salida");
        lblNewLabel_7.setForeground(new Color(246, 196, 14));
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_7.setBounds(400, 124, 150, 25);
        getContentPane().add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Fecha entrada\r\n");
        lblNewLabel_8.setForeground(new Color(246, 196, 14));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 20));
        lblNewLabel_8.setBounds(200, 124, 150, 25);
        getContentPane().add(lblNewLabel_8);

        btnNewButton = new JButton("Registrar");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(246, 196, 14));
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 25));
        btnNewButton.setBounds(500, 215, 160, 45);
        btnNewButton.addActionListener(this);
        getContentPane().add(btnNewButton);

        modelo= new DefaultTableModel();

        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Edad");
        modelo.addColumn("País");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Fecha entrada");
        modelo.addColumn("Fecha salida");
        modelo.addColumn("Forma de pago");
        modelo.addColumn("Valor");

        table = new JTable(modelo);
        table.setBorder(new LineBorder(new Color(0, 0, 0)));
        table.setFont(new Font("Arial", Font.ITALIC, 15));
        table.setBounds(8, 306, 1186, 410);
        table.setRowHeight(20);

        TableColumn columnId= table.getColumnModel().getColumn(0);
        columnId.setPreferredWidth(10);
        TableColumn columnAge= table.getColumnModel().getColumn(3);
        columnAge.setPreferredWidth(10);
        TableColumn columnPay= table.getColumnModel().getColumn(9);
        columnPay.setPreferredWidth(90);
        getContentPane().add(table);

        table_1 = new JTable();
        table_1.setBackground(new Color(203, 201, 163));
        table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        table_1.setModel(new DefaultTableModel(
                new Object[][] {
                        {"ID", "Nombre", "Apellido", "Edad", "Tel\u00E9fono", "Pa\u00EDs", "Fecha ingreso", "Fecha salida", "Valor", "Forma de pago"},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
                }
        ) {
            boolean[] columnEdits = new boolean[] {
                    false, false, false, false, false, false, false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEdits[column];
            }
        });
        table_1.getColumnModel().getColumn(0).setPreferredWidth(10);
        table_1.getColumnModel().getColumn(3).setPreferredWidth(10);
        table_1.getColumnModel().getColumn(9).setPreferredWidth(90);
        table_1.setBounds(8, 280, 1186, 27);
        table_1.setFont(new Font("Arial", Font.ITALIC, 18));
        table_1.setRowHeight(30);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i=0; i<10; i++) {
            table_1.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }

        getContentPane().add(table_1);

        btnNewButton_4 = new JButton("X");
        btnNewButton_4.setVerticalAlignment(SwingConstants.TOP);
        btnNewButton_4.setForeground(new Color(255, 255, 255));
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 19));
        btnNewButton_4.setBackground(new Color(255, 0, 0));
        btnNewButton_4.setBounds(1170, 0, 30, 30);
        btnNewButton_4.addActionListener(this);
        btnNewButton_4.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        btnNewButton_4.setFocusable(false);
        getContentPane().add(btnNewButton_4);

        btnNewButton_5 = new JButton("Cargar");
        btnNewButton_5.setBackground(new Color(0, 255, 0));
        btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 15));
        btnNewButton_5.setBounds(40, 255, 85, 21);
        btnNewButton_5.addActionListener(this);
        getContentPane().add(btnNewButton_5);

        btnNewButton_6 = new JButton("Limpiar");
        btnNewButton_6.setBackground(new Color(255, 255, 255));
        btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 15));
        btnNewButton_6.setBounds(140, 255, 90, 21);
        btnNewButton_6.addActionListener(this);
        getContentPane().add(btnNewButton_6);

        JLabel lblNewLabel_10 = new JLabel("Buscar:");
        lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel_10.setForeground(new Color(246, 196, 14));
        lblNewLabel_10.setBounds(34, 225, 60, 20);
        getContentPane().add(lblNewLabel_10);

        btnNewButton_7 = new JButton("");
        btnNewButton_7.setBounds(166, 220, 25, 25);
        btnNewButton_7.addActionListener(this);
        getContentPane().add(btnNewButton_7);

        SetImageIcons(btnNewButton_7,"src/img/search-outline.png");

        textField_6 = new JTextField();
        textField_6.setFont(new Font("Arial", Font.BOLD, 15));
        textField_6.setBounds(95, 225, 70, 20);
        textField_6.setForeground(Color.yellow);
        textField_6.setOpaque(false);
        textField_6.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.yellow));
        getContentPane().add(textField_6);
        textField_6.setColumns(10);

        lblNewLabel_9 = new JLabel("");
        lblNewLabel_9.setBounds(0, 0, 1200, 273);
        getContentPane().add(lblNewLabel_9);
        SetImage(lblNewLabel_9,"src/img/hotel.png");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNewButton) {
            save();
            cleanForm();
        }
        if(e.getSource()==btnNewButton_1) {
            update();
            clean();
            charge();
        }
        if(e.getSource()==btnNewButton_2) {
            delete();
            clean();
            charge();
        }
        if(e.getSource()==btnNewButton_3 || e.getSource()==btnNewButton_4) {
            JOptionPane.showMessageDialog(null, "Ha cerrado sesión");
            Login init = new Login();
            init.setVisible(true);
            dispose();
        }

        if(e.getSource()==btnNewButton_5) {
            clean();
            charge();
        }

        if(e.getSource()==btnNewButton_6) {
            clean();
        }

        if(e.getSource()==btnNewButton_7) {
            clean();
            carryId();
            textField_6.setText("");
        }

    }

    private void carryId() {
        int look= Integer.parseInt(textField_6.getText());
        var lists= this.reservaController.listId(look);

        try {
            look= Integer.parseInt(textField_6.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Campo no valido, reviselo e intente nuevamente");
            return;
        }

        try {

            lists.forEach(list->modelo.addRow(new Object[] {
                    list.getId(),
                    list.getNameI(),
                    list.getLastname(),
                    list.getAge(),
                    list.getTelephone(),
                    list.getCountry(),
                    list.getAdmisionDate(),
                    list.getExitDate(),
                    list.getValueI(),
                    list.getPayWay()
            }));

        } catch (Exception e) {
            throw e;
        }

    }

    private void SetImage(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight()+500, Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }

    private void SetImageIcons(JButton button, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_DEFAULT));
        button.setIcon(icon);
        this.repaint();
    }

    private void calculateValue(JDateChooser dateA, JDateChooser dateE) {
        if(dateA.getDate() != null && dateE.getDate() !=null) {
            Calendar init = dateA.getCalendar();
            Calendar end = dateE.getCalendar();
            int days = -1; // Usamos -1 para contar a partir del dia siguiente
            int diary = 500;
            int value;

            while(init.before(end)||init.equals(end)) {
                days++;
                init.add(Calendar.DATE,1); //dias a ser aumentados
            }
            value = days * diary;
            textField_5.setText("$" + value);
        }
    }

    public void save() {

        String admissionDate= ((JTextField) entrada.getDateEditor().getUiComponent()).getText();
        String exitDate= ((JTextField) salida.getDateEditor().getUiComponent()).getText();
        int age;
        long telephone;

        if(textField.getText().isBlank() || textField_1.getText().isBlank() ||
                textField_2.getText().isBlank()|| textField_3.getText().isBlank() ||
                textField_4.getText().isBlank()|| textField_5.getText().isBlank()||
                admissionDate.isBlank() || exitDate.isBlank()) {
            JOptionPane.showMessageDialog(this, "Los campos son requeridos.");
            return;
        }

        try {
            age= Integer.parseInt(textField_2.getText());
            telephone = Long.parseLong(textField_4.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Campo no valido, reviselo e intente nuevamente");
            return;
        }

        Reserve reserve= new Reserve(textField.getText(), textField_1.getText(), age, telephone,
                textField_3.getText(), java.sql.Date.valueOf(admissionDate), java.sql.Date.valueOf(exitDate),
                textField_5.getText(), comboBox.getSelectedItem().toString());

        this.reservaController.save(reserve);

        JOptionPane.showMessageDialog(null, "Datos guardados correctamente, id: "+ reserve.getId());
    }

    public void charge() {
        var lists= this.reservaController.list();

        try {

            lists.forEach(list->modelo.addRow(new Object[] {
                    list.getId(),
                    list.getNameI(),
                    list.getLastname(),
                    list.getAge(),
                    list.getTelephone(),
                    list.getCountry(),
                    list.getAdmisionDate(),
                    list.getExitDate(),
                    list.getValueI(),
                    list.getPayWay()
            }));

        } catch (Exception exception) {
            throw exception;
        }
    }

    public void clean() {
        ((DefaultTableModel) table.getModel()).setRowCount(0);
    }

    private boolean chosenRow() {
        return table.getSelectedRowCount() == 0 || table.getSelectedColumnCount() == 0;
    }

    public void update() {

        if (chosenRow()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un registro");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
                .ifPresentOrElse(row->{
                    Integer id= Integer.valueOf(modelo.getValueAt(table.getSelectedRow(),0).toString());
                    String name = (String) modelo.getValueAt(table.getSelectedRow(), 1);
                    String lastname= (String) modelo.getValueAt(table.getSelectedRow(), 2);
                    Integer age= Integer.valueOf(modelo.getValueAt(table.getSelectedRow(),3).toString());
                    Long telephone= Long.valueOf(modelo.getValueAt(table.getSelectedRow(),4).toString());
                    String country= (String) modelo.getValueAt(table.getSelectedRow(), 5);
                    Date admission= Date.valueOf(modelo.getValueAt(table.getSelectedRow(), 6).toString());
                    Date exit= Date.valueOf(modelo.getValueAt(table.getSelectedRow(), 7).toString());
                    String value= (String) modelo.getValueAt(table.getSelectedRow(), 8);
                    String pay= (String) modelo.getValueAt(table.getSelectedRow(), 9);

                    this.reservaController.update(name, lastname, age, telephone, country, admission, exit, value, pay, id);
                    JOptionPane.showMessageDialog(this, "Datos modificados con exito");

                },()->JOptionPane.showMessageDialog(this, "Por favor, elije un registro"));

    }

    public void delete() {
        if (chosenRow()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un registro");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(table.getSelectedRow(), table.getSelectedColumn()))
                .ifPresentOrElse(fila->{
                    Integer id= Integer.valueOf(modelo.getValueAt(table.getSelectedRow(),0).toString());

                    this.reservaController.delete(id);
                    modelo.removeRow(table.getSelectedRow());
                    JOptionPane.showMessageDialog(this, "Datos eliminados con exito");

                },()->JOptionPane.showMessageDialog(this, "Por favor, elije un registro"));
    }

    public void cleanForm() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");
        textField_5.setText("");
        comboBox.setSelectedItem("Tarjeta crédito");
        entrada.setDate(null);
        salida.setDate(null);
    }
}
