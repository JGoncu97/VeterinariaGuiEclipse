package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JLabel lblTitulo;
	private JButton btnPersonas;
	private JButton btnMascotas;
	private Controlador miControlador;
	

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("Ventana Principal");
		setLocationRelativeTo(null);
		setResizable(false);				
		
	}
	

	private void iniciarComponentes() {
		setBounds(100, 100, 657, 491);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);		
		
		lblTitulo = new JLabel("Sistema Veterinario ABC");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTitulo.setBounds(10, 40, 623, 37);
		panelPrincipal.add(lblTitulo);
		
		btnPersonas = new JButton("Gestionar Personas");
		btnPersonas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPersonas.setBounds(79, 353, 180, 40);
		panelPrincipal.add(btnPersonas);
		btnPersonas.addActionListener(this);
		
		btnMascotas = new JButton("Gestionar Mascotas");
		btnMascotas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMascotas.setBounds(384, 353, 180, 40);
		panelPrincipal.add(btnMascotas);
		btnMascotas.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPersonas) {
			miControlador.mostrarVentanaPersonas();
		} else if (e.getSource() == btnMascotas) {
			miControlador.mostrarVentanaMascotas();
		}
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
		
	}
}
