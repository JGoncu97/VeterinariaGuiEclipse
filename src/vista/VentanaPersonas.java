package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
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

public class VentanaPersonas extends JFrame implements ActionListener {

	private JPanel miPanel;
	private JTextField txtDoc;
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JLabel lblDoc;
	private JLabel lblTitulo;
	private JLabel lblTelefono;
	private JLabel lblNombre;
	private JButton btnRegistrar;
	private JButton btnConsultar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnConsultarLista;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JSeparator separator;
	private Controlador miControlador;
	

	
	public VentanaPersonas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("Ventana Gestionar Personas");
		setLocationRelativeTo(null);
		setResizable(false);		
		
	}
	

	private void iniciarComponentes() {
		setBounds(100, 100, 600, 800);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));	
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		lblDoc = new JLabel("Documento:");
		txtDoc = new JTextField();
		
		lblTitulo = new JLabel("Gestionar Personas");
		
		lblTelefono = new JLabel("Telefono:");
		txtTelefono = new JTextField();
		
		lblNombre = new JLabel("Nombre:");
		txtNombre = new JTextField();
		
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDoc.setBounds(30, 100, 110, 30);
		miPanel.add(lblDoc);
		
		
		txtDoc.setBounds(135, 100, 160, 30);
		miPanel.add(txtDoc);
		txtDoc.setColumns(10);
		
		
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTitulo.setBounds(10, 20, 576, 40);
		miPanel.add(lblTitulo);
		
		
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelefono.setBounds(300, 100, 85, 30);
		miPanel.add(lblTelefono);
		
		
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(380, 100, 150, 30);
		miPanel.add(txtTelefono);
		
		
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(30, 170, 110, 30);
		miPanel.add(lblNombre);
		
		
		txtNombre.setColumns(10);
		txtNombre.setBounds(105, 170, 425, 30);
		miPanel.add(txtNombre);
		
		btnRegistrar = new JButton("Registrar");
		btnConsultar = new JButton("Consultar");
		btnActualizar = new JButton("Actualizar");
		btnEliminar = new JButton("Eliminar");
		btnConsultarLista = new JButton("Consultar Lista");
		
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(80, 240, 180, 40);
		miPanel.add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		
		
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(321, 240, 180, 40);
		miPanel.add(btnConsultar);
		btnConsultar.addActionListener(this);
		
		
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizar.setBounds(80, 300, 180, 40);
		miPanel.add(btnActualizar);
		btnActualizar.addActionListener(this);
		
		
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(321, 300, 180, 40);
		miPanel.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		
		btnConsultarLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarLista.setBounds(80, 360, 421, 40);
		miPanel.add(btnConsultarLista);
		btnConsultarLista.addActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 420, 500, 280);
		miPanel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		separator = new JSeparator();
		separator.setBounds(30, 220, 532, 2);
		miPanel.add(separator);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			registrarPersona();
		} else if (e.getSource() == btnConsultar) {
			consultarPersona();
		} else if (e.getSource() == btnActualizar) {
			actualizarPersona();
		} else if (e.getSource() == btnEliminar) {
			eliminacionPersona();
		}else if ( e.getSource() == btnConsultarLista) {
			consultarListPersona();
		}
		
		
	}
	
	public void registrarPersona() {
		String resultado = "";
		String documento= txtDoc.getText();
		String nombre= txtNombre.getText();
		String telefono= txtTelefono.getText();
		
		if (documento.isEmpty() || nombre.isEmpty() || telefono.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar diligenciados obligatoriamente");
				
			} else {
				PersonaVO miPersonaVO = new PersonaVO();
				miPersonaVO.setDocumento(documento);
				miPersonaVO.setNombre(nombre);
				miPersonaVO.setTelefono(telefono);
				

				
				resultado = miControlador.registrarPersona(miPersonaVO);
				

				
				JOptionPane.showMessageDialog(null, resultado);
				
				limpiarCampos();
				
			}
	}
	
	public void actualizarPersona() {
		String resultado="";
		String documento= txtDoc.getText();
		String nombre= txtNombre.getText();
		String telefono= txtTelefono.getText();
		
		if (documento.isEmpty() || nombre.isEmpty() || telefono.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar diligenciados obligatoriamente");
				
			} else {
				PersonaVO miPersonaVO = new PersonaVO();
				miPersonaVO.setDocumento(documento);
				miPersonaVO.setNombre(nombre);
				miPersonaVO.setTelefono(telefono);
				

				resultado = miControlador.actualizarPersona(miPersonaVO);
				
				JOptionPane.showMessageDialog(null, resultado);
				
				limpiarCampos();
				
			}
	}
	
	public void consultarPersona() {
		String documento = txtDoc.getText();
		
		if (documento.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese un documento para verificar la existencia en los registros");
			
		} else {
			try {
				PersonaVO miPersonaVO = miControlador.consultarPersona(documento);
				if (miPersonaVO == null) {
					textArea.setText("La Persona no se encuentra en los registros");
					
				} else {
					textArea.setText(miPersonaVO.toString());
					
				}
				
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, "Error al consultar la persona: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
	}
	
	public void eliminacionPersona() {
		String resultado="";
		String documento = txtDoc.getText();
		if(documento.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingrese un documento para verificar la existencia en los registros");
		}else {
			try {
				PersonaVO miPersona= miControlador.consultarPersona(documento);
				if(miPersona== null) {
					textArea.setText("La Persona no se encuentra en los registros");
				}else {
					resultado= miControlador.eliminarPersona(documento);
					textArea.setText(resultado);
					
				}
				
			}catch(RuntimeException e) {
				
			}
		}
	}
	
	public void consultarListPersona() {
		StringBuilder listaPersona = new StringBuilder();
		for(PersonaVO persona: miControlador.consultarListaPersonas()) {
			listaPersona.append("Documento: ").append(persona.getDocumento()).append("\n")
						.append(", Nombre: ").append(persona.getNombre()).append("\n")
						.append(", Telefono: ").append(persona.getTelefono()).append("\n\n");
		}
		
		textArea.setText(!listaPersona.isEmpty() ? listaPersona.toString() : "No hay personas registradas");
	}
	
	private void limpiarCampos() {
		txtDoc.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
		
	}

	
}
