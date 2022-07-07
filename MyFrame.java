import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    float num1, num2, num3, num4, num5;
    float mo, sum;

    JPanel row1, row2, row3, row4;

    JLabel label;
    String str = "ΟΡΙΣΤΕ ΚΑΘΕ ΠΕΔΙΟ ΓΙΑ ΚΑΘΕ ΑΡΙΘΜΟ";

    TextField textFieldNum1;
    TextField textFieldNum2;
    TextField textFieldNum3;
    TextField textFieldNum4;
    TextField textFieldNum5;

    JButton buttonReset;
    JButton buttonCalculate;
    TextField textMO;

    MyFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        //this.setLayout(new FlowLayout()); // if you add this it will not work...
        this.setSize(500,150);
        this.setVisible(true);

        // row 1 with the text inside it...
        row1 = new JPanel();
        //row1.setBackground(Color.RED);
        row1.setPreferredSize(new Dimension(166, 30));
        label = new JLabel(str);
        row1.add(label);

        // row 2 the text fields...
        row2 = new JPanel();
        //row2.setBackground(Color.BLACK);
        textFieldNum1 = new TextField();
        textFieldNum1.setPreferredSize(new Dimension(75, 20));
        textFieldNum2 = new TextField();
        textFieldNum2.setPreferredSize(new Dimension(75, 20));
        textFieldNum3 = new TextField();
        textFieldNum3.setPreferredSize(new Dimension(75, 20));
        textFieldNum4 = new TextField();
        textFieldNum4.setPreferredSize(new Dimension(75, 20));
        textFieldNum5 = new TextField();
        textFieldNum5.setPreferredSize(new Dimension(75, 20));
        row2.setPreferredSize(new Dimension(166, 166));

        row2.add(textFieldNum1);
        row2.add(textFieldNum2);
        row2.add(textFieldNum3);
        row2.add(textFieldNum4);
        row2.add(textFieldNum5);

        // row 3 RESET AND  CALCULATE
        row3 = new JPanel();
        //row3.setBackground(Color.YELLOW);
        row3.setPreferredSize(new Dimension(500, 60));
        buttonReset = new JButton("RESET");
        buttonReset.setFocusable(false);
        buttonReset.setBounds(new Rectangle());
        buttonCalculate = new JButton("CALCULATE");
        buttonCalculate.setFocusable(false);
        buttonCalculate.setBounds(new Rectangle());

        row3.add(buttonReset);
        row3.add(buttonCalculate);

        // row 4
        row4 = new JPanel();
        String str2 = "ΜΕΣΗ ΤΙΜΗ";
        JLabel mo = new JLabel(str2);
        textMO = new TextField();
        textMO.setPreferredSize(new Dimension(75, 20));
        row4.add(mo);
        row4.add(textMO);
        row3.add(row4);

        buttonReset.addActionListener(this);
        buttonCalculate.addActionListener(this);

        this.add(row1, BorderLayout.NORTH); // attached to the top
        this.add(row2, BorderLayout.CENTER);
        this.add(row3, BorderLayout.SOUTH);
        //this.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try
        {
            num1 = Integer.valueOf(textFieldNum1.getText());
            num2 = Integer.valueOf(textFieldNum2.getText());
            num3 = Integer.valueOf(textFieldNum3.getText());
            num4 = Integer.valueOf(textFieldNum4.getText());
            num5 = Integer.valueOf(textFieldNum5.getText());
        }
        catch (NumberFormatException x)
        {
            System.out.println("--CANNOT CONVERT NUM--");
        }

        if(e.getSource() == buttonReset)
        {
            textMO.setText(null);
            textFieldNum1.setText(null);
            textFieldNum2.setText(null);
            textFieldNum3.setText(null);
            textFieldNum4.setText(null);
            textFieldNum5.setText(null);
            mo = 0;
            sum = 0;
        }

        if(e.getSource() == buttonCalculate)
        {
            sum = num1 + num2 + num3 + num4 + num5;
            mo = sum / 5;
            textMO.setText(String.valueOf(mo));
            JOptionPane.showMessageDialog(null, "SUM IS --> " + sum);
        }

    }
}

