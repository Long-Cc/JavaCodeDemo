package MyGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InsertUI extends JFrame {
	InsertImgPanel imgPanel = new InsertImgPanel();
	private Panel pan1 = new Panel();
	private Panel pan2 = new Panel();
	private Panel pan3 = new Panel();
	private Panel pan4 = new Panel();
	private Panel pan5 = new Panel();
	// private JPanel pan = new JPanel();
	private JLabel label1 = new JLabel("序号：");
	private JTextField tex1 = new JTextField(8);
	private JLabel label2 = new JLabel("考试等级：");
	private JTextField tex2 = new JTextField(12);
	private JLabel label3 = new JLabel("身份证号：");
	private JTextField tex3 = new JTextField(20);
	private JLabel label4 = new JLabel("准考证号：");
	private JTextField tex4 = new JTextField(20);
	private JLabel label5 = new JLabel("学生姓名：");
	private JTextField tex5 = new JTextField(20);
	private JLabel label6 = new JLabel("所在城市：");
	private JTextField tex6 = new JTextField(10);
	private JLabel label7 = new JLabel("成绩：");
	private JTextField tex7 = new JTextField(10);
	private JButton but = new JButton("OK");

	public InsertUI() {
		this.setSize(600, 420);
		this.setTitle("信息插入！");
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Container b = this.getContentPane();
		b.setBackground(Color.WHITE);
		pan1.add(label1);
		pan1.add(tex1);
		pan1.add(label2);
		pan1.add(tex2);
		pan2.add(label3);
		pan2.add(tex3);

		pan3.add(label4);
		pan3.add(tex4);

		pan4.add(label5);
		pan4.add(tex5);

		pan5.add(label6);
		pan5.add(tex6);
		pan5.add(label7);
		pan5.add(tex7);
		pan5.add(but);
		this.setLayout(new GridLayout(6, 1));
		this.add(imgPanel);
		this.add(pan1);
		this.add(pan2);
		this.add(pan3);
		this.add(pan4);
		this.add(pan5);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JTextField getTex1() {
		return tex1;
	}

	public JTextField getTex2() {
		return tex2;
	}

	public JTextField getTex3() {
		return tex3;
	}

	public JTextField getTex4() {
		return tex4;
	}

	public JTextField getTex5() {
		return tex5;
	}

	public JTextField getTex6() {
		return tex6;
	}

	public JTextField getTex7() {
		return tex7;
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
