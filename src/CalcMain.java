//Andrew Kelly
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JToggleButton;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import javax.swing.SwingConstants;

public class CalcMain extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static volatile boolean Pressed = false;
    public static boolean isPressed() {
        synchronized (CalcMain.class) {
            return Pressed;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CalcMain frame = new CalcMain();
                    frame.setVisible(true);
                    frame.setResizable(false);

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        });
    }




    public CalcMain() {
        setResizable(false);
        setBackground(SystemColor.menu);
        setFont(new Font("Segoe UI", Font.PLAIN, 12));
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 366, 537);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.control);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);


        //output label
        final JLabel output = new JLabel("0");
        output.setHorizontalAlignment(SwingConstants.RIGHT);
        output.setBounds(29, 64, 281, 41);
        JLabel label_3 = new JLabel("");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setBounds(130, 39, 169, 30);

        //toggle buttons
        JToggleButton rdbtnHex = new JToggleButton("HEX");
        rdbtnHex.setBounds(10, 110, 55, 23);
        JToggleButton rdbtnDec = new JToggleButton("DEC");
        rdbtnDec.setBounds(10, 138, 55, 23);
        JToggleButton rdbtnOct = new JToggleButton("OCT");
        rdbtnOct.setBounds(10, 166, 53, 23);
        JToggleButton rdbtnBin = new JToggleButton("BIN");
        rdbtnBin.setBounds(10, 194, 53, 23);

        //labels
        JLabel label_Hexadecimal = new JLabel("0");
        label_Hexadecimal.setBounds(68, 110, 104, 23);
        JLabel label_Decimal = new JLabel("0");
        label_Decimal.setBounds(68, 138, 104, 23);
        JLabel label_Octal = new JLabel("0");
        label_Octal.setBounds(68, 166, 109, 23);
        JLabel label_Binary = new JLabel("0");
        label_Binary.setBounds(68, 194, 104, 23);

        //buttons
        JButton btnA = new JButton("A");
        btnA.setBounds(10, 335, 53, 35);
        JButton btnB = new JButton("B");
        btnB.setBounds(68, 335, 57, 35);
        JButton btnC = new JButton("C");
        btnC.setBounds(10, 375, 53, 35);
        JButton btnD = new JButton("D");
        btnD.setBounds(68, 375, 57, 35);
        JButton btnE = new JButton("E");
        btnE.setBounds(10, 415, 53, 35);
        JButton btnF = new JButton("F");
        btnF.setBounds(68, 415, 57, 35);

        JButton button_13 = new JButton("9");
        button_13.setBounds(238, 335, 53, 35);
        JButton button_9 = new JButton("8");
        button_9.setBounds(182, 335, 51, 35);
        JButton button_5 = new JButton("7");
        button_5.setBounds(130, 335, 47, 35);
        JButton button_12 = new JButton("6");
        button_12.setBounds(238, 375, 53, 35);
        JButton button_8 = new JButton("5");
        button_8.setBounds(182, 375, 51, 35);
        JButton button_4 = new JButton("4");
        button_4.setBounds(130, 375, 47, 35);
        JButton button_11 = new JButton("3");
        button_11.setBounds(238, 415, 53, 35);
        JButton button_7 = new JButton("2");
        button_7.setBounds(182, 415, 51, 35);
        JButton button_3 = new JButton("1");
        button_3.setBounds(130, 415, 47, 35);


        ButtonGroup hexGroup = new ButtonGroup();
        hexGroup.add(rdbtnDec);
        hexGroup.add(rdbtnOct);
        hexGroup.add(rdbtnBin);

        ButtonGroup decGroup = new ButtonGroup();
        hexGroup.add(rdbtnHex);
        hexGroup.add(rdbtnOct);
        hexGroup.add(rdbtnBin);

        ButtonGroup octGroup = new ButtonGroup();
        hexGroup.add(rdbtnHex);
        hexGroup.add(rdbtnDec);
        hexGroup.add(rdbtnBin);

        ButtonGroup binGroup = new ButtonGroup();
        hexGroup.add(rdbtnHex);
        hexGroup.add(rdbtnOct);
        hexGroup.add(rdbtnDec);

        ArrayList<String> decimalList = new ArrayList<String>();



        ActionListener actionListener = new ActionListener() {
            boolean wasHex = false;
            boolean wasDec = true;
            boolean wasOct = false;
            boolean wasBin = false;
            boolean equals = false;
            public void actionPerformed(ActionEvent actionEvent) {

                //for hexadecimal toggle
                //****************************************************************************************************************************************************************************************************
                if (rdbtnHex.isSelected()) {
                    hexGroup.clearSelection();
                    rdbtnHex.setSelected(true);
                    btnA.setEnabled(true);
                    btnB.setEnabled(true);
                    btnC.setEnabled(true);
                    btnD.setEnabled(true);
                    btnE.setEnabled(true);
                    btnF.setEnabled(true);
                    button_13.setEnabled(true);
                    button_9.setEnabled(true);
                    button_5.setEnabled(true);
                    button_12.setEnabled(true);
                    button_8.setEnabled(true);
                    button_4.setEnabled(true);
                    button_11.setEnabled(true);
                    button_7.setEnabled(true);

                    output.setText(label_Hexadecimal.getText());
                    for(int i=1; i<decimalList.size(); i++) {
                        if(decimalList.get(i)== "0" && decimalList.get(i-1)=="0") {
                            decimalList.remove(i-1);
                        }
                    }

                    if(wasDec == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {

                                decimalList.set(i, decimalToHex(decimalList.get(i)));
                            }

                        }
                        wasDec = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }
                    if(wasOct == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {
                                decimalList.set(i, OctalToHex(decimalList.get(i)));
                            }
                        }
                        wasOct = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    if(wasBin == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {
                                decimalList.set(i, HexToOctal(decimalList.get(i)));
                            }
                        }
                        wasBin = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    wasHex = true;
                    if((actionEvent.getActionCommand() != "=") && (actionEvent.getActionCommand() != "C ") && (actionEvent.getActionCommand() != "CE") &&
                            actionEvent.getActionCommand() != "DEC" && actionEvent.getActionCommand() != "OCT" && actionEvent.getActionCommand() != "HEX" && actionEvent.getActionCommand() != "BIN" && actionEvent.getActionCommand() != "\u232B") {

                        if((actionEvent.getActionCommand() !="+")&& (actionEvent.getActionCommand()!="\u00D7") && (actionEvent.getActionCommand() !="\u2212") &&(actionEvent.getActionCommand() !="\u00F7") && decimalList.size()>0
                                && decimalList.get(decimalList.size()-1) != "+" && decimalList.get(decimalList.size()-1) != "\u2212" &&
                                decimalList.get(decimalList.size()-1) != "\u00D7" && decimalList.get(decimalList.size()-1) != "\u00F7" &&(actionEvent.getActionCommand() !="Mod")
                                && decimalList.get(decimalList.size()-1) != "Mod" && (decimalList.get(decimalList.size()-1)).length() < 4 && !equals){

                            //combines strings into one number
                            decimalList.add(decimalList.size()-1, decimalList.get(decimalList.size()-1) + actionEvent.getActionCommand());
                            decimalList.remove(decimalList.size()-1);


                            String miniOut = "";
                            for(int i=1; i< decimalList.size();i++) {
                                miniOut+= decimalList.get(i);
                            }
                            label_3.setText(miniOut);

                            output.setText(actionEvent.getActionCommand());

                        }

                        else if((decimalList.size()!=0) &&(decimalList.get(decimalList.size()-1) == "+" || decimalList.get(decimalList.size()-1) == "\u00D7" || decimalList.get(decimalList.size()-1) == "\u2212" || decimalList.get(decimalList.size()-1) == "\u00F7" ||
                                decimalList.get(decimalList.size()-1) == "Mod") && (actionEvent.getActionCommand() == "+" || actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" || actionEvent.getActionCommand() == "\u00F7" ||
                                actionEvent.getActionCommand() == "Mod")) {
                            decimalList.set((decimalList.size()-1), actionEvent.getActionCommand());

                        }

                        else if (decimalList.size()==0) {//adds a to front
                            equals = false;
                            decimalList.add("0");
                            output.setText(actionEvent.getActionCommand());
                            decimalList.add(actionEvent.getActionCommand());
                        }
                        else if ((decimalList.get(decimalList.size()-1)).length() == 4){
                            equals = false;
                            if(actionEvent.getActionCommand() == "+" ||actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" ||actionEvent.getActionCommand() == "\u00F7" ||
                                    actionEvent.getActionCommand() == "Mod") {
                                label_3.setVisible(true);

                                String miniOut = "";
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                                label_3.setText(miniOut);
                            }

                        }

                        else{//adds everything else

                            label_3.setVisible(true);
                            String miniOut = "";
                            if(actionEvent.getActionCommand() == "+" ||actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" ||actionEvent.getActionCommand() == "\u00F7" ||
                                    actionEvent.getActionCommand() == "Mod" && equals) {
                                equals = false;
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                            }
                            else if(equals) {
                                equals = false;
                                decimalList.clear();
                                decimalList.add("0");
                                decimalList.add(actionEvent.getActionCommand());

                            }
                            else {
                                equals = false;
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                            }

                            label_3.setText(miniOut);

                        }

                        //if number count is at max
                        if(decimalList.get(decimalList.size()-1) == "+" ||decimalList.get(decimalList.size()-1) == "\u00D7" || decimalList.get(decimalList.size()-1) == "\u2212" || decimalList.get(decimalList.size()-1) == "\u00F7" ||
                                decimalList.get(decimalList.size()-1) == "Mod") {
                            equals = false;
                            output.setText(decimalList.get(decimalList.size()-2));
                            label_3.setVisible(true);
                            String miniOut = "";
                            for(int i=1; i< decimalList.size();i++) {
                                miniOut+= decimalList.get(i);
                            }
                            label_3.setText(miniOut);
                        }

                        else {
                            output.setText(decimalList.get(decimalList.size()-1));

                        }
                        label_3.setVisible(true);


                    }

                    if(actionEvent.getActionCommand() == "\u232B" && !decimalList.isEmpty()) {//backspace
                        equals = false;
                        if((decimalList.get(decimalList.size()-1)).length() ==1) {

                            decimalList.set(decimalList.size()-1,"0");
                        }
                        else{
                            String tempString;
                            tempString = decimalList.get(decimalList.size()-1);
                            tempString = tempString.substring(0, tempString.length()-1);
                            decimalList.set(decimalList.size()-1, tempString);
                        }
                        output.setText(decimalList.get(decimalList.size()-1));
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    if(actionEvent.getActionCommand() == "C ") {
                        equals = false;
                        decimalList.clear();
                        output.setText("0");
                        label_3.setVisible(false);
                        label_3.setText("");
                    }

                    if(actionEvent.getActionCommand() == "CE") {
                        equals = false;
                        if(decimalList.size()>0) {
                            decimalList.set((decimalList.size()-1),"0");
                        }
                        else {
                            decimalList.clear();
                            decimalList.add(0,"0");
                        }
                        output.setText("0");
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    if(actionEvent.getActionCommand() == "=") {
                        equals = true;
                        label_3.setVisible(false);
                        label_3.setText("");
                        output.setText(String.valueOf(HexTotal(decimalList)));
                        decimalList.clear();
                        decimalList.add(0, "0");
                        decimalList.add(1, output.getText());


                    }

                    //labels
                    label_Decimal.setText(HexToDecimal(output.getText()));
                    label_Binary.setText(HexToBinary(output.getText()));
                    label_Hexadecimal.setText(output.getText());
                    label_Octal.setText(HexToOctal(output.getText()));


                }


                //for decimal toggle
                //************************************************************************************************************************************************************************************************************
                if (rdbtnDec.isSelected()) {

                    decGroup.clearSelection();
                    btnA.setEnabled(false);
                    btnB.setEnabled(false);
                    btnC.setEnabled(false);
                    btnD.setEnabled(false);
                    btnE.setEnabled(false);
                    btnF.setEnabled(false);
                    button_13.setEnabled(true);
                    button_9.setEnabled(true);
                    button_5.setEnabled(true);
                    button_12.setEnabled(true);
                    button_8.setEnabled(true);
                    button_4.setEnabled(true);
                    button_11.setEnabled(true);
                    button_7.setEnabled(true);

                    output.setText(label_Decimal.getText());


                    for(int i=1; i<decimalList.size(); i++) {
                        if(decimalList.get(i)== "0" && decimalList.get(i-1)=="0") {
                            decimalList.remove(i-1);
                        }
                    }

                    if(wasHex == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {
                                decimalList.set(i, HexToDecimal(decimalList.get(i)));
                            }
                        }
                        wasHex = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    if(wasOct == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {
                                decimalList.set(i, OctalToDecimal(decimalList.get(i)));
                            }
                        }
                        wasOct = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }
                    if(wasBin == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {
                                decimalList.set(i, BinaryToDecimal(decimalList.get(i)));
                            }
                        }
                        wasBin = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }
                    wasDec = true;

                    if((actionEvent.getActionCommand() != "=") && (actionEvent.getActionCommand() != "C ") && (actionEvent.getActionCommand() != "CE") &&
                            actionEvent.getActionCommand() != "DEC" && actionEvent.getActionCommand() != "OCT" && actionEvent.getActionCommand() != "HEX" && actionEvent.getActionCommand() != "BIN" && actionEvent.getActionCommand() != "\u232B") {


                        if((actionEvent.getActionCommand() !="+")&& (actionEvent.getActionCommand()!="\u00D7") && (actionEvent.getActionCommand() !="\u2212") &&(actionEvent.getActionCommand() !="\u00F7") && decimalList.size()>0
                                && decimalList.get(decimalList.size()-1) != "+" && decimalList.get(decimalList.size()-1) != "\u2212" &&
                                decimalList.get(decimalList.size()-1) != "\u00D7" && decimalList.get(decimalList.size()-1) != "\u00F7" &&(actionEvent.getActionCommand() !="Mod")
                                && decimalList.get(decimalList.size()-1) != "Mod" && (decimalList.get(decimalList.size()-1)).length() < 4 && (decimalList.get(decimalList.size()-1) != "0") && !equals){

                            //combines strings into one number
                            decimalList.add(decimalList.size()-1, decimalList.get(decimalList.size()-1) + actionEvent.getActionCommand());
                            decimalList.remove(decimalList.size()-1);


                            String miniOut = "";
                            for(int i=1; i< decimalList.size();i++) {
                                miniOut+= decimalList.get(i);
                            }
                            label_3.setText(miniOut);

                            output.setText(actionEvent.getActionCommand());

                        }

                        else if((decimalList.size()!=0) &&(decimalList.get(decimalList.size()-1) == "+" || decimalList.get(decimalList.size()-1) == "\u00D7" || decimalList.get(decimalList.size()-1) == "\u2212" || decimalList.get(decimalList.size()-1) == "\u00F7" ||
                                decimalList.get(decimalList.size()-1) == "Mod") && (actionEvent.getActionCommand() == "+" || actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" || actionEvent.getActionCommand() == "\u00F7" ||
                                actionEvent.getActionCommand() == "Mod")) {
                            decimalList.set((decimalList.size()-1), actionEvent.getActionCommand());

                        }

                        else if (decimalList.size()==0) {//adds a to front
                            equals = false;
                            decimalList.add("0");

                            output.setText(actionEvent.getActionCommand());
                            decimalList.add(actionEvent.getActionCommand());
                        }

                        else if ((decimalList.get(decimalList.size()-1)).length() == 4){//when max out
                            equals = false;
                            if(actionEvent.getActionCommand() == "+" ||actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" ||actionEvent.getActionCommand() == "\u00F7" ||
                                    actionEvent.getActionCommand() == "Mod") {
                                label_3.setVisible(true);

                                String miniOut = "";
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                                label_3.setText(miniOut);
                            }

                        }
                        else{//adds everything else

                            label_3.setVisible(true);
                            String miniOut = "";
                            if((actionEvent.getActionCommand() == "+" ||actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" ||actionEvent.getActionCommand() == "\u00F7" ||
                                    actionEvent.getActionCommand() == "Mod" )&& equals) {
                                equals = false;
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                            }
                            else if(equals) {
                                equals = false;
                                decimalList.clear();
                                decimalList.add("0");
                                decimalList.add(actionEvent.getActionCommand());

                            }
                            else {
                                equals = false;
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                            }

                            label_3.setText(miniOut);

                        }
                        //removes last input if the input was not a number
                        if(decimalList.get(decimalList.size()-1) == "+" ||decimalList.get(decimalList.size()-1) == "\u00D7" || decimalList.get(decimalList.size()-1) == "\u2212" || decimalList.get(decimalList.size()-1) == "\u00F7" ||
                                decimalList.get(decimalList.size()-1) == "Mod" ) {
                            output.setText(decimalList.get(decimalList.size()-2));
                            label_3.setVisible(true);
                            String miniOut = "";
                            for(int i=1; i< decimalList.size();i++) {
                                miniOut+= decimalList.get(i);
                            }
                            label_3.setText(miniOut);
                        }

                        else {
                            output.setText(decimalList.get(decimalList.size()-1));

                        }
                        label_3.setVisible(true);

                    }

                    if(actionEvent.getActionCommand() == "\u232B" && !decimalList.isEmpty()) {//backspace
                        equals = false;
                        if((decimalList.get(decimalList.size()-1)).length() ==1) {

                            decimalList.set(decimalList.size()-1,"0");
                        }
                        else{
                            String tempString;
                            tempString = decimalList.get(decimalList.size()-1);
                            tempString = tempString.substring(0, tempString.length()-1);
                            decimalList.set(decimalList.size()-1, tempString);
                        }
                        output.setText(decimalList.get(decimalList.size()-1));
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }
                    if(actionEvent.getActionCommand() == "C ") {
                        equals = false;
                        decimalList.clear();
                        output.setText("0");
                        label_3.setVisible(false);
                        label_3.setText("");
                    }

                    if(actionEvent.getActionCommand() == "CE") {
                        equals = false;
                        if(decimalList.size()>0) {
                            decimalList.set((decimalList.size()-1),"0");
                        }
                        else {
                            decimalList.clear();
                            decimalList.add(0,"0");
                        }
                        output.setText("0");
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);

                    }

                    if(actionEvent.getActionCommand() == "=") {
                        equals = true;
                        label_3.setVisible(false);
                        label_3.setText("");
                        output.setText(String.valueOf(decimalTotal(decimalList)));
                        decimalList.clear();
                        decimalList.add(0, "0");
                        decimalList.add(1, output.getText());

                    }
                    //labels
                    label_Decimal.setText(output.getText());
                    label_Binary.setText(decimalToBinary(output.getText()));
                    label_Hexadecimal.setText(decimalToHex(output.getText()));
                    label_Octal.setText(decimalToOct(output.getText()));


                }


