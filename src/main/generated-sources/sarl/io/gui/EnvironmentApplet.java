package io.gui;

import io.ParticleBody;
import io.Setting;
import io.gui.WorldCanvas;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.MenuContainer;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import javax.accessibility.Accessible;
import javax.swing.JApplet;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class EnvironmentApplet extends JApplet implements ImageObserver, MenuContainer, Serializable, Accessible {
  private Label title = new Label(Setting.TITLE);
  
  public WorldCanvas canvas;
  
  public ConcurrentHashMap group;
  
  public EnvironmentApplet(final ParticleBody dimensions, final ConcurrentHashMap group) {
    BorderLayout _borderLayout = new BorderLayout();
    this.setLayout(_borderLayout);
    this.add(this.title, BorderLayout.NORTH);
    this.group = group;
    WorldCanvas _worldCanvas = new WorldCanvas(dimensions, group);
    this.canvas = _worldCanvas;
    this.add(this.canvas, BorderLayout.CENTER);
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
  private static final long serialVersionUID = -2782309924L;
}
