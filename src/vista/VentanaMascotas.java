package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import vo.MascotaVO;
import vo.PersonaVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class VentanaMascotas extends JFrame implements ActionListener {

	
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtRaza;
	private JTextField txtNombre;
	private JTextField txtSexo;
	private JLabel lblId;
	private JLabel lblTitulo;
	private JLabel lblRaza;
	private JLabel lblNombre;
	private JButton btnRegistrar;
	private JButton btnConsultar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnConsultarLista;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JSeparator separator;
	private JLabel lblSexo;
	private Controlador miControlador;
	

	/**
	 * Create the frame.
	 */
	public VentanaMascotas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("Ventana Gestionar Mascotas");
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	
	private void iniciarComponentes() {
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Gestionar Mascotas");
		lblId = new JLabel("Id Dueño:");
		lblNombre = new JLabel("Nombre:");
		lblRaza = new JLabel("Raza:");
		lblSexo = new JLabel("Sexo:");
		
		txtId = new JTextField();
		txtNombre = new JTextField();
		txtRaza = new JTextField();
		txtSexo = new JTextField();
		
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTitulo.setBounds(10, 20, 576, 40);
		contentPane.add(lblTitulo);
		
	
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(30, 100, 95, 30);
		contentPane.add(lblId);
		
		
		txtId.setBounds(120, 100, 165, 30);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(30, 170, 81, 30);
		contentPane.add(lblNombre);
		
		
		txtNombre.setColumns(10);
		txtNombre.setBounds(110, 170, 175, 30);
		contentPane.add(txtNombre);
		
		
		lblRaza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRaza.setBounds(295, 100, 60, 30);
		contentPane.add(lblRaza);
		
	
		txtRaza.setColumns(10);
		txtRaza.setBounds(356, 100, 200, 30);
		contentPane.add(txtRaza);
		
		
	
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSexo.setBounds(295, 170, 81, 30);
		contentPane.add(lblSexo);
		
	
		txtSexo.setColumns(10);
		txtSexo.setBounds(356, 170, 200, 30);
		contentPane.add(txtSexo);
		
		btnRegistrar = new JButton("Registrar");
		btnConsultar = new JButton("Consultar");
		btnActualizar = new JButton("Actualizar");
		btnEliminar = new JButton("Eliminar");
		btnConsultarLista = new JButton("Consultar Lista");
		
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(80, 240, 180, 40);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		
		
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(321, 240, 180, 40);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(this);
		
		
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizar.setBounds(80, 300, 180, 40);
		contentPane.add(btnActualizar);
		btnActualizar.addActionListener(this);
		
	
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(321, 300, 180, 40);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		
		btnConsultarLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarLista.setBounds(80, 360, 421, 40);
		contentPane.add(btnConsultarLista);
		btnConsultarLista.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 420, 500, 280);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		separator = new JSeparator();
		separator.setBounds(30, 220, 532, 2);
		contentPane.add(separator);
		
		
		
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnRegistrar) {
			registrarMascota();
		}else if ( e.getSource()== btnActualizar) {
			actualizarMascota();
		}else if( e.getSource()== btnConsultar) {
			consultarMascota();
		}else if ( e.getSource()== btnEliminar) {
			eliminacionMascota();
		}else if( e.getSource() == btnConsultarLista) {
			consultarListMascota();
		}
		
	}
	
	public void registrarMascota() {
		String resultado = "";
		String id= txtId.getText();
		String nombre= txtNombre.getText();
		String raza= txtRaza.getText();
		String sexo= txtSexo.getText();
		
		if (id.isEmpty() || nombre.isEmpty() || raza.isEmpty() || sexo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar diligenciados obligatoriamente");
				
			} else {
				MascotaVO miMascota = new MascotaVO();
				miMascota.setIdDueño(id);
				miMascota.setNombre(nombre);
				miMascota.setRaza(raza);
				miMascota.setSexo(sexo);
				

				
				resultado = miControlador.registrarMascota(miMascota);
				

				
				JOptionPane.showMessageDialog(null, resultado);
				
				limpiarCampos();
				
			}
	}
	
	
	public void actualizarMascota() {
		String resultado = "";
		String id= txtId.getText();
		String nombre= txtNombre.getText();
		String raza= txtRaza.getText();
		String sexo= txtSexo.getText();
		
		if (id.isEmpty() || nombre.isEmpty() || raza.isEmpty() || sexo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar diligenciados obligatoriamente");
				
			} else {
				MascotaVO miMascota = new MascotaVO();
				miMascota.setIdDueño(id);
				miMascota.setNombre(nombre);
				miMascota.setRaza(raza);
				miMascota.setSexo(sexo);
				
				

				resultado = miControlador.actualizarMascota(miMascota);
				
				JOptionPane.showMessageDialog(null, resultado);
				
				limpiarCampos();
				
			}
	}
	
	
	public void consultarMascota() {
		String id = txtId.getText();
		
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese el id para verificar la existencia en los registros");
			
		} else {
			try {
				MascotaVO miMascota = miControlador.consultarMascota(id);
				if (miMascota == null) {
					textArea.setText("La Mascota no se encuentra en los registros");
					
				} else {
					textArea.setText(miMascota.toString());
					
				}
				
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, "Error al consultar la Mascota: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
	}
	
	
	public void eliminacionMascota() {
		String resultado="";
		String id = txtId.getText();
		if(id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese id para verificar la existencia en los registros");
		}else {
			try {
				MascotaVO miMascota= miControlador.consultarMascota(id);
				if(miMascota== null) {
					textArea.setText("La mascota no se encuentra en los registros");
				}else {
					resultado= miControlador.eliminarMascota(id);
					textArea.setText(resultado);
					
				}
				
			}catch(RuntimeException e) {
				
			}
		}
	}
	
	
	public void consultarListMascota() {
		StringBuilder listaMascota = new StringBuilder();
		for(MascotaVO mascota: miControlador.consultarListaMascota()) {
			listaMascota.append("Mascota: ").append("\n")
						.append("Id Dueño: ").append(mascota.getIdDueño()).append("\n")
						.append("Nombre: ").append(mascota.getNombre()).append("\n")
						.append("Raza: ").append(mascota.getRaza()).append("\n")
						.append("Sexo: ").append(mascota.getSexo()).append("\n\n");
		}
		
		textArea.setText(!listaMascota.isEmpty() ? listaMascota.toString() : "No hay mascotas registradas");
	}
	
	
	private void limpiarCampos() {
		txtId.setText("");
		txtRaza.setText("");
		txtNombre.setText("");
		txtSexo.setText("");
	}
}
