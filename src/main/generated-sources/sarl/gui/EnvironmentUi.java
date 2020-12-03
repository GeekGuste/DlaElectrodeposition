package gui;

import io.ParticleBody;
import io.Setting;
import io.gui.EnvironmentApplet;
import io.sarl.core.OpenEventSpace;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import javax.accessibility.Accessible;
import javax.swing.JFrame;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class EnvironmentUi extends JFrame implements Serializable, Accessible {
  private EnvironmentApplet applet;
  
  public ConcurrentHashMap group;
  
  public EnvironmentUi(final ParticleBody dimensions, final OpenEventSpace comspace, final ConcurrentHashMap group) {
    super(Setting.TITLE);
    EnvironmentApplet _environmentApplet = new EnvironmentApplet(dimensions, group);
    this.applet = _environmentApplet;
    this.group = group;
    this.applet.init();
    this.add("Center", this.applet);
    this.setBounds(100, 100, this.applet.canvas.dimensions.coordX, (this.applet.canvas.dimensions.coordY + 30));
    this.setVisible(true);
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
  private static final long serialVersionUID = -1683935718L;
}
