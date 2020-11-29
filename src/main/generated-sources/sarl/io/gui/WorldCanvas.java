package io.gui;

import io.Particle;
import io.Population;
import io.Setting;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class WorldCanvas extends JComponent {
  public Population population;
  
  public Particle dimensions;
  
  private final Color PARTICLE_COLOR = Color.BLUE;
  
  public WorldCanvas(final Particle dim, final Population population) {
    this.population = population;
    this.dimensions = dim;
    this.setSize(this.dimensions.coordX, this.dimensions.coordY);
  }
  
  public void paint(final Graphics g) {
    super.paintComponent(g);
    int width = this.dimensions.coordX;
    int height = this.dimensions.coordY;
    g.setColor(Setting.INITIAL_COLOR);
    g.fillRect(0, 0, width, height);
    g.setColor(Setting.AMA_FIRST_COLOR);
    for (final Particle e : this.population.particles) {
      g.drawLine(e.coordX, e.coordY, e.coordX, e.coordY);
    }
    IntegerRange _upTo = new IntegerRange(1, this.dimensions.coordX);
    for (final Integer i : _upTo) {
      IntegerRange _upTo_1 = new IntegerRange(1, this.dimensions.coordY);
      for (final Integer j : _upTo_1) {
        {
          final int age = this.population.getAgeForPixel(((i) == null ? 0 : (i).intValue()), ((j) == null ? 0 : (j).intValue()));
          if ((age > 0)) {
            if ((age < 200)) {
              g.setColor(Setting.AMA_FIRST_COLOR);
            } else {
              g.setColor(Setting.AMA_SECOND_COLOR);
            }
            g.drawLine(((i) == null ? 0 : (i).intValue()), ((j) == null ? 0 : (j).intValue()), ((i) == null ? 0 : (i).intValue()), ((j) == null ? 0 : (j).intValue()));
          }
        }
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
  private static final long serialVersionUID = -6038017487L;
}
