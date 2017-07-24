package com.TicTacToe.Controller;

import com.TicTacToe.View.ViewTicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 21.07.2017.
 */
public class TicToeController  implements ActionListener  {
    ViewTicTacToe parent;

    public TicToeController(ViewTicTacToe parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        JButton clickedButton = (JButton) e.getSource();

        clickedButton.setText("X");

        clickedButton.setEnabled(false);

        parent.checkForWinner();
        parent.checkForDraw();



       // parent.cpuTurn();




    }


}
