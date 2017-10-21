package MyGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import examStudent.ExamStudentDao;

@SuppressWarnings("serial")
public class InsertUI extends JFrame {
	ExamStudentDao examStudentDao = new ExamStudentDao();
	InsertImgPanel imgPanel = new InsertImgPanel();
	private Panel pan1 = new Panel();
	private Panel pan2 = new Panel();

	private Panel pan3 = new Panel();
	private Panel pan4 = new Panel();
	private Panel pan5 = new Panel();

	private JLabel label2 = new JLabel("考试等级：");
	private JTextField type = new JTextField(12);
	private JLabel label3 = new JLabel("身份证号：");
	private JTextField idCard = new JTextField(20);
	private JLabel label4 = new JLabel("准考证号：");
	private JTextField examCard = new JTextField(20);
	private JLabel label5 = new JLabel("学生姓名：");
	private JTextField studentName = new JTextField(20);
	private JLabel label6 = new JLabel("所在城市：");
	private JTextField location = new JTextField(10);
	private JLabel label7 = new JLabel("成绩：");
	private JTextField grade = new JTextField(10);
	private JButton but = new JButton("OK");

	private int t;
	private String ic;
	private String ec;
	private String sn;
	private String l;
	private int g;
	
	
	public InsertUI() {
		this.setSize(600, 420);
		this.setTitle("信息插入！");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Container b = this.getContentPane();
		b.setBackground(Color.WHITE);
		pan1.add(label2);
		pan1.add(type);
		pan2.add(label3);
		pan2.add(idCard);

		pan3.add(label4);
		pan3.add(examCard);

		pan4.add(label5);
		pan4.add(studentName);

		pan5.add(label6);
		pan5.add(location);
		pan5.add(label7);
		pan5.add(grade);
		pan5.add(but);
		this.setLayout(new GridLayout(6, 1));
		this.add(imgPanel);
		this.add(pan1);
		this.add(pan2);
		this.add(pan3);
		this.add(pan4);
		this.add(pan5);
		this.listener();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void listener(){
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 t=Integer.parseInt(type.getText());
				 ic=idCard.getText();
				 ec=examCard.getText();
				 sn=studentName.getText();
				 l=location.getText();
				 g=Integer.parseInt(grade.getText());
				 examStudentDao.update(t,ic,ec,sn,l,g);
				 JOptionPane.showMessageDialog(null, "插入成功");
				
			}
		});
	}
	class InsertImgPanel extends Panel {
		public InsertImgPanel() {
			// this.setSize(390, 68);
			this.setVisible(true);
		}

		@Override
		public void paint(Graphics g) {
			Image img = null;
			try {
				img = ImageIO.read(this.getClass().getResource(
						"/img/insert.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(img, 120, 0, null);
		}
	}
}
