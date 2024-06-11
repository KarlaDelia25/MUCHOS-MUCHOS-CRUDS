package Papeleria;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PantallaPapeleria {

	private JFrame frmPapeleria;
	private JTextField txtid;
	private JTextField txtnom;
	private JTextField txtpre;
	private JTextField txtcan;
	private JTextField txtto;

	/**
	 * Launch the application.
	 */
	public void limpiar() {
		txtid.setText("");
		txtnom.setText("");
		txtpre.setText("");
		txtcan.setText("");
		txtto.setText("");

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPapeleria window = new PantallaPapeleria();
					window.frmPapeleria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaPapeleria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPapeleria = new JFrame();
		frmPapeleria.setTitle("Papeleria");
		frmPapeleria.setBounds(100, 100, 450, 300);
		frmPapeleria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPapeleria.getContentPane().setLayout(null);
		frmPapeleria.setLocationRelativeTo(null);

		JLabel lblid = new JLabel("Id");
		lblid.setBounds(10, 11, 46, 14);
		frmPapeleria.getContentPane().add(lblid);

		txtid = new JTextField();
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtid.getText().length()>=3) {
					e.consume();
				}
			}
		});
		txtid.setBounds(10, 36, 86, 20);
		frmPapeleria.getContentPane().add(txtid);
		txtid.setColumns(10);

		JLabel lblnom = new JLabel("Nombre");
		lblnom.setBounds(10, 78, 46, 14);
		frmPapeleria.getContentPane().add(lblnom);

		txtnom = new JTextField();
		txtnom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtid.getText().length()>=20) {
					e.consume();
				}
			}
		});
		txtnom.setBounds(10, 103, 86, 20);
		frmPapeleria.getContentPane().add(txtnom);
		txtnom.setColumns(10);

		JLabel lblpre = new JLabel("Precio");
		lblpre.setBounds(10, 144, 46, 14);
		frmPapeleria.getContentPane().add(lblpre);

		txtpre = new JTextField();
		txtpre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtid.getText().length()>=20) {
					e.consume();
				}
			}
		});
		txtpre.setBounds(10, 177, 86, 20);
		frmPapeleria.getContentPane().add(txtpre);
		txtpre.setColumns(10);

		JLabel lblcan = new JLabel("Cantidad");
		lblcan.setBounds(134, 11, 46, 14);
		frmPapeleria.getContentPane().add(lblcan);

		txtcan = new JTextField();
		txtcan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtid.getText().length()>=20) {
					e.consume();
				}
			}
		});
		txtcan.setBounds(118, 36, 86, 20);
		frmPapeleria.getContentPane().add(txtcan);
		txtcan.setColumns(10);

		JLabel lbltotal = new JLabel("Total");
		lbltotal.setBounds(134, 78, 46, 14);
		frmPapeleria.getContentPane().add(lbltotal);

		txtto = new JTextField();
		txtto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtid.getText().length()>=20) {
					e.consume();
				}
			}
		});
		txtto.setBounds(118, 103, 86, 20);
		frmPapeleria.getContentPane().add(txtto);
		txtto.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NegocioPapeleria ne = new NegocioPapeleria();
				try {
					if (txtid.getText().isEmpty() || txtnom.getText().isEmpty() || txtpre.getText().isEmpty()
							|| txtcan.getText().isEmpty() || txtto.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
					} else {
						ne.setId(txtid.getText());
						ne.setNom(txtnom.getText());
						ne.setPre(txtpre.getText());
						ne.setCan(txtcan.getText());
						ne.setTotal(txtto.getText());

						if (ne.insertar()) {
							JOptionPane.showMessageDialog(null, "Se registró correctamente el producto");
							limpiar();
						} else {
							JOptionPane.showMessageDialog(null, "error");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "error");

				}

			}
		});
		btnGuardar.setBounds(260, 35, 89, 23);
		frmPapeleria.getContentPane().add(btnGuardar);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NegocioPapeleria ne = new 	NegocioPapeleria();
				try {
					String x = JOptionPane.showInputDialog("Introduce el id");
					ne.setId(x);
					if (ne.cargar()) {
						txtid.setText(ne.getId());
						txtnom.setText(ne.getNom());
						txtpre.setText(ne.getPre());
						txtcan.setText(ne.getCan());
						txtto.setText(ne.getTotal());
						

					} else {
						JOptionPane.showMessageDialog(null, "erro");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "error");
				}
			}
			
		});
		btnCargar.setBounds(260, 88, 89, 23);
		frmPapeleria.getContentPane().add(btnCargar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NegocioPapeleria ne = new NegocioPapeleria();
				try {
					if (txtid.getText().isEmpty() || txtnom.getText().isEmpty() || txtpre.getText().isEmpty()
							|| txtcan.getText().isEmpty() || txtto.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "CAMPOS VACÍOS");
					} else {
						ne.setId(txtid.getText());
						ne.setNom(txtnom.getText());
						ne.setPre(txtpre.getText());
						ne.setCan(txtcan.getText());
						ne.setTotal(txtto.getText());

						if (ne.actualizar()) {
							JOptionPane.showMessageDialog(null, "Se registró correctamente el producto");
							limpiar();
						} else {
							JOptionPane.showMessageDialog(null, "error");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "error");

				}

			}
		});
		btnActualizar.setBounds(260, 140, 89, 23);
		frmPapeleria.getContentPane().add(btnActualizar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NegocioPapeleria ne = new 	NegocioPapeleria();
				try {
					String x = JOptionPane.showInputDialog("Introduce el id");
					ne.setId(x);
					if (ne.cargar()) {
						
						

					} else {
						JOptionPane.showMessageDialog(null, "erro");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		btnEliminar.setBounds(260, 188, 89, 23);
		frmPapeleria.getContentPane().add(btnEliminar);
	}
}
