package presentation.user_interface;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import data_access.models.StudentEnrollment;

@SuppressWarnings("serial")
public class EnrollmentsView extends JFrame {
	private JTable table;
	private DefaultTableModel model;

	public EnrollmentsView() {
		this.setTitle("Grades");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(640, 480);
		JPanel content = new JPanel();
		this.setContentPane(content);
		content.setLayout(null);
		String[] columnNames = { "ID", "Student ID", "Enrollment ID"};
		model = new DefaultTableModel();
		table = new JTable(model);
		model.setColumnIdentifiers(columnNames);
		content.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setEnabled(false);
		scrollPane.setBounds(0, 0, 624, 441);
		content.add(scrollPane);
	}

	public void setTableContents(List<StudentEnrollment> l) {
		model.setRowCount(0);
		for (StudentEnrollment g : l) {
			Object[] o = new Object[5];
			o[0] = g.getEnrollmentID();
			o[1] = g.getStudentID();
			o[2] = g.getCourseID();
			model.addRow(o);
		}
		this.repaint();
	}
}
