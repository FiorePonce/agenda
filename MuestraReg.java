package conexion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import java.sql.Statement;
import java.awt.Font;
import java.awt.Color;

public class MuestraReg {

	private JFrame frame;
	private JTable table;
    private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MuestraReg window = new MuestraReg();
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
	public MuestraReg() {
	    initialize();
	    mostrarEventosJTable();
	}

	private void initialize() {
	    frame = new JFrame();
	    frame.setBounds(100, 100, 920, 620);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.getContentPane().setLayout(new BorderLayout());

	    tableModel = new DefaultTableModel(
	            new Object[][]{},
	            new String[]{"Evento", "Fecha Inicio", "Horario", "Fecha Fin", "Descripcion", "Email Contacto"});

	        table = new JTable(tableModel);
	        table.setBackground(new Color(255, 217, 241));
	        table.setForeground(new Color(0, 0, 0));
	        table.setFont(new Font("Arial", Font.PLAIN, 16));
	        
	        JTableHeader header = table.getTableHeader();
	        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
	        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
	        header.setForeground(new Color(234, 80, 48));
	        header.setFont(new Font("Impact", Font.PLAIN, 17));  
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	        
	}


	public void mostrarEventosJTable() {
        String url = "jdbc:mysql://localhost:3306/agenda";
        String usuario = "fiorella";
        String contrasena = "T0m45F10r3ll4";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena)) {
            String sql = "SELECT Nombre_Evento, FechaInicio, Hora, FechaFin, Descripcion, EmailContacto FROM Evento";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                tableModel.setRowCount(0);

                while (rs.next()) {
                    String nombreEvento = rs.getString("Nombre_Evento");
                    String fechaInicio = rs.getString("FechaInicio");
                    String horaInicio = rs.getString("Hora");
                    String fechaFin = rs.getString("FechaFin");
                    String descripcion = rs.getString("Descripcion");
                    String emailContacto = rs.getString("EmailContacto");

                    tableModel.addRow(new Object[]{nombreEvento, fechaInicio, horaInicio, fechaFin, descripcion, emailContacto});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }
}
			
        

