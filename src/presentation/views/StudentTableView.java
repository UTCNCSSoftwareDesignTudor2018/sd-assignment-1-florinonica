package presentation.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import data_access.entities.Student;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;

@SuppressWarnings("serial")
public class StudentTableView extends JFrame {
	private JPanel content;
	private JTextField searchTextField;
	private JButton viewStudentsButton;
	private JButton addStudentButton;
	private JButton deleteStudentButton;
	private JButton saveButton;
	private JButton viewGradesButton;
	private JButton viewEnrollmentsButton;
	private JTable table;
	private DefaultTableModel model;
	private JLabel lblNoStudentSelected;

	public StudentTableView() {
		this.setTitle("Students");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(900, 600);
		content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);

		viewStudentsButton = new JButton("View students");
		viewStudentsButton.setFont(new Font("Calibri", Font.BOLD, 16));
		viewStudentsButton.setBounds(100, 20, 200, 50);
		content.add(viewStudentsButton);

		addStudentButton = new JButton("Add student");
		addStudentButton.setFont(new Font("Calibri", Font.BOLD, 16));
		addStudentButton.setBounds(100, 70, 200, 50);
		content.add(addStudentButton);

		deleteStudentButton = new JButton("Delete");
		deleteStudentButton.setFont(new Font("Calibri", Font.BOLD, 16));
		deleteStudentButton.setBounds(300, 70, 200, 50);
		content.add(deleteStudentButton);

		saveButton = new JButton("Save");
		saveButton.setFont(new Font("Calibri", Font.BOLD, 16));
		saveButton.setBounds(500, 70, 200, 50);
		content.add(saveButton);

		searchTextField = new JTextField();
		searchTextField.setBounds(500, 200, 150, 20);
		content.add(searchTextField);
		searchTextField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Search:");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setBounds(400, 200, 90, 20);
		content.add(lblNewLabel);

		viewGradesButton = new JButton("View grades");
		viewGradesButton.setFont(new Font("Calibri", Font.BOLD, 16));
		viewGradesButton.setBounds(300, 20, 200, 50);
		content.add(viewGradesButton);

		lblNoStudentSelected = new JLabel("No student selected!");
		lblNoStudentSelected.setForeground(Color.RED);
		lblNoStudentSelected.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNoStudentSelected.setBounds(300, 150, 200, 20);
		lblNoStudentSelected.setVisible(false);
		content.add(lblNoStudentSelected);

		viewEnrollmentsButton = new JButton("View Enrollments");
		viewEnrollmentsButton.setFont(new Font("Calibri", Font.BOLD, 16));
		viewEnrollmentsButton.setBounds(500, 20, 200, 50);
		content.add(viewEnrollmentsButton);

		String[] columnNames = { "Student ID", "Username", "Password", "First Name", "Last Name", "Group", "Email",
				"Identity Card Number", "CNP", "Address" };
		model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				if (column == 0 || column == 3 || column == 4 || column == 5 || column == 7 || column == 8)
					return false;
				return true;
			}
		};
		table = new JTable(model);
		model.setColumnIdentifiers(columnNames);
		table.setBounds(0, 250, 900, 340);
		content.add(table);
		final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setRowSorter(sorter);
		table.setEnabled(true);
		scrollPane.setBounds(0, 250, 900, 340);
		content.add(scrollPane);
		searchTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = searchTextField.getText();
				if (text.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(text));
				}
			}
		});
	}

	public void addAddStudentListener(ActionListener al) {
		addStudentButton.addActionListener(al);
	}

	public void addDeleteStudentListener(ActionListener al) {
		deleteStudentButton.addActionListener(al);
	}

	public void addSaveListener(ActionListener al) {
		saveButton.addActionListener(al);
	}

	public void addViewStudentsListener(ActionListener al) {
		viewStudentsButton.addActionListener(al);
	}

	public void addViewGradesListener(ActionListener al) {
		viewGradesButton.addActionListener(al);
	}

	public void addViewEnrollmentsListener(ActionListener al) {
		viewEnrollmentsButton.addActionListener(al);
	}

	public void setTableContents(List<Student> l) {
		model.setRowCount(0);
		for (Student s : l) {
			Object[] o = new Object[10];
			o[0] = s.getStudentID();
			o[1] = s.getUsername();
			o[2] = s.getPassword();
			o[3] = s.getFirstName();
			o[4] = s.getLastName();
			o[5] = s.getGroup();
			o[6] = s.getEmail();
			o[7] = s.getIdentityCardNumber();
			o[8] = s.getCNP();
			o[9] = s.getAddress();
			model.addRow(o);
		}
		this.repaint();
	}

	public void noStudentSelected() {
		lblNoStudentSelected.setVisible(true);
	}

	public void studentSelected() {
		lblNoStudentSelected.setVisible(false);
	}
	
	public String getData(int column) {
		return (String) table.getValueAt(table.getSelectedRow(), column);
	}

}
