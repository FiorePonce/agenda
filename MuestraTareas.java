package conexion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MuestraTareas {

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
					MuestraTareas window = new MuestraTareas();
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
	public MuestraTareas() {
		initialize();
		mostrarTareasJTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	    frame = new JFrame();
	    frame.setBounds(100, 100, 920, 620);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.getContentPane().setLayout(new BorderLayout());

	    tableModel = new DefaultTableModel(
	            new Object[][]{},
	            new String[]{"Tarea", "Fecha Finalización", "Estado", "Descripción"});

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
	

	public void mostrarTareasJTable() {
        String url = "jdbc:mysql://localhost:3306/agenda";
        String usuario = "fiorella";
        String contrasena = "T0m45F10r3ll4";

        try (Connection conn = DriverManager.getConnection(url, usuario, contrasena)) {
            String sql = "SELECT Nombre_Tarea, FechaVencimiento, Estado, Descripción FROM Tarea";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                tableModel.setRowCount(0);

                while (rs.next()) {
                    String nombreTarea = rs.getString("Nombre_Tarea");
                    String fechaFin = rs.getString("FechaVencimiento");
                    String estado = rs.getString("Estado");
                    String descripcion = rs.getString("Descripción");

                    tableModel.addRow(new Object[]{nombreTarea, fechaFin, estado, descripcion});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
		
	}

}
