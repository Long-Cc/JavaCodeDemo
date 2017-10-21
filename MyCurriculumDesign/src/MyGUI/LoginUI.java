package MyGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {
	LoginImgPanel mypanel = new LoginImgPanel();
	private Panel pane1 = new Panel();
	private Panel pane2 = new Panel();
	private Panel pane3 = new Panel();
	private JLabel lu = new JLabel("用户名：");
	private JLabel lp = new JLabel("密码：");
	private JTextField jtx = new JTextField(20);
	private JPasswordField jpw = new JPasswordField(20);
	private JButton ok = new JButton("OK");
	private JButton cancel = new JButton("Cancel");
	private JComboBox<String> jcom = new JComboBox<>(new String[] { "插入数据",
			"查询数据" });
	private String str = null;

	public LoginUI() {
		super("登陆！");
		this.setSize(400, 350);
		this.setTitle("登陆！");
		Image image = null;
		try {
			image = ImageIO.read(this.getClass()
					.getResource("/img/javaimg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setIconImage(image);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		pane1.add(lu);
		pane1.add(jtx);
		pane2.add(lp);
		pane2.add(jpw);
		pane3.add(ok);
		pane3.add(cancel);
		pane3.add(jcom);
		this.setLayout(new GridLayout(4, 1));
		this.add(mypanel);
		this.add(pane1);
		this.add(pane2);
		this.add(pane3);
		this.initListener();
		str = jcom.getSelectedItem().toString();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class LoginImgPanel extends JPanel {
		public LoginImgPanel() {
			this.setSize(390, 68);
			this.setVisible(true);
		}

		@Override
		public void paint(Graphics g) {
			Image img = null;
			try {
				img = ImageIO.read(this.getClass()
						.getResource("/img/login.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(img, 5, 5, null);
		}
	}

	public void initListener() {

		jcom.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				str = jcom.getSelectedItem().toString();
			}
		});
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = jtx.getText();
				String passWord = new String(jpw.getPassword());
				if (name != null && passWord != null && "admin".equals(name)
						&& "123".equals(passWord)) {
					if ("插入数据".equals(str)) {
						new InsertUI();
						LoginUI.this.dispose();
					} else if ("查询数据".equals(str)) {
						new SelectUI();
						LoginUI.this.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "出错！！！");
					}
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码不正确！");
					jtx.setText("");
					jpw.setText("");
				}
			}
		});

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginUI.this.dispose();
			}
		});
	}

	public static void main(String[] args) {
		new LoginUI();
	}
}
