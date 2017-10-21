package MyGUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SelectUI extends JFrame {
	private Panel pane1 = new Panel();
	private Panel pane2 = new Panel();
	private Panel pane3 = new Panel();
	private Panel pane4 = new Panel();
	private JLabel label=new JLabel();
	private JTextField jtext=new JTextField("请输入证件号码！",20);
	private JTextField outputtex=new JTextField("信息输出窗口！",30);
	private JButton ok=new JButton("OK");
	private JButton cancle=new JButton("Cancle");
	private JComboBox<String> jcom = new JComboBox<>(new String[] { "准考证号查询",
	"身份证号查询" });
	public SelectUI(){
		this.setSize(600, 420);
		this.setTitle("信息查询！");
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Container b = this.getContentPane();
		b.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/img/Select.jpg"));
		label.setIcon(icon);
		pane1.add(label);
		pane2.add(jtext);
		pane3.add(ok);
		pane3.add(cancle);
		pane3.add(jcom);
//		outputtex.setEnabled(false);
		pane4.add(outputtex);
		this.setLayout(new GridLayout(4, 1));
		this.add(pane1);
		this.add(pane2);
		this.add(pane3);
		this.add(pane4);
	}
	
}
