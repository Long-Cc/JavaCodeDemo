package MyGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import examStudent.ExamStudent;
import examStudent.ExamStudentDao;

@SuppressWarnings("serial")
public class SelectUI extends JFrame {
	ExamStudentDao examStudentDao = new ExamStudentDao();
	private Panel pane1 = new Panel();
	private Panel pane2 = new Panel();
	private Panel pane3 = new Panel();
	private Panel pane4 = new Panel();
	private JLabel label = new JLabel();
	private JTextField jtext = new JTextField("请输入证件号码！", 20);
	private JTextArea outputtex = new JTextArea(2, 40);
	private JScrollPane pane = new JScrollPane(outputtex);
	private JButton ok = new JButton("OK");
	private JButton cancel = new JButton("Cancel");
	private JComboBox<String> jcom = new JComboBox<>(new String[] { "准考证号查询",
			"身份证号查询" });

	private String number;
	private String str = jcom.getSelectedItem().toString();

	public SelectUI() {
		this.setSize(600, 420);
		this.setTitle("信息查询！");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Container b = this.getContentPane();
		b.setBackground(Color.WHITE);
		ImageIcon icon = new ImageIcon(this.getClass().getResource(
				"/img/Select.jpg"));
		label.setIcon(icon);
		pane1.add(label);
		pane2.add(jtext);
		pane3.add(ok);
		pane3.add(cancel);
		pane3.add(jcom);
		// outputtex.setLineWrap(true);// 激活自动换行功能
		pane4.add(pane);
		this.setLayout(new GridLayout(4, 1));
		this.add(pane1);
		this.add(pane2);
		this.add(pane3);
		this.add(pane4);
		this.initListener();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initListener() {
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectUI.this.dispose();
			}
		});

		jcom.addItemListener(new ItemListener() {// 复选框事件：

			@Override
			public void itemStateChanged(ItemEvent e) {
				str = jcom.getSelectedItem().toString();
			}
		});
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				number = jtext.getText();
				if ("准考证号查询".equals(str)) {
					List<ExamStudent> list = examStudentDao
							.getExamCardBeanListHandler(number);
					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "查无此人！");
					} else {
						for (Object obj : list) {
							outputtex.setText(obj.toString());
						}
					}
				} else if ("身份证号查询".equals(str)) {
					List<ExamStudent> list = examStudentDao
							.getIdCardBeanListHandler2(number);
					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "查无此人！");
					} else {
						for (Object obj : list) {
							outputtex.setText(obj.toString());
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "未知错误！");
				}
			}

		});
		this.repaint();
	}
}
