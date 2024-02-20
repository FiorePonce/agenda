package conexion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JSeparator;

public class AgendaInt {

	private JFrame frame;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_5;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaInt window = new AgendaInt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgendaInt() {
		initialize();
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 239, 249));
		frame.setBounds(100, 100, 920, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\fiore\\Downloads\\Agenda Personal (1).png"));
		lblNewLabel.setBounds(290, 10, 301, 131);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Evento");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(234, 80, 48));
		btnNewButton.setFont(new Font("Impact", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 138, 223, 206);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAgregarTarea = new JButton("Tarea");
		btnAgregarTarea.setForeground(new Color(234, 80, 48));
		btnAgregarTarea.setFont(new Font("Impact", Font.PLAIN, 18));
		btnAgregarTarea.setBackground(new Color(255, 255, 255));
		btnAgregarTarea.setBounds(10, 354, 223, 206);
		frame.getContentPane().add(btnAgregarTarea);
		
		JPanel inicioPanel = new JPanel();
		inicioPanel.setBackground(new Color(255, 239, 249));
		inicioPanel.setBounds(260, 138, 628, 422);
		frame.getContentPane().add(inicioPanel);
		inicioPanel.setLayout(new CardLayout(0, 0));
		
		JPanel eventoPanel = new JPanel();
		eventoPanel.setBackground(new Color(255, 217, 241));
        inicioPanel.add(eventoPanel, "EventoPanel");
        eventoPanel.setLayout(null);

        JLabel lblEvento = new JLabel("EVENTO");
        lblEvento.setForeground(new Color(244, 142, 205));
        lblEvento.setFont(new Font("Impact", Font.PLAIN, 18));
        lblEvento.setBounds(93, 10, 61, 28);
        eventoPanel.add(lblEvento);
        
        JLabel lblNewLabel_1 = new JLabel("Hora Inicio");
        lblNewLabel_1.setForeground(new Color(234, 80, 48));
        lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(93, 115, 85, 27);
        eventoPanel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Fecha Inicio");
        lblNewLabel_2.setForeground(new Color(234, 80, 48));
        lblNewLabel_2.setFont(new Font("Impact", Font.PLAIN, 17));
        lblNewLabel_2.setBounds(93, 72, 90, 19);
        eventoPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Fecha finalización");
        lblNewLabel_3.setForeground(new Color(234, 80, 48));
        lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 17));
        lblNewLabel_3.setBounds(93, 168, 136, 19);
        eventoPanel.add(lblNewLabel_3);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Arial", Font.PLAIN, 13));
        textField_3.setBounds(239, 73, 274, 22);
        eventoPanel.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Descripción");
        lblNewLabel_4.setForeground(new Color(234, 80, 48));
        lblNewLabel_4.setFont(new Font("Impact", Font.PLAIN, 17));
        lblNewLabel_4.setBounds(93, 268, 110, 27);
        eventoPanel.add(lblNewLabel_4);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Arial", Font.PLAIN, 13));
        textField_4.setBounds(239, 268, 274, 82);
        eventoPanel.add(textField_4);
        textField_4.setColumns(10);
        
        JButton btnNewButton_1 = new JButton("Agregar");
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setForeground(new Color(244, 142, 205));
        btnNewButton_1.setFont(new Font("Impact", Font.PLAIN, 18));
        btnNewButton_1.setBounds(10, 360, 608, 52);
        eventoPanel.add(btnNewButton_1);
        
        btnNewButton_1.addActionListener(e -> {
        	String nombreEvento = textField_2.getText();
            String fechaInicio = textField_3.getText();
            String horaInicio = textField_1.getText();
            String fechaFin = textField.getText();
            String descripcion = textField_4.getText();
            String emailContacto = textField_5.getText();
            
            insertarEventos(nombreEvento, fechaInicio, horaInicio, fechaFin, descripcion, emailContacto);  
        });
        
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 13));
        textField.setColumns(10);
        textField.setBounds(239, 169, 274, 22);
        eventoPanel.add(textField);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Arial", Font.PLAIN, 13));
        textField_1.setColumns(10);
        textField_1.setBounds(239, 120, 90, 22);
        eventoPanel.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Arial", Font.PLAIN, 13));
        textField_2.setColumns(10);
        textField_2.setBounds(164, 14, 349, 28);
        eventoPanel.add(textField_2);
        
        JButton btnNewButton_3_1 = new JButton("");
        btnNewButton_3_1.setBounds(573, 10, 45, 39);
        eventoPanel.add(btnNewButton_3_1);
        btnNewButton_3_1.addActionListener(e -> {
            MuestraReg muestraRegistros = new MuestraReg();
            muestraRegistros.mostrarEventosJTable();
        });
        
        
        btnNewButton_3_1.setIcon(new ImageIcon("C:\\Users\\fiore\\Downloads\\pngegg.png"));
        btnNewButton_3_1.setForeground(new Color(244, 142, 205));
        btnNewButton_3_1.setFont(new Font("Impact", Font.PLAIN, 18));
        btnNewButton_3_1.setBackground(Color.WHITE);
        
        JLabel lblNewLabel_2_1 = new JLabel("(AAAA-MM-DD)");
        lblNewLabel_2_1.setForeground(new Color(234, 80, 48));
        lblNewLabel_2_1.setFont(new Font("Impact", Font.PLAIN, 13));
        lblNewLabel_2_1.setBounds(93, 89, 90, 19);
        eventoPanel.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("(AAAA-MM-DD)");
        lblNewLabel_2_1_1.setForeground(new Color(234, 80, 48));
        lblNewLabel_2_1_1.setFont(new Font("Impact", Font.PLAIN, 13));
        lblNewLabel_2_1_1.setBounds(93, 186, 90, 19);
        eventoPanel.add(lblNewLabel_2_1_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Email Contacto");
        lblNewLabel_1_1.setForeground(new Color(234, 80, 48));
        lblNewLabel_1_1.setFont(new Font("Impact", Font.PLAIN, 17));
        lblNewLabel_1_1.setBounds(93, 215, 118, 27);
        eventoPanel.add(lblNewLabel_1_1);
        
        textField_5 = new JTextField();
        textField_5.setFont(new Font("Arial", Font.PLAIN, 13));
        textField_5.setColumns(10);
        textField_5.setBounds(239, 220, 274, 22);
        eventoPanel.add(textField_5);
        

        JPanel tareaPanel = new JPanel();
        tareaPanel.setBackground(new Color(255, 217, 241));
        inicioPanel.add(tareaPanel, "TareaPanel");
        tareaPanel.setLayout(null);
        
        JLabel lblTarea = new JLabel("TAREA");
        lblTarea.setForeground(new Color(244, 142, 205));
        lblTarea.setFont(new Font("Impact", Font.PLAIN, 18));
        lblTarea.setBounds(104, 38, 54, 22);
        tareaPanel.add(lblTarea);
        
        textField_9 = new JTextField();
        textField_9.setFont(new Font("Arial", Font.PLAIN, 13));
        textField_9.setColumns(10);
        textField_9.setBounds(181, 38, 339, 24);
        tareaPanel.add(textField_9);
        
        textField_10 = new JTextField();
        textField_10.setFont(new Font("Arial", Font.PLAIN, 13));
        textField_10.setColumns(10);
        textField_10.setBounds(241, 108, 279, 24);
        tareaPanel.add(textField_10);
        
        JLabel lblFechaFinalizacin = new JLabel("Fecha finalización:");
        lblFechaFinalizacin.setForeground(new Color(234, 80, 48));
        lblFechaFinalizacin.setFont(new Font("Impact", Font.PLAIN, 17));
        lblFechaFinalizacin.setBounds(91, 110, 140, 22);
        tareaPanel.add(lblFechaFinalizacin);
        
        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setForeground(new Color(234, 80, 48));
        lblEstado.setFont(new Font("Impact", Font.PLAIN, 17));
        lblEstado.setBounds(91, 180, 54, 22);
        tareaPanel.add(lblEstado);
        
        textField_11 = new JTextField();
        textField_11.setFont(new Font("Arial", Font.PLAIN, 13));
        textField_11.setColumns(10);
        textField_11.setBounds(241, 178, 284, 24);
        tareaPanel.add(textField_11);
        
        JLabel lblDescripcin = new JLabel("Descripción:");
        lblDescripcin.setForeground(new Color(234, 80, 48));
        lblDescripcin.setFont(new Font("Impact", Font.PLAIN, 17));
        lblDescripcin.setBounds(91, 246, 91, 22);
        tareaPanel.add(lblDescripcin);
        
        textField_12 = new JTextField();
        textField_12.setFont(new Font("Arial", Font.PLAIN, 13));
        textField_12.setColumns(10);
        textField_12.setBounds(241, 246, 279, 92);
        tareaPanel.add(textField_12);
        
        JButton btnNewButton_3 = new JButton("Agregar");
        btnNewButton_3.setBackground(new Color(255, 255, 255));
        btnNewButton_3.setForeground(new Color(244, 142, 205));
        btnNewButton_3.setFont(new Font("Impact", Font.PLAIN, 18));
        btnNewButton_3.setBounds(10, 359, 608, 53);
        tareaPanel.add(btnNewButton_3);
        
        JButton btnNewButton_3_1_1 = new JButton("");
        btnNewButton_3_1_1.addActionListener(e -> {
            MuestraTareas muestraTarea = new MuestraTareas();
            muestraTarea.mostrarTareasJTable();
        });
        
        btnNewButton_3_1_1.setIcon(new ImageIcon("C:\\Users\\fiore\\Downloads\\pngegg.png"));
        btnNewButton_3_1_1.setForeground(new Color(244, 142, 205));
        btnNewButton_3_1_1.setFont(new Font("Impact", Font.PLAIN, 18));
        btnNewButton_3_1_1.setBackground(Color.WHITE);
        btnNewButton_3_1_1.setBounds(573, 10, 45, 39);
        tareaPanel.add(btnNewButton_3_1_1);
        
        btnNewButton_3.addActionListener(e -> {
        	String nombreTarea = textField_9.getText();
            String fechaFinTarea = textField_10.getText();
            String estadoTarea = textField_11.getText();
            String descripcionTarea = textField_12.getText();
            
            insertarTareas(nombreTarea, fechaFinTarea, estadoTarea, descripcionTarea);  
        });

        btnNewButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) inicioPanel.getLayout();
            cardLayout.show(inicioPanel, "EventoPanel");
        });

        btnAgregarTarea.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) inicioPanel.getLayout();
            cardLayout.show(inicioPanel, "TareaPanel");
        });
		

	}
	 public void insertarEventos (String nombreEvento, String fechaInicio, String horaInicio, String fechaFin, String descripcion, String emailContacto) {
		 String url = "jdbc:mysql://localhost:3306/agenda";
		 String usuario = "fiorella"; 
		 String contrasena = "T0m45F10r3ll4";

         try (Connection conn = DriverManager.getConnection(url, usuario, contrasena)) {
             String sql = "INSERT INTO Evento (Nombre_Evento, FechaInicio, Hora, FechaFin, Descripcion, EmailContacto) VALUES ( ?, ?, ?, ?, ?, ?)";
             try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                 pstmt.setString(1, nombreEvento);
                 pstmt.setString(2, fechaInicio);
                 pstmt.setString(3, horaInicio);
                 pstmt.setString(4, fechaFin);
                 pstmt.setString(5, descripcion);
                 pstmt.setString(6, emailContacto);

                 int filasAfectadas = pstmt.executeUpdate();
                 if (filasAfectadas > 0) {
                     System.out.println("Inserción exitosa.");
                 } else {
                     System.out.println("La inserción no tuvo éxito.");
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
	 
	 
	 
	 public void insertarTareas (String nombreTarea, String fechaFinTarea, String estadoTarea, String descripcionTarea) {
		 String url = "jdbc:mysql://localhost:3306/agenda";
		 String usuario = "fiorella"; 
		 String contrasena = "T0m45F10r3ll4";

         try (Connection conn = DriverManager.getConnection(url, usuario, contrasena)) {
             String sql = "INSERT INTO Tarea (Nombre_Tarea, Descripción, FechaVencimiento, Estado) VALUES ( ?, ?, ?, ?)";
             try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                 pstmt.setString(1, nombreTarea);
                 pstmt.setString(2, descripcionTarea);
                 pstmt.setString(3, fechaFinTarea);
                 pstmt.setString(4, estadoTarea);

                 int filasAfectadas = pstmt.executeUpdate();
                 if (filasAfectadas > 0) {
                     System.out.println("Inserción exitosa.");
                 } else {
                     System.out.println("La inserción no tuvo éxito.");
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
}

