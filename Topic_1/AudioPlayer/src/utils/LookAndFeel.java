/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;

/**
 *
 * @author Aldi Vaca
 */
public class LookAndFeel {

	public LookAndFeel() {
		setUIManagerDefaults();
	}

	public Color setBase() {
		return new Color(255, 128, 000); // combo
	}

	public Color setBlueGrey() {
		return new Color(255, 128, 000);// grid y txt
	}

	public Color setControl() {
		return new Color(255, 255, 255);// fondo
	}

	public Color setFocus() {
		return new Color(255, 128, 000);// borde foco
	}

	public Color setBorder() {
		return new Color(255, 128, 000);// borde tabla
	}

	private void setUIManagerDefaults() {
		javax.swing.UIManager.put("nimbusBase", setBase());
		javax.swing.UIManager.put("nimbusBlueGrey", setBlueGrey());
		javax.swing.UIManager.put("control", setControl());
		javax.swing.UIManager.put("nimbusFocus", setFocus());
		javax.swing.UIManager.put("nimbusBorder", setBorder());
		javax.swing.UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
	}

}