//******************************************************************************************************************************************************************************
                //for octal
                else if (rdbtnOct.isSelected()) {
                    octGroup.clearSelection();
                    btnA.setEnabled(false);
                    btnB.setEnabled(false);
                    btnC.setEnabled(false);
                    btnD.setEnabled(false);
                    btnE.setEnabled(false);
                    btnF.setEnabled(false);
                    button_13.setEnabled(false);
                    button_9.setEnabled(false);

                    button_5.setEnabled(true);
                    button_12.setEnabled(true);
                    button_8.setEnabled(true);
                    button_4.setEnabled(true);
                    button_11.setEnabled(true);
                    button_7.setEnabled(true);

                    output.setText(label_Octal.getText());

                    for(int i=1; i<decimalList.size(); i++) {
                        if(decimalList.get(i)== "0" && decimalList.get(i-1)=="0") {
                            decimalList.remove(i-1);
                        }
                    }

                    if(wasHex == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {
                                decimalList.set(i, HexToOctal(decimalList.get(i)));
                            }
                        }
                        wasHex = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    if(wasDec == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {
                                decimalList.set(i, decimalToOct(decimalList.get(i)));
                            }
                        }
                        wasDec = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }
                    if(wasBin == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {
                                decimalList.set(i, BinaryToOct(decimalList.get(i)));
                            }
                        }
                        wasBin = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }
                    wasOct = true;

                    if((actionEvent.getActionCommand() != "=") && (actionEvent.getActionCommand() != "C ") && (actionEvent.getActionCommand() != "CE") &&
                            actionEvent.getActionCommand() != "DEC" && actionEvent.getActionCommand() != "OCT" && actionEvent.getActionCommand() != "HEX" && actionEvent.getActionCommand() != "BIN" && actionEvent.getActionCommand() != "\u232B") {

                        if((actionEvent.getActionCommand() !="+")&& (actionEvent.getActionCommand()!="\u00D7") && (actionEvent.getActionCommand() !="\u2212") &&(actionEvent.getActionCommand() !="\u00F7") && decimalList.size()>0
                                && decimalList.get(decimalList.size()-1) != "+" && decimalList.get(decimalList.size()-1) != "\u2212" &&
                                decimalList.get(decimalList.size()-1) != "\u00D7" && decimalList.get(decimalList.size()-1) != "\u00F7" &&(actionEvent.getActionCommand() !="Mod")
                                && decimalList.get(decimalList.size()-1) != "Mod" && (decimalList.get(decimalList.size()-1)).length() < 6 && !equals){

                            //combines strings into one number
                            decimalList.add(decimalList.size()-1, decimalList.get(decimalList.size()-1) + actionEvent.getActionCommand());
                            decimalList.remove(decimalList.size()-1);


                            String miniOut = "";
                            for(int i=1; i< decimalList.size();i++) {
                                miniOut+= decimalList.get(i);
                            }
                            label_3.setText(miniOut);

                            output.setText(actionEvent.getActionCommand());

                        }

                        else if((decimalList.size()!=0) &&(decimalList.get(decimalList.size()-1) == "+" || decimalList.get(decimalList.size()-1) == "\u00D7" || decimalList.get(decimalList.size()-1) == "\u2212" || decimalList.get(decimalList.size()-1) == "\u00F7" ||
                                decimalList.get(decimalList.size()-1) == "Mod") && (actionEvent.getActionCommand() == "+" || actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" || actionEvent.getActionCommand() == "\u00F7" ||
                                actionEvent.getActionCommand() == "Mod")) {
                            decimalList.set((decimalList.size()-1), actionEvent.getActionCommand());

                        }

                        else if (decimalList.size()==0) {//adds a to front
                            equals = false;
                            decimalList.add("0");
                            output.setText(actionEvent.getActionCommand());
                            decimalList.add(actionEvent.getActionCommand());
                        }
                        else if ((decimalList.get(decimalList.size()-1)).length() == 6){
                            equals = false;
                            if(actionEvent.getActionCommand() == "+" ||actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" ||actionEvent.getActionCommand() == "\u00F7" ||
                                    actionEvent.getActionCommand() == "Mod") {
                                label_3.setVisible(true);

                                String miniOut = "";
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                                label_3.setText(miniOut);
                            }

                        }

                        else{//adds everything else

                            label_3.setVisible(true);
                            String miniOut = "";
                            if(actionEvent.getActionCommand() == "+" ||actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" ||actionEvent.getActionCommand() == "\u00F7" ||
                                    actionEvent.getActionCommand() == "Mod" && equals) {
                                equals = false;
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                            }
                            else if(equals) {
                                equals = false;
                                decimalList.clear();
                                decimalList.add("0");
                                decimalList.add(actionEvent.getActionCommand());

                            }
                            else {
                                equals = false;
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                            }

                            label_3.setText(miniOut);

                        }
                        //removes last input if the input was not a number
                        if(decimalList.get(decimalList.size()-1) == "+" ||decimalList.get(decimalList.size()-1) == "\u00D7" || decimalList.get(decimalList.size()-1) == "\u2212" || decimalList.get(decimalList.size()-1) == "\u00F7" ||
                                decimalList.get(decimalList.size()-1) == "Mod" ) {
                            equals = false;
                            output.setText(decimalList.get(decimalList.size()-2));
                            label_3.setVisible(true);
                            String miniOut = "";
                            for(int i=1; i< decimalList.size();i++) {
                                miniOut+= decimalList.get(i);
                            }
                            label_3.setText(miniOut);
                        }

                        else {
                            output.setText(decimalList.get(decimalList.size()-1));

                        }
                        label_3.setVisible(true);


                    }

                    if(actionEvent.getActionCommand() == "\u232B" && !decimalList.isEmpty()) {//backspace
                        equals = false;
                        if((decimalList.get(decimalList.size()-1)).length() ==1) {

                            decimalList.set(decimalList.size()-1,"0");
                        }
                        else{
                            String tempString;
                            tempString = decimalList.get(decimalList.size()-1);
                            tempString = tempString.substring(0, tempString.length()-1);
                            decimalList.set(decimalList.size()-1, tempString);
                        }
                        output.setText(decimalList.get(decimalList.size()-1));
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    if(actionEvent.getActionCommand() == "C ") {
                        equals = false;
                        decimalList.clear();
                        output.setText("0");
                        label_3.setVisible(false);
                        label_3.setText("");
                    }

                    if(actionEvent.getActionCommand() == "CE") {
                        equals = false;
                        if(decimalList.size()>0) {
                            decimalList.remove(decimalList.size()-1);
                        }
                        else {
                            decimalList.add(0,"0");
                        }
                        output.setText("0");
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    if(actionEvent.getActionCommand() == "=") {
                        equals = true;

                        label_3.setVisible(false);
                        label_3.setText("");
                        output.setText(String.valueOf(OctTotal(decimalList)));
                        decimalList.clear();
                        decimalList.add(0, "0");
                        decimalList.add(1, output.getText());



                    }

                    //labels
                    label_Decimal.setText(OctalToDecimal(output.getText()));
                    label_Binary.setText(OctalToBinary(output.getText()));
                    label_Hexadecimal.setText(OctalToHex(output.getText()));
                    label_Octal.setText(output.getText());




                }


//******************************************************************************************************************************************************************************************
                //for binary
                else if (rdbtnBin.isSelected()) {
                    binGroup.clearSelection();
                    btnA.setEnabled(false);
                    btnB.setEnabled(false);
                    btnC.setEnabled(false);
                    btnD.setEnabled(false);
                    btnE.setEnabled(false);
                    btnF.setEnabled(false);
                    button_13.setEnabled(false);
                    button_9.setEnabled(false);
                    button_5.setEnabled(false);
                    button_12.setEnabled(false);
                    button_8.setEnabled(false);
                    button_4.setEnabled(false);
                    button_11.setEnabled(false);
                    button_7.setEnabled(false);

                    output.setText(label_Binary.getText());
                    for(int i=1; i<decimalList.size(); i++) {
                        if(decimalList.get(i)== "0" && decimalList.get(i-1)=="0") {
                            decimalList.remove(i-1);
                        }
                    }

                    if(wasDec == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {

                                decimalList.set(i, decimalToBinary(decimalList.get(i)));
                            }

                        }
                        wasDec = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }
                    if(wasOct == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {
                                decimalList.set(i, OctalToBinary(decimalList.get(i)));
                            }
                        }
                        wasOct = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    if(wasHex == true) {
                        for(int i=1; i<decimalList.size(); i++) {
                            if(decimalList.get(i) != "+" && decimalList.get(i) != "\u00D7" && decimalList.get(i) != "\u2212" && decimalList.get(i) != "\u00F7" &&
                                    decimalList.get(i) != "Mod" ) {
                                decimalList.set(i, HexToBinary(decimalList.get(i)));
                            }
                        }
                        wasHex = false;
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    wasBin = true;
                    if((actionEvent.getActionCommand() != "=") && (actionEvent.getActionCommand() != "C ") && (actionEvent.getActionCommand() != "CE") &&
                            actionEvent.getActionCommand() != "DEC" && actionEvent.getActionCommand() != "OCT" && actionEvent.getActionCommand() != "HEX" && actionEvent.getActionCommand() != "BIN" && actionEvent.getActionCommand() != "\u232B") {

                        if((actionEvent.getActionCommand() !="+")&& (actionEvent.getActionCommand()!="\u00D7") && (actionEvent.getActionCommand() !="\u2212") &&(actionEvent.getActionCommand() !="\u00F7") && decimalList.size()>0
                                && decimalList.get(decimalList.size()-1) != "+" && decimalList.get(decimalList.size()-1) != "\u2212" &&
                                decimalList.get(decimalList.size()-1) != "\u00D7" && decimalList.get(decimalList.size()-1) != "\u00F7" &&(actionEvent.getActionCommand() !="Mod")
                                && decimalList.get(decimalList.size()-1) != "Mod" && (decimalList.get(decimalList.size()-1)).length() < 16 && !equals){

                            //combines strings into one number
                            decimalList.add(decimalList.size()-1, decimalList.get(decimalList.size()-1) + actionEvent.getActionCommand());
                            decimalList.remove(decimalList.size()-1);


                            String miniOut = "";
                            for(int i=1; i< decimalList.size();i++) {
                                miniOut+= decimalList.get(i);
                            }
                            label_3.setText(miniOut);

                            output.setText(actionEvent.getActionCommand());

                        }

                        else if((decimalList.size()!=0) &&(decimalList.get(decimalList.size()-1) == "+" || decimalList.get(decimalList.size()-1) == "\u00D7" || decimalList.get(decimalList.size()-1) == "\u2212" || decimalList.get(decimalList.size()-1) == "\u00F7" ||
                                decimalList.get(decimalList.size()-1) == "Mod") && (actionEvent.getActionCommand() == "+" || actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" || actionEvent.getActionCommand() == "\u00F7" ||
                                actionEvent.getActionCommand() == "Mod")) {
                            decimalList.set((decimalList.size()-1), actionEvent.getActionCommand());

                        }

                        else if (decimalList.size()==0) {//adds a to front
                            equals = false;
                            decimalList.add("0");
                            output.setText(actionEvent.getActionCommand());
                            decimalList.add(actionEvent.getActionCommand());
                        }

                        else if ((decimalList.get(decimalList.size()-1)).length() == 16){
                            equals = false;
                            if(actionEvent.getActionCommand() == "+" ||actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" ||actionEvent.getActionCommand() == "\u00F7" ||
                                    actionEvent.getActionCommand() == "Mod") {
                                label_3.setVisible(true);

                                String miniOut = "";
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                                label_3.setText(miniOut);
                            }

                        }
                        else{//adds everything else

                            label_3.setVisible(true);
                            String miniOut = "";
                            if(actionEvent.getActionCommand() == "+" ||actionEvent.getActionCommand() == "\u00D7" || actionEvent.getActionCommand() == "\u2212" ||actionEvent.getActionCommand() == "\u00F7" ||
                                    actionEvent.getActionCommand() == "Mod" && equals) {
                                equals = false;
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                            }
                            else if(equals) {
                                equals = false;
                                decimalList.clear();
                                decimalList.add("0");
                                decimalList.add(actionEvent.getActionCommand());

                            }
                            else {
                                equals = false;
                                decimalList.add(actionEvent.getActionCommand());
                                for(int i=1; i< decimalList.size();i++) {
                                    if(decimalList.get(i) != "0") {
                                        miniOut+= decimalList.get(i);
                                    }
                                }
                            }

                            label_3.setText(miniOut);

                        }

                        //removes last input if the input was not a number
                        if(decimalList.get(decimalList.size()-1) == "+" ||decimalList.get(decimalList.size()-1) == "\u00D7" || decimalList.get(decimalList.size()-1) == "\u2212" || decimalList.get(decimalList.size()-1) == "\u00F7" ||
                                decimalList.get(decimalList.size()-1) == "Mod" ) {
                            equals = false;
                            output.setText(decimalList.get(decimalList.size()-2));
                            label_3.setVisible(true);
                            String miniOut = "";
                            for(int i=1; i< decimalList.size();i++) {
                                miniOut+= decimalList.get(i);
                            }
                            label_3.setText(miniOut);
                        }

                        else {
                            output.setText(decimalList.get(decimalList.size()-1));

                        }
                        label_3.setVisible(true);


                    }

                    if(actionEvent.getActionCommand() == "\u232B" && !decimalList.isEmpty()) {//backspace
                        equals = false;
                        if((decimalList.get(decimalList.size()-1)).length() ==1) {

                            decimalList.set(decimalList.size()-1,"0");
                        }
                        else{
                            String tempString;
                            tempString = decimalList.get(decimalList.size()-1);
                            tempString = tempString.substring(0, tempString.length()-1);
                            decimalList.set(decimalList.size()-1, tempString);
                        }
                        output.setText(decimalList.get(decimalList.size()-1));
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    if(actionEvent.getActionCommand() == "C ") {
                        equals = false;
                        decimalList.clear();
                        output.setText("0");
                        label_3.setVisible(false);
                        label_3.setText("");
                    }

                    if(actionEvent.getActionCommand() == "CE") {
                        equals = false;
                        if(decimalList.size()>0) {
                            decimalList.set((decimalList.size()-1),"0");
                        }
                        else {
                            decimalList.clear();
                            decimalList.add(0,"0");
                        }
                        output.setText("0");
                        String miniOut = "";
                        for(int i=1; i< decimalList.size();i++) {
                            miniOut+= decimalList.get(i);
                        }
                        label_3.setText(miniOut);
                    }

                    if(actionEvent.getActionCommand() == "=") {
                        equals = true;
                        label_3.setVisible(false);
                        label_3.setText("");
                        output.setText(String.valueOf(BinTotal(decimalList)));
                        decimalList.clear();
                        decimalList.add(0, "0");
                        decimalList.add(1, output.getText());


                    }
                    //labels
                    label_Decimal.setText(BinaryToDecimal(output.getText()));
                    label_Binary.setText(output.getText());
                    label_Hexadecimal.setText(BinaryToHex(output.getText()));
                    label_Octal.setText(BinaryToOct(output.getText()));

                }




            }
        };
        contentPane.setLayout(null);

        JLabel label_27 = new JLabel("≡");
        label_27.setBounds(29, 10, 15, 30);
        label_27.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        contentPane.add(label_27);

        JLabel label_7 = new JLabel("");
        label_7.setBounds(5, 5, 0, 0);
        contentPane.add(label_7);

        JLabel lblProgrammer = new JLabel("Programmer");
        lblProgrammer.setBounds(68, 10, 123, 30);
        lblProgrammer.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        contentPane.add(lblProgrammer);

        JLabel label = new JLabel("");
        label.setBounds(5, 5, 0, 0);
        contentPane.add(label);

        JLabel label_1 = new JLabel("");
        label_1.setBounds(130, 10, 47, 95);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("");
        label_2.setBounds(182, 10, 51, 95);
        contentPane.add(label_2);

        //upper output label
        label_3.setEnabled(false);
        label_3.setBackground(SystemColor.menu);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("");
        label_4.setBounds(296, 10, 55, 95);
        contentPane.add(label_4);

        //hex toggle button
        rdbtnHex.setMinimumSize(new Dimension(50, 23));
        rdbtnHex.setMaximumSize(new Dimension(53, 23));
        rdbtnHex.setBackground(SystemColor.menu);
        rdbtnHex.setFont(new Font("Segoe UI", Font.BOLD, 9));
        contentPane.add(rdbtnHex);
        rdbtnHex.setBorderPainted(false);
        rdbtnHex.addActionListener(actionListener);
        label_Hexadecimal.setFont(new Font("Segoe UI", Font.BOLD, 11));
        contentPane.add(label_Hexadecimal);

        JLabel label_6 = new JLabel("");
        label_6.setBounds(130, 110, 47, 23);
        contentPane.add(label_6);

        JLabel label_8 = new JLabel("");
        label_8.setBounds(238, 110, 53, 23);
        contentPane.add(label_8);

        JLabel label_9 = new JLabel("");
        label_9.setBounds(296, 110, 55, 23);
        contentPane.add(label_9);

        //decimal toggle button
        rdbtnDec.setMaximumSize(new Dimension(50, 23));
        rdbtnDec.setMinimumSize(new Dimension(50, 23));
        rdbtnDec.setSelected(true);
        rdbtnDec.setBackground(SystemColor.menu);
        rdbtnDec.setFont(new Font("Segoe UI", Font.BOLD, 9));
        contentPane.add(rdbtnDec);
        rdbtnDec.setBorderPainted(false);
        rdbtnDec.addActionListener(actionListener);
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
        btnE.setEnabled(false);
        btnF.setEnabled(false);
        label_Decimal.setFont(new Font("Segoe UI", Font.BOLD, 11));
        contentPane.add(label_Decimal);

        JLabel label_11 = new JLabel("");
        label_11.setBounds(130, 138, 47, 23);
        contentPane.add(label_11);

        JLabel label_12 = new JLabel("");
        label_12.setBounds(182, 138, 51, 23);
        contentPane.add(label_12);

        JLabel label_13 = new JLabel("");
        label_13.setBounds(238, 138, 53, 23);
        label_13.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        contentPane.add(label_13);

        JLabel label_14 = new JLabel("");
        label_14.setBounds(238, 138, 113, 23);
        contentPane.add(label_14);


        //output label
        output.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        contentPane.add(output);

        //octal toggle button
        rdbtnOct.setMinimumSize(new Dimension(50, 23));
        rdbtnOct.setMaximumSize(new Dimension(50, 23));
        rdbtnOct.setBackground(SystemColor.menu);
        rdbtnOct.setFont(new Font("Segoe UI", Font.BOLD, 9));
        contentPane.add(rdbtnOct);
        rdbtnOct.setBorderPainted(false);
        rdbtnOct.addActionListener(actionListener);
        label_Octal.setFont(new Font("Segoe UI", Font.BOLD, 11));
        contentPane.add(label_Octal);

        JLabel label_16 = new JLabel("");
        label_16.setBounds(130, 166, 47, 23);
        contentPane.add(label_16);

        JLabel label_17 = new JLabel("");
        label_17.setBounds(182, 166, 51, 23);
        contentPane.add(label_17);

        JLabel label_18 = new JLabel("");
        label_18.setBounds(238, 166, 53, 23);
        contentPane.add(label_18);

        JLabel label_19 = new JLabel("");
        label_19.setBounds(296, 166, 55, 23);
        contentPane.add(label_19);

        //binary toggle button
        rdbtnBin.setPreferredSize(new Dimension(53, 23));
        rdbtnBin.setMinimumSize(new Dimension(50, 23));
        rdbtnBin.setMaximumSize(new Dimension(50, 23));
        rdbtnBin.setBackground(SystemColor.menu);
        rdbtnBin.setFont(new Font("Segoe UI", Font.BOLD, 9));
        contentPane.add(rdbtnBin);
        rdbtnBin.setBorderPainted(false);
        rdbtnBin.addActionListener(actionListener);
        label_Binary.setFont(new Font("Segoe UI", Font.BOLD, 11));
        contentPane.add(label_Binary);

        JLabel label_21 = new JLabel("");
        label_21.setBounds(130, 194, 47, 23);
        contentPane.add(label_21);

        JLabel label_22 = new JLabel("");
        label_22.setBounds(182, 194, 51, 23);
        contentPane.add(label_22);

        JLabel label_23 = new JLabel("");
        label_23.setBounds(238, 194, 53, 23);
        contentPane.add(label_23);

        JLabel label_24 = new JLabel("");
        label_24.setBounds(296, 194, 55, 23);
        contentPane.add(label_24);

        JButton btnu_2 = new JButton("\u2E2C");
        btnu_2.setBounds(10, 222, 53, 33);
        btnu_2.setBorderPainted(false);
        btnu_2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
        btnu_2.setBackground(SystemColor.menu);
        contentPane.add(btnu_2);


        JButton btnudd = new JButton("\u2E2A");
        btnudd.setBounds(68, 222, 57, 33);
        btnudd.setBorderPainted(false);
        btnudd.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 18));
        btnudd.setBackground(SystemColor.menu);
        contentPane.add(btnudd);

        JButton wordButton_1 = new JButton("WORD");
        wordButton_1.setBounds(130, 222, 103, 33);
        wordButton_1.setBorderPainted(false);
        wordButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        wordButton_1.setBackground(SystemColor.menu);
        contentPane.add(wordButton_1);


        JLabel label_25 = new JLabel("");
        label_25.setBounds(130, 222, 47, 33);
        contentPane.add(label_25);

        JLabel label_26 = new JLabel("");
        label_26.setBounds(182, 222, 51, 33);
        contentPane.add(label_26);

        //d button
        btnD.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnD.setBackground(SystemColor.text);
        btnD.addActionListener(actionListener);

        JButton btnMs = new JButton("MS");
        btnMs.setBounds(238, 222, 53, 33);
        btnMs.setBorderPainted(false);
        btnMs.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnMs.setBackground(SystemColor.menu);
        contentPane.add(btnMs);



        JButton btnM = new JButton("M");
        btnM.setBounds(296, 222, 55, 33);
        btnM.setBorderPainted(false);
        btnM.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnM.setBackground(SystemColor.menu);
        contentPane.add(btnM);


        JButton btnLsh = new JButton("Lsh");
        btnLsh.setBounds(10, 260, 53, 30);
        btnLsh.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnLsh.setBackground(SystemColor.menu);
        contentPane.add(btnLsh);

        JButton btnC_1 = new JButton("C ");
        btnC_1.setBounds(182, 295, 51, 35);
        btnC_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnC_1.setBackground(SystemColor.menu);
        btnC_1.addActionListener(actionListener);

        JButton btnCe = new JButton("CE");
        btnCe.setBounds(130, 295, 47, 35);
        btnCe.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnCe.setBackground(SystemColor.menu);
        btnCe.addActionListener(actionListener);


        JButton btnRsh = new JButton("Rsh");
        btnRsh.setBounds(68, 260, 57, 30);
        btnRsh.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnRsh.setBackground(SystemColor.menu);
        contentPane.add(btnRsh);


        JButton btnOr = new JButton("Or");
        btnOr.setBounds(130, 260, 47, 30);
        btnOr.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnOr.setBackground(SystemColor.menu);
        contentPane.add(btnOr);


        JButton btnXor = new JButton("Xor");
        btnXor.setBounds(182, 260, 51, 30);
        btnXor.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnXor.setBackground(SystemColor.menu);
        contentPane.add(btnXor);


        JButton btnNot = new JButton("Not");
        btnNot.setBounds(238, 260, 53, 30);
        btnNot.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnNot.setBackground(SystemColor.menu);
        contentPane.add(btnNot);


        JButton btnMod = new JButton("Mod");
        btnMod.setBounds(68, 295, 57, 35);
        btnMod.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        btnMod.setBackground(SystemColor.menu);
        btnMod.addActionListener(actionListener);


        JButton btnAnd = new JButton("And");
        btnAnd.setBounds(296, 260, 55, 30);
        btnAnd.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnAnd.setBackground(SystemColor.menu);
        contentPane.add(btnAnd);


        JButton btnu = new JButton(" \u2191 ");
        btnu.setBounds(10, 295, 53, 35);
        btnu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnu.setForeground(new Color(0, 0, 0));
        btnu.setBackground(SystemColor.menu);
        contentPane.add(btnu);
        contentPane.add(btnMod);
        contentPane.add(btnCe);
        contentPane.add(btnC_1);

        JButton btnuf = new JButton("\u00F7");
        btnuf.setBounds(296, 295, 55, 35);
        btnuf.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnuf.setBackground(SystemColor.menu);
        btnuf.addActionListener(actionListener);

        JButton button_14 = new JButton("\u232B");
        button_14.setBounds(238, 295, 53, 35);
        button_14.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 10));
        button_14.setBackground(SystemColor.menu);
        button_14.addActionListener(actionListener);
        contentPane.add(button_14);
        contentPane.add(btnuf);

        JButton btnud = new JButton("\u00D7");
        btnud.setBounds(296, 335, 55, 35);
        btnud.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnud.setBackground(SystemColor.menu);
        btnud.addActionListener(actionListener);

        //8 button
        button_9.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button_9.setBackground(SystemColor.text);
        button_9.addActionListener(actionListener);

        //button 7
        button_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button_5.setBackground(SystemColor.text);
        button_5.addActionListener(actionListener);

        //b button
        btnB.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnB.setBackground(SystemColor.text);
        btnB.addActionListener(actionListener);

        //a Button
        btnA.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnA.setBackground(SystemColor.text);
        btnA.addActionListener(actionListener);
        contentPane.add(btnA);
        contentPane.add(btnB);
        contentPane.add(button_5);
        contentPane.add(button_9);

        //9 button
        button_13.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button_13.setBackground(SystemColor.text);
        button_13.addActionListener(actionListener);
        contentPane.add(button_13);
        contentPane.add(btnud);

        //c button
        btnC.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnC.setBackground(SystemColor.text);
        btnC.addActionListener(actionListener);
        contentPane.add(btnC);
        contentPane.add(btnD);

        //button 5
        button_8.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button_8.setBackground(SystemColor.text);
        button_8.addActionListener(actionListener);

        //button 4
        button_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button_4.setBackground(SystemColor.text);
        button_4.addActionListener(actionListener);
        contentPane.add(button_4);
        contentPane.add(button_8);

        //button 2
        button_7.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button_7.setBackground(SystemColor.text);
        button_7.addActionListener(actionListener);


        //e button
        btnE.setForeground(new Color(0, 0, 0));
        btnE.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnE.setBackground(SystemColor.text);
        btnE.addActionListener(actionListener);

        //button 6
        button_12.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button_12.setBackground(SystemColor.text);
        button_12.addActionListener(actionListener);
        contentPane.add(button_12);

        JButton btnu_1 = new JButton("\u2212");
        btnu_1.setBounds(296, 375, 55, 35);
        btnu_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnu_1.setBackground(SystemColor.menu);
        btnu_1.addActionListener(actionListener);
        contentPane.add(btnu_1);
        contentPane.add(btnE);

        //f button
        btnF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnF.setBackground(SystemColor.text);
        btnF.addActionListener(actionListener);
        contentPane.add(btnF);

        // 1 button
        button_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button_3.setBackground(SystemColor.text);
        button_3.addActionListener(actionListener);
        contentPane.add(button_3);
        contentPane.add(button_7);


        //button 3
        button_11.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button_11.setBackground(SystemColor.text);
        button_11.addActionListener(actionListener);
        contentPane.add(button_11);

        JButton button_16 = new JButton("+");
        button_16.setBounds(296, 415, 55, 35);
        button_16.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        button_16.setBackground(SystemColor.menu);
        button_16.addActionListener(actionListener);
        contentPane.add(button_16);

        JButton button = new JButton("(");
        button.setBounds(10, 455, 53, 36);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        button.setBackground(SystemColor.menu);
        contentPane.add(button);


        JButton button_1 = new JButton(")");
        button_1.setBounds(68, 455, 57, 36);
        button_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        button_1.setBackground(SystemColor.menu);
        contentPane.add(button_1);


        JButton button_6 = new JButton("0");
        button_6.setBounds(182, 455, 51, 36);
        button_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button_6.setBackground(SystemColor.text);
        button_6.addActionListener(actionListener);


        JButton button_2 = new JButton("\u00B1");
        button_2.setBounds(130, 455, 47, 36);
        button_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        button_2.setBackground(SystemColor.menu);
        contentPane.add(button_2);
        contentPane.add(button_6);

        JButton button_10 = new JButton(".");
        button_10.setBounds(238, 455, 53, 36);
        button_10.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        button_10.setBackground(SystemColor.menu);
        button_10.addActionListener(actionListener);
        contentPane.add(button_10);
        button_10.setEnabled(false);

        JButton button_15 = new JButton("=");
        button_15.setBounds(296, 455, 55, 36);
        button_15.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        button_15.setBackground(SystemColor.menu);
        button_15.addActionListener(actionListener);
        contentPane.add(button_15);




        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                synchronized (CalcMain.class) {
                    switch (ke.getID()) {
                        case KeyEvent.KEY_PRESSED:
                            if (ke.getKeyCode() == KeyEvent.VK_0 || ke.getKeyCode() == KeyEvent.VK_NUMPAD0) {
                                button_6.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_1 || ke.getKeyCode() == KeyEvent.VK_NUMPAD1) {
                                button_3.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_2 || ke.getKeyCode() == KeyEvent.VK_NUMPAD2) {
                                button_7.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_3 || ke.getKeyCode() == KeyEvent.VK_NUMPAD3) {
                                button_11.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_4 || ke.getKeyCode() == KeyEvent.VK_NUMPAD4) {
                                button_4.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_5 || ke.getKeyCode() == KeyEvent.VK_NUMPAD5) {
                                button_8.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_6 || ke.getKeyCode() == KeyEvent.VK_NUMPAD6) {
                                button_12.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_7 || ke.getKeyCode() == KeyEvent.VK_NUMPAD7) {
                                button_5.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_8 || ke.getKeyCode() == KeyEvent.VK_NUMPAD8) {
                                button_9.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_9 || ke.getKeyCode() == KeyEvent.VK_NUMPAD9) {
                                button_13.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_A) {
                                btnA.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_B) {
                                btnB.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_C) {
                                btnC.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_D) {
                                btnD.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_E) {
                                btnE.doClick();
                            }
                            if (ke.getKeyCode() == KeyEvent.VK_F) {
                                btnF.doClick();
                            }

                            if (ke.getKeyCode() == KeyEvent.VK_MULTIPLY  ||((ke.getKeyCode() == KeyEvent.VK_SEPARATER))) {
                                btnud.doClick();
                            }

                            if (ke.getKeyCode() == KeyEvent.VK_DIVIDE ) {
                                btnuf.doClick();
                            }

                            if (ke.getKeyCode() == KeyEvent.VK_SUBTRACT ) {
                                btnu_1.doClick();
                            }

                            if (ke.getKeyCode() == KeyEvent.VK_PLUS ||  ke.getKeyCode() == 107) {
                                button_16.doClick();
                            }

                            if (ke.getKeyCode() == KeyEvent.VK_ENTER ||  ke.getKeyCode() == KeyEvent.VK_EQUALS) {
                                button_15.doClick();
                            }

                            if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE ) {
                                button_14.doClick();
                            }

                            break;

                        case KeyEvent.KEY_RELEASED:
                            break;
                    }
                    return false;
                }
            }
        });



    }


    String decimalTotal(ArrayList<String> list) {

        for(int i=1; i<list.size(); i++) {
            if(list.get(i)!= "Mod" && list.get(i) != "+" && list.get(i)!="\u00D7" && list.get(i) !="\u00F7" && list.get(i) !="\u2212" && list.get(i-1)== "0") {
                list.remove(i-1);
            }
        }

        if(list.get(list.size()-1)== "Mod" || list.get(list.size()-1)=="+" || list.get(list.size()-1)=="\u00D7" || list.get(list.size()-1)=="\u00F7" || list.get(list.size()-1)=="\u2212") {
            list.remove(list.size()-1);

        }

        for(int i=1; i<list.size(); i++) {//Modular

            if(list.get(i)=="Mod") {
                int sub = (Integer.parseInt((list.get(i-1))) % Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(sub));
                list.remove(i);
                list.remove(i-1);
                i-=1;
            }

        }


        for(int i=1; i<list.size(); i++) {


            if(list.get(i)=="\u00D7") {//multiplication

                int times = (Integer.parseInt((list.get(i-1))) * Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(times));
                list.remove(i);
                list.remove(i-1);
                i-=1;

            }


        }

        for(int i=1; i<list.size(); i++) {

            if(list.get(i)=="\u00F7") {//division

                int divide = (Integer.parseInt((list.get(i-1))) / Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(divide));
                list.remove(i);
                list.remove(i-1);
                i-=1;
            }

        }

        for(int i=1; i<list.size(); i++) {//addition

            if(list.get(i)=="+") {
                int add = (Integer.parseInt((list.get(i-1))) + Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(add));
                list.remove(i);
                list.remove(i-1);
                i-=1;
            }
        }

        for(int i=1; i<list.size(); i++) {//addition

            if(list.get(i)=="\u2212") {
                int sub = (Integer.parseInt((list.get(i-1))) - Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(sub));
                list.remove(i);
                list.remove(i-1);
                i-=1;

            }
        }

        return list.get(list.size()-1);
    }

    //*****************************************************************************************************
    String HexTotal(ArrayList<String> list) {


        for(int i=1; i<list.size(); i++) {
            if(list.get(i)!= "Mod" && list.get(i) != "+" && list.get(i)!="\u00D7" && list.get(i) !="\u00F7" && list.get(i) !="\u2212" && list.get(i-1)== "0") {
                list.remove(i-1);
            }
        }

        if(list.get(list.size()-1)== "Mod" || list.get(list.size()-1)=="+" || list.get(list.size()-1)=="\u00D7" || list.get(list.size()-1)=="\u00F7" || list.get(list.size()-1)=="\u2212") {
            list.remove(list.size()-1);

        }

        for(int i=0; i<list.size(); i++) {//converting hex to decimal
            Integer tempHex;

            if(list.get(i) != "Mod" && list.get(i)!="+" && list.get(i) !="\u00D7" && list.get(i) !="\u00F7" && list.get(i) !="\u2212") {
                tempHex = Integer.parseInt(list.get(i),16);
                list.set(i, tempHex.toString());
            }
        }

        for(int i=1; i<list.size(); i++) {//Modular

            if(list.get(i)=="Mod") {
                int sub = (Integer.parseInt((list.get(i-1))) % Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(sub));
                list.remove(i);
                list.remove(i-1);
                i-=1;
            }

        }


        for(int i=1; i<list.size(); i++) {


            if(list.get(i)=="\u00D7") {//multiplication

                int times = (Integer.parseInt((list.get(i-1))) * Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(times));
                list.remove(i);
                list.remove(i-1);
                i-=1;

            }


        }

        for(int i=1; i<list.size(); i++) {

            if(list.get(i)=="\u00F7") {//division

                int divide = (Integer.parseInt((list.get(i-1))) / Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(divide));
                list.remove(i);
                list.remove(i-1);
                i-=1;
            }

        }

        for(int i=1; i<list.size(); i++) {//addition

            if(list.get(i)=="+") {
                int add = (Integer.parseInt((list.get(i-1))) + Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(add));
                list.remove(i);
                list.remove(i-1);
                i-=1;
            }
        }

        for(int i=1; i<list.size(); i++) {//addition

            if(list.get(i)=="\u2212") {
                int sub = (Integer.parseInt((list.get(i-1))) - Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(sub));
                list.remove(i);
                list.remove(i-1);
                i-=1;

            }
        }

        Integer number = new Integer(list.get(list.size()-1));
        return  (Integer.toHexString(number)).toUpperCase();
    }

    //************************************************************************************************************************
    String OctTotal(ArrayList<String> list) {


        for(int i=1; i<list.size(); i++) {
            if(list.get(i)!= "Mod" && list.get(i) != "+" && list.get(i)!="\u00D7" && list.get(i) !="\u00F7" && list.get(i) !="\u2212" && list.get(i-1)== "0") {
                list.remove(i-1);
            }
        }

        if(list.get(list.size()-1)== "Mod" || list.get(list.size()-1)=="+" || list.get(list.size()-1)=="\u00D7" || list.get(list.size()-1)=="\u00F7" || list.get(list.size()-1)=="\u2212") {
            list.remove(list.size()-1);

        }

        for(int i=0; i<list.size(); i++) {//converting Octal to decimal
            Integer tempOct;

            if(list.get(i) != "Mod" && list.get(i)!="+" && list.get(i) !="\u00D7" && list.get(i) !="\u00F7" && list.get(i) !="\u2212") {
                tempOct = Integer.parseInt(list.get(i),8);
                list.set(i, tempOct.toString());
            }
        }

        for(int i=1; i<list.size(); i++) {//Modular

            if(list.get(i)=="Mod") {
                int sub = (Integer.parseInt((list.get(i-1))) % Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(sub));
                list.remove(i);
                list.remove(i-1);
                i-=1;
            }

        }


        for(int i=1; i<list.size(); i++) {


            if(list.get(i)=="\u00D7") {//multiplication

                int times = (Integer.parseInt((list.get(i-1))) * Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(times));
                list.remove(i);
                list.remove(i-1);
                i-=1;

            }


        }

        for(int i=1; i<list.size(); i++) {

            if(list.get(i)=="\u00F7") {//division

                int divide = (Integer.parseInt((list.get(i-1))) / Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(divide));
                list.remove(i);
                list.remove(i-1);
                i-=1;
            }

        }

        for(int i=1; i<list.size(); i++) {//addition

            if(list.get(i)=="+") {
                int add = (Integer.parseInt((list.get(i-1))) + Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(add));
                list.remove(i);
                list.remove(i-1);
                i-=1;
            }
        }

        for(int i=1; i<list.size(); i++) {//addition

            if(list.get(i)=="\u2212") {
                int sub = (Integer.parseInt((list.get(i-1))) - Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(sub));
                list.remove(i);
                list.remove(i-1);
                i-=1;

            }
        }

        Integer number = new Integer(list.get(list.size()-1));
        return  (Integer.toOctalString(number)).toUpperCase();
    }

    String BinTotal(ArrayList<String> list) {


        for(int i=1; i<list.size(); i++) {
            if(list.get(i)!= "Mod" && list.get(i) != "+" && list.get(i)!="\u00D7" && list.get(i) !="\u00F7" && list.get(i) !="\u2212" && list.get(i-1)== "0") {
                list.remove(i-1);
            }
        }

        if(list.get(list.size()-1)== "Mod" || list.get(list.size()-1)=="+" || list.get(list.size()-1)=="\u00D7" || list.get(list.size()-1)=="\u00F7" || list.get(list.size()-1)=="\u2212") {
            list.remove(list.size()-1);

        }

        for(int i=0; i<list.size(); i++) {//converting Binary to decimal
            Integer tempBin;

            if(list.get(i) != "Mod" && list.get(i)!="+" && list.get(i) !="\u00D7" && list.get(i) !="\u00F7" && list.get(i) !="\u2212") {
                tempBin = Integer.parseInt(list.get(i),2);
                list.set(i, tempBin.toString());
            }
        }

        for(int i=1; i<list.size(); i++) {//Modular

            if(list.get(i)=="Mod") {
                int sub = (Integer.parseInt((list.get(i-1))) % Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(sub));
                list.remove(i);
                list.remove(i-1);
                i-=1;
            }

        }


        for(int i=1; i<list.size(); i++) {


            if(list.get(i)=="\u00D7") {//multiplication

                int times = (Integer.parseInt((list.get(i-1))) * Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(times));
                list.remove(i);
                list.remove(i-1);
                i-=1;

            }


        }

        for(int i=1; i<list.size(); i++) {

            if(list.get(i)=="\u00F7") {//division

                int divide = (Integer.parseInt((list.get(i-1))) / Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(divide));
                list.remove(i);
                list.remove(i-1);

                i-=1;
            }

        }

        for(int i=1; i<list.size(); i++) {//addition

            if(list.get(i)=="+") {
                int add = (Integer.parseInt((list.get(i-1))) + Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(add));
                list.remove(i);
                list.remove(i-1);
                i-=1;
            }
        }

        for(int i=1; i<list.size(); i++) {//addition

            if(list.get(i)=="\u2212") {
                int sub = (Integer.parseInt((list.get(i-1))) - Integer.parseInt((list.get(i+1))));
                list.set(i+1,String.valueOf(sub));
                list.remove(i);
                list.remove(i-1);
                i-=1;

            }
        }

        Integer number = new Integer(list.get(list.size()-1));
        return  (Integer.toBinaryString(number)).toUpperCase();
    }



