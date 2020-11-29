package io;

import io.Particle;
import io.Setting;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class Population {
  private int age = 1;
  
  public ArrayList<Particle> particles;
  
  private int[][] worldMap;
  
  private Particle dimensions;
  
  public Population(final Particle dimensions) {
    this.dimensions = dimensions;
    ArrayList<Particle> _arrayList = new ArrayList<Particle>();
    this.particles = _arrayList;
    IntegerRange _upTo = new IntegerRange(1, Setting.NUMBER_OF_PARTICLES);
    for (final Integer i : _upTo) {
      {
        double _random = Math.random();
        final int coordX = ((int) (_random * dimensions.coordX));
        double _random_1 = Math.random();
        final int coordY = ((int) (_random_1 * dimensions.coordY));
        Particle _particle = new Particle(coordX, coordY);
        this.particles.add(_particle);
      }
    }
    this.worldMap = new int[this.dimensions.coordX][this.dimensions.coordY];
    final int x = (this.dimensions.coordX / 2);
    final int y = (this.dimensions.coordY / 2);
    this.worldMap[x][y] = this.age;
    this.age++;
  }
  
  @Pure
  public boolean hasDendriteNeighbour(final Particle particle) {
    int _get = this.worldMap[this.dimensions.coordX][this.dimensions.coordY];
    if ((_get == 0)) {
      Particle[] neighbours = particle.getNeighbours(this.dimensions);
      for (final Particle neighbour : neighbours) {
        int _get_1 = this.worldMap[neighbour.coordX][neighbour.coordY];
        if ((_get_1 > 0)) {
          this.worldMap[neighbour.coordX][neighbour.coordY] = this.age;
          this.age++;
          return true;
        }
      }
      return false;
    } else {
      return true;
    }
  }
  
  @Pure
  public int getAgeForPixel(final int x, final int y) {
    return this.worldMap[x][y];
  }
  
  @Override
  @Pure
  @SyntheticMember
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Population other = (Population) obj;
    if (other.age != this.age)
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Integer.hashCode(this.age);
    return result;
  }
}
