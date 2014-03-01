package net.krakendev;

import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * An object that can be rendered with {@link JComponent}<code>'s</code> <code>paintComponent(Graphics g)</code> method.
**/
public interface SwingRenderable {
	/**
	 * <b>IMPORTANT: Must be called from a paintComponent method</b>.
	 * @param g The {@link Graphics} passed into the paintComponent method.
	 * @param x The x coordinate of where this object should be rendered.
	 * @param y The y coordinate of where this object should be rendered.
	 * @param canvas The object calling this method.
	**/
	public void render(Graphics g, int x, int y, JComponent canvas);
}