//***********************************************************************************************************************
    //converters

    String decimalToBinary(String num) {

        Integer number = new Integer(num);
        return Integer.toBinaryString(number);
    }

    String decimalToHex(String num) {
        String hex;
        Integer number = new Integer(num);
        hex = (Integer.toHexString(number));
        return hex.toUpperCase();
    }

    String decimalToOct(String num) {

        Integer number = new Integer(num);
        return Integer.toOctalString(number);
    }

    String HexToDecimal(String hexNum) {

        Integer number = Integer.parseInt(hexNum,16);

        return number.toString();
    }

    String HexToOctal(String num) {
        Integer number = Integer.parseInt(num,16);

        return Integer.toOctalString(number);
    }

    String HexToBinary(String num) {
        Integer number = Integer.parseInt(num,16);

        return Integer.toBinaryString(number);
    }

    String OctalToHex(String num) {
        String oct;
        Integer number = Integer.parseInt(num,8);
        oct= Integer.toHexString(number);
        return oct.toUpperCase();
    }

    String OctalToDecimal(String hexNum) {
        Integer number = Integer.parseInt(hexNum,8);

        return number.toString();
    }

    String OctalToBinary(String num) {
        Integer number = Integer.parseInt(num,8);

        return Integer.toBinaryString(number);
    }

    String BinaryToDecimal(String binNum) {
        Integer number = Integer.parseInt(binNum,2);

        return number.toString();
    }

    String BinaryToHex(String binNum) {
        String bin;
        Integer number = Integer.parseInt(binNum,2);
        bin = Integer.toHexString(number);
        return bin;
    }

    String BinaryToOct(String binNum) {
        Integer number = Integer.parseInt(binNum,2);
        return Integer.toOctalString(number);
    }





}


