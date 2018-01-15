import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 12.01.2018
  * @author 
  */

public class GUI extends JFrame {
  // Anfang Attribute
  private JTextField tf_ent_in = new JTextField();
  private JTextField tf_ver_in = new JTextField();
  private JTextArea ta_ver_out = new JTextArea("");
    private JScrollPane ta_ver_outScrollPane = new JScrollPane(ta_ver_out);
  private JTextArea ta_ent_out = new JTextArea("");
    private JScrollPane ta_ent_outScrollPane = new JScrollPane(ta_ent_out);
  private JButton bt_ver = new JButton();
  private JButton bt_ent = new JButton();
  private JNumberField tf_prim1 = new JNumberField();
  private JNumberField tf_r = new JNumberField();
  private JNumberField tf_prim2 = new JNumberField();
  prim primi = new prim();   
  teilerfremd teil = new teilerfremd();
  private JLabel jl_n = new JLabel();
  private JLabel jl_x = new JLabel();
  // Ende Attribute
  
  public GUI(String title) { 
    // Frame-Initialisierung
    super("RSA VERSCHÜSSELUNG");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 631; 
    int frameHeight = 462;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    tf_ent_in.setBounds(48, 240, 145, 41);
    cp.add(tf_ent_in);
    tf_ver_in.setBounds(48, 176, 145, 41);
    cp.add(tf_ver_in);
    ta_ver_outScrollPane.setBounds(264, 176, 145, 41);
    cp.add(ta_ver_outScrollPane);
    ta_ent_outScrollPane.setBounds(264, 240, 145, 41);
    cp.add(ta_ent_outScrollPane);
    bt_ver.setBounds(440, 176, 145, 41);
    bt_ver.setText("Verschlüsseln");
    bt_ver.setMargin(new Insets(2, 2, 2, 2));
    bt_ver.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bt_ver_ActionPerformed(evt);
      }
    });
    cp.add(bt_ver);
    bt_ent.setBounds(440, 240, 145, 41);
    bt_ent.setText("Entschlüsseln");
    bt_ent.setMargin(new Insets(2, 2, 2, 2));
    bt_ent.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bt_ent_ActionPerformed(evt);
      }
    });
    cp.add(bt_ent);
    tf_prim1.setBounds(48, 72, 145, 41);
    tf_prim1.setText("");
    cp.add(tf_prim1);
    tf_r.setBounds(440, 72, 145, 41);
    tf_r.setText("");
    cp.add(tf_r);
    tf_prim2.setBounds(264, 72, 145, 41);
    tf_prim2.setText("");
    cp.add(tf_prim2);
    jl_n.setBounds(48, 128, 147, 33);
    jl_n.setText("n = ");
    cp.add(jl_n);
    jl_x.setBounds(264, 128, 147, 33);
    jl_x.setText("x = ");
    cp.add(jl_x);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public GUI
  
  // Anfang Methoden
  public void bt_ver_ActionPerformed(ActionEvent evt) {
    int prim1 = primi.prim1();
    int prim2 = primi.prim2();
    tf_prim1.setInt(prim1);
    tf_prim2.setInt(prim2);
    int n= (prim1)*(prim2);
    jl_n.setText("n = " + n);
    int x=(prim1-1)*(prim2-1);
    jl_x.setText("x = " + x);
    tf_r.setInt(teil.getr(x));
  } // end of bt_ver_ActionPerformed

  public void bt_ent_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of bt_ent_ActionPerformed

  // Ende Methoden
  
  public static void main(String[] args) {
    new GUI("GUI");
  } // end of main
  
} // end of class GUI
