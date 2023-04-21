package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import javax.swing.BoxLayout;

public class lista extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JButton btnNewButton;
    private JScrollPane scrollPane;
    private JList<String> list;
    private JPanel panel1;
    private JTextField textField_1;

    public static void main(String[] args) {
        lista frame = new lista();
        frame.setVisible(true);
    }

    public lista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        // primer textfield
        textField = new JTextField();
        textField.setBounds(12, 12, 114, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        btnNewButton = new JButton("Añadir");
        btnNewButton.setBounds(22, 77, 90, 21);
        contentPane.add(btnNewButton);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 145, 149, 116);
        contentPane.add(scrollPane);

        list = new JList<String>(new javax.swing.DefaultListModel<String>());
        scrollPane.setViewportView(list);

        panel1 = new JPanel();
        panel1.setBackground(new Color(149, 149, 149));
        panel1.setBounds(176, 12, 262, 249);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS)); // Set BoxLayout with vertical orientation
        contentPane.add(panel1);
        // segundo textfield
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(12, 45, 114, 21);
        contentPane.add(textField_1);

        // Agregar ActionListener al botón "Añadir"
        btnNewButton.addActionListener(e -> {
            String nombre = textField.getText();
            String telefono = textField_1.getText();
            if (!nombre.isEmpty() && !telefono.isEmpty()) {
                ((javax.swing.DefaultListModel<String>) list.getModel()).addElement(nombre);
            }
        });

        // Agregar ListSelectionListener al JList
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    String seleccionado = list.getSelectedValue();
                    if (seleccionado != null) {
                        panel1.removeAll();
                        String nombre = textField.getText();
                        String telefono = textField_1.getText();
                        panel1.add(new JLabel("Nombre: " + nombre));
                        panel1.add(new JLabel("Telefono: " + telefono));
                        panel1.revalidate();
                        panel1.repaint();
                    }
                }
            }
        });

    }
}

