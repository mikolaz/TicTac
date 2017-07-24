package com.TicTacToe.View;

import com.TicTacToe.Controller.TicToeController;
import com.TicTacToe.MainTicTacToe;

import javax.swing.*;

import java.awt.*;

/**
 * Created by Admin on 21.07.2017.
 */
public class ViewTicTacToe extends MainTicTacToe {
    //змінні
    JPanel windowContent;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;

    private JLabel name;
    JLabel information;

    JPanel gameField;


    public void setButton() {
    }


    public ViewTicTacToe() {
//головна панель
        windowContent = new JPanel();
//сортуємо по північ, центр і південь
        BorderLayout borderLayout = new BorderLayout();
        windowContent.setLayout(borderLayout);

//Створуємо кнопки

        button1 = new JButton("");
        button2 = new JButton("");
        button3 = new JButton("");
        button4 = new JButton("");
        button5 = new JButton("");
        button6 = new JButton("");
        button7 = new JButton("");
        button8 = new JButton("");
        button9 = new JButton("");

//Створуємо тектові поля
        information = new JLabel("Player vs Cpu");
        name = new JLabel("TicTacToe Game");

//Ставимо текстове поле на верх
        windowContent.add("North", name);
//ігрове поле
        gameField = new JPanel();
//Робимо кнопки в сітку 3х3
        GridLayout gridLayout = new GridLayout(3, 3);

        gameField.setLayout(gridLayout);
//Додаємо кнопки на ігрове поле
        gameField.add(button1);
        gameField.add(button2);
        gameField.add(button3);
        gameField.add(button4);
        gameField.add(button5);
        gameField.add(button6);
        gameField.add(button7);
        gameField.add(button8);
        gameField.add(button9);

//Робимо великий шрифт кнопок
        Font buttonFont = new Font("Time New Roman", Font.PLAIN, 60);
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);
        button5.setFont(buttonFont);
        button6.setFont(buttonFont);
        button7.setFont(buttonFont);
        button8.setFont(buttonFont);
        button9.setFont(buttonFont);
//Підключаємо ActionListener
        TicToeController toeController = new TicToeController(this);
        button1.addActionListener(toeController);
        button2.addActionListener(toeController);
        button3.addActionListener(toeController);
        button4.addActionListener(toeController);
        button5.addActionListener(toeController);
        button6.addActionListener(toeController);
        button7.addActionListener(toeController);
        button8.addActionListener(toeController);
        button9.addActionListener(toeController);


//Робимо ігрове поле по центрі
        windowContent.add("Center", gameField);

//Інформаційну строку ставимо в низ
        windowContent.add("South", information);

//створуємо фрейм
        JFrame frame = new JFrame("TicTacToe");
        frame.setContentPane(windowContent);

//розмір ігрового поля
        frame.pack();
        frame.setSize(300, 300);
//Робимо гру по цетру екрана
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);

        frame.setLocation(x, y);
//робимо фрейм видимим
        frame.setVisible(true);


    }

    public void test(){


    }

    private void reset() {
        button1.setEnabled(true);
        button1.setText("");
        button2.setEnabled(true);
        button2.setText("");
        button3.setEnabled(true);
        button3.setText("");
        button4.setEnabled(true);
        button4.setText("");
        button5.setEnabled(true);
        button5.setText("");
        button6.setEnabled(true);
        button6.setText("");
        button7.setEnabled(true);
        button7.setText("");
        button8.setEnabled(true);
        button8.setText("");
        button9.setEnabled(true);
        button9.setText("");



    }

    private boolean findDraw(){
        if (!button1.isEnabled()&&!button2.isEnabled()&&!button3.isEnabled()
                &&!button4.isEnabled()&&!button5.isEnabled()&&!button6.isEnabled()
                &&!button7.isEnabled()&&!button8.isEnabled()&&!button9.isEnabled()){

            return true;

        }
        else return false;
    }

    private boolean findThreeInARow() {
        if ((button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != "") ||
                (button4.getText() == button5.getText() && button5.getText() == button6.getText() && button4.getText() != "") ||
                (button7.getText() == button8.getText() && button8.getText() == button9.getText() && button7.getText() != "") ||
                (button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != "") ||
                (button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != "") ||
                (button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != "") ||
                (button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != "") ||
                (button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != "")
                ) return true;
        else return false;

    }

    public void checkForDraw() {
        String[] str = {"Ok"};

        if (findDraw()&&!findThreeInARow()) {


            JOptionPane.showOptionDialog(null, " It`s draw",
                    "Draw!", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, str, "Try again");

            reset();
        }
    }
    public void checkForWinner() {
        String[] str = {"Ok"};

        if (findThreeInARow()) {

            String winnerName = "Winner";
            JOptionPane.showOptionDialog(null, winnerName.concat(" won!!! Congratulations!!!"),
                    "Congratulations!", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, str, "OK");

            reset();
        }


    }

   // public void cpuTurn(){

    //    if (!button5.isEnabled()){button1.setText("O");button1.setEnabled(false);}
    //}



}
