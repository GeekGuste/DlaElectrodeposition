package gui;

import gui.Closer;
import io.Particle;
import io.Population;
import io.Setting;
import io.gui.EnvironmentApplet;
import io.sarl.core.OpenEventSpace;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.awt.Graphics;
import java.awt.MenuContainer;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import javax.accessibility.Accessible;
import javax.swing.JFrame;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class EnvironmentUi extends JFrame implements ImageObserver, MenuContainer, Serializable, Accessible, WindowListener {
  private EnvironmentApplet applet;
  
  private Closer handler;
  
  public Population population;
  
  public EnvironmentUi(final Particle dimensions, final OpenEventSpace comspace, final Population population) {
    super(Setting.TITLE);
    Closer _closer = new Closer(this, comspace);
    this.handler = _closer;
    EnvironmentApplet _environmentApplet = new EnvironmentApplet(dimensions, population);
    this.applet = _environmentApplet;
    this.population = population;
    this.applet.init();
    this.add("Center", this.applet);
    this.setBounds(100, 100, this.applet.canvas.dimensions.coordX, (this.applet.canvas.dimensions.coordY + 30));
    this.pack();
    this.setVisible(true);
    this.addWindowListener(this);
  }
  
  public void windowOpened(final WindowEvent arg0) {
    this.setBounds(100, 100, this.applet.canvas.dimensions.coordX, (this.applet.canvas.dimensions.coordY + 30));
    this.setVisible(true);
  }
  
  public void windowClosed(final WindowEvent arg0) {
    System.exit(0);
  }
  
  public void windowClosing(final WindowEvent arg0) {
    System.exit(0);
  }
  
  public void windowDeactivated(final WindowEvent arg0) {
  }
  
  public void windowDeiconified(final WindowEvent arg0) {
    this.setBounds(100, 100, this.applet.canvas.dimensions.coordX, (this.applet.canvas.dimensions.coordY + 30));
    this.setVisible(true);
  }
  
  public void windowActivated(final WindowEvent arg0) {
  }
  
  public void windowIconified(final WindowEvent arg0) {
  }
  
  @Override
  public void paint(final Graphics g) {
    super.paint(g);
    this.applet.population = this.population;
    this.applet.repaint();
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    return result;
  }
  
  @SyntheticMember
  private static final long serialVersionUID = -9407991288L;
}
