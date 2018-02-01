import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.math.BigInteger;
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
  private JTextField tf10 = new JTextField();
  private JTextArea ta_ver_out = new JTextArea("");
    private JScrollPane ta_ver_outScrollPane = new JScrollPane(ta_ver_out);
  private JTextArea ta_ent_out = new JTextArea("");
    private JScrollPane ta_ent_outScrollPane = new JScrollPane(ta_ent_out);
  private JButton bt_ver = new JButton();
  private JButton bt_ent = new JButton();
  private JNumberField nf11 = new JNumberField();
  private JNumberField nf23 = new JNumberField();
  private JNumberField nf13 = new JNumberField();
  prim primi = new prim();   
  teilerfremd teil = new teilerfremd();
  verschluesselung ver = new verschluesselung();
  entschluesselung ent = new entschluesselung();
  eea eu = new eea();
  private JLabel jl_n = new JLabel();
  private JLabel jl_x = new JLabel();
  private JButton bt_create = new JButton();
  int prim1 = 0;
  int prim2 = 0;
  int n= 0;
  int x=0;
  int r = 0;
  String tempcomp = "";
  private JLabel jLabel1 = new JLabel();
  // Ende Attribute
  
  public GUI(String title) { 
    // Frame-Initialisierung
    super("RSA VERSCHÜSSELUNG");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 631; 
    int frameHeight = 460;
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
    tf10.setBounds(48, 176, 145, 41);
    tf10.setText("");
    cp.add(tf10);
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
    nf11.setBounds(48, 72, 145, 41);
    nf11.setText("");
    cp.add(nf11);
    nf23.setBounds(440, 72, 145, 41);
    nf23.setText("");
    cp.add(nf23);
    nf13.setBounds(264, 72, 145, 41);
    nf13.setText("");
    cp.add(nf13);
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
    jLabel1.setBounds(48, 8, 536, 49);
    jLabel1.setText("RSA VERCHÜSSELUNG");
    jLabel1.setFont(new Font("Agency FB", Font.BOLD, 12));
    cp.add(jLabel1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public GUI
  
  // Anfang Methoden
  public void bt_ver_ActionPerformed(ActionEvent evt) {
    bt_create_ActionPerformed(evt);
    ta_ver_out.setText(ver.ver(n,r,tf10.getText()));
  } // end of bt_ver_ActionPerformed
  
  public void bt_ent_ActionPerformed(ActionEvent evt) {
    if (tempcomp.equals(tempcomp) ) {
      tf_ent_in.setText("");
    } // end of if
    if (tf_ent_in.getText().isEmpty()) {
      tf_ent_in.setText(ta_ver_out.getText());
    } // end of if
    ta_ent_out.setText(ent.ent(eu.extGCD(r,x),n,tf_ent_in.getText()));
    tempcomp = tf_ent_in.getText();
  } // end of bt_ent_ActionPerformed
  
  public void bt_create_ActionPerformed(ActionEvent evt) {
    if (nf11.getText().isEmpty()) {
      prim1 = primi.prim1();
      nf11.setInt(prim1);
    } // end of if
    else {
      prim1 = nf11.getInt();
    } // end of if-else
    if (nf13.getText().isEmpty()) {
      prim2 = primi.prim2();
      nf13.setInt(prim2);
    } // end of if  
    else {
      prim2 = nf13.getInt();
    } // end of if-else
    n= (prim1)*(prim2);
    jl_n.setText("n = " + n);
    x=(prim1-1)*(prim2-1);
    jl_x.setText("x = " + x);
    if (nf23.getText().isEmpty()) {
      r = teil.getr(x);
      nf23.setInt(r);
    } // end of if  
    else {
      if (teil.prüf(x,nf23.getInt())) {
        r = nf23.getInt();
      } // end of if
      else {
        nf23.setText("error");  
      } // end of if-else
    } // end of if-else    
    
  } // end of bt_create_ActionPerformed
  
  // Ende Methoden
  
  public static void main(String[] args) {
    new GUI("GUI");
  } // end of main
  
} // end of class GUI
