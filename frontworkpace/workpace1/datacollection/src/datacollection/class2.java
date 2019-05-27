package datacollection;
//打印无符号整数位
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class class2 extends JFrame {
 public class2(){
    super( "打印无符号整数位" );
    Container c = getContentPane();
    c.setLayout( new FlowLayout() );
    c.add( new JLabel( "请输入整数: " ) );
    final JTextField output = new JTextField( 33 );
    JTextField input = new JTextField( 10 );
    input.addActionListener(
       new ActionListener() {
          //*********Found********
          public void actionPerformed( ActionEvent e ){
             int val = Integer.parseInt(
                e.getActionCommand() );
             //*********Found********
             output.setText( getBits( val ) );
          }
       }
    );
    c.add( input );
    c.add( new JLabel( "该数的二进制位表示是" ) );      
    output.setEditable( false );
   //*********Found********
    c.add( output );
    setSize( 720, 70 );
    setVisible(true);
 }

 private String getBits( int value ){
    int displayMask = 1 << 31;
    StringBuffer buf = new StringBuffer( 35 );
    for ( int c = 1; c <= 32; c++ ) {
       buf.append(
          ( value & displayMask ) == 0 ? '0' : '1' );
       value <<= 1;
       if ( c % 8 == 0 )
          buf.append( ' ' );
    }
    return buf.toString();
 }

 public static void main( String args[] ){
    class2 app = new class2();
    app.addWindowListener(
       new WindowAdapter() {
   //*********Found********
          public void windowClosing(WindowEvent e ){
             System.exit( 0 );
          }
       }
    );
 }
}
