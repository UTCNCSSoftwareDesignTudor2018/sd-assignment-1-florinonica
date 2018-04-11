package presentation.views;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data_access.entities.Course;

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
		String[] columnNames = { "ID", "Course"};
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

	public void setTableContents(List<Course> l) {
		model.setRowCount(0);
		for (Course g : l) {
			Object[] o = new Object[5];
			o[0] = g.getCourseID();
			o[1] = g.getCourseName();
			model.addRow(o);
		}
		this.repaint();
	}
}
