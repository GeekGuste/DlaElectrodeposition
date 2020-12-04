package io.gui;

import io.ParticleBody;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JComponent;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class WorldCanvas extends JComponent {
  public ConcurrentHashMap<UUID, ParticleBody> group;
  
  public ParticleBody dimensions;
  
  public WorldCanvas(final ParticleBody dim, final ConcurrentHashMap group) {
    this.group = group;
    this.dimensions = dim;
    this.setSize(this.dimensions.coordX, this.dimensions.coordY);
  }
  
  public void paint(final Graphics g) {
    super.paintComponent(g);
    int width = this.dimensions.coordX;
    int height = this.dimensions.coordY;
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, width, height);
    Collection<ParticleBody> _values = this.group.values();
    for (final ParticleBody particle : _values) {
      {
        g.setColor(particle.PARTICLE_COLOR);
        g.drawLine(particle.coordX, particle.coordY, particle.coordX, particle.coordY);
      }
    }
  }
  
  public void update(final Graphics g) {
    this.paint(g);
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
  private static final long serialVersionUID = -326004394L;
}
