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
  verschluesselung ver = new verschluesselung();
  private JLabel jl_n = new JLabel();
  private JLabel jl_x = new JLabel();
  private JButton bt_create = new JButton();
  int prim1 = 0;
  int prim2 = 0;
  int n= 0;
  int x=0;
  int r = 0;
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
    bt_create.setBounds(440, 120, 145, 41);
    bt_create.setText("Create");
    bt_create.setMargin(new Insets(2, 2, 2, 2));
    bt_create.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bt_create_ActionPerformed(evt);
      }
    });
    cp.add(bt_create);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public GUI
  
  // Anfang Methoden
  public void bt_ver_ActionPerformed(ActionEvent evt) {
    bt_create_ActionPerformed(evt);
    System.out.println(ver.ver());
  } // end of bt_ver_ActionPerformed

  public void bt_ent_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of bt_ent_ActionPerformed

  public void bt_create_ActionPerformed(ActionEvent evt) {
    if (tf_prim1.getText().isEmpty()) {
      prim1 = primi.prim1();
      tf_prim1.setInt(prim1);
    } // end of if
    else {
      prim1 = tf_prim1.getInt();
    } // end of if-else
    if (tf_prim2.getText().isEmpty()) {
      prim2 = primi.prim2();
      tf_prim2.setInt(prim2);
    } // end of if  
    else {
      prim2 = tf_prim2.getInt();
    } // end of if-else
    n= (prim1)*(prim2);
    jl_n.setText("n = " + n);
    x=(prim1-1)*(prim2-1);
    jl_x.setText("x = " + x);
    if (tf_r.getText().isEmpty()) {
      r = teil.getr(x);
      tf_r.setInt(r);
    } // end of if  
    else {
      if (teil.prüf(x,tf_r.getInt())) {
      r = tf_r.getInt();
      } // end of if
    else {
      tf_r.setText("error");  
    } // end of if-else
    } // end of if-else    
    
  } // end of bt_create_ActionPerformed

  // Ende Methoden
  
  public static void main(String[] args) {
    new GUI("GUI");
  } // end of main
  
} // end of class GUI