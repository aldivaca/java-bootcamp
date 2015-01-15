/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import utils.LookAndFeel;

/**
 *
 * @author Aldi Vaca
 */
public class Main {

	public static void main(String[] args) {

		LookAndFeel l = new LookAndFeel();

		FrmAudioPlayer f = new FrmAudioPlayer();
		f.setVisible(true);
		f.setLocationRelativeTo(null);

	}

}
