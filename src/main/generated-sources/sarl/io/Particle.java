package io;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.Objects;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class Particle {
  public int coordX = 0;
  
  public int coordY = 0;
  
  public UUID owner;
  
  public Particle(final int x, final int y, final UUID ow) {
    this.coordX = x;
    this.coordY = y;
    this.owner = ow;
  }
  
  public Particle(final int x, final int y) {
    this.coordX = x;
    this.coordY = y;
  }
  
  @Pure
  public Particle[] getNeighbours(final Particle dim) {
    Particle[] neighbours = new Particle[9];
    int maxX = dim.coordX;
    int maxY = dim.coordY;
    Particle _particle = new Particle((((this.coordX + maxX) - 1) % maxX), (((this.coordY + maxY) - 1) % maxY));
    neighbours[0] = _particle;
    Particle _particle_1 = new Particle((((this.coordX + maxX) - 1) % maxX), this.coordY);
    neighbours[1] = _particle_1;
    Particle _particle_2 = new Particle((((this.coordX + maxX) - 1) % maxX), (((this.coordY + maxY) + 1) % maxY));
    neighbours[2] = _particle_2;
    Particle _particle_3 = new Particle(this.coordX, (((this.coordY + maxY) - 1) % maxY));
    neighbours[3] = _particle_3;
    Particle _particle_4 = new Particle(this.coordX, this.coordY);
    neighbours[4] = _particle_4;
    Particle _particle_5 = new Particle(this.coordX, (((this.coordY + maxY) + 1) % maxY));
    neighbours[5] = _particle_5;
    Particle _particle_6 = new Particle((((this.coordX + maxX) + 1) % maxX), (((this.coordY + maxY) - 1) % maxY));
    neighbours[6] = _particle_6;
    Particle _particle_7 = new Particle((((this.coordX + maxX) + 1) % maxX), this.coordY);
    neighbours[7] = _particle_7;
    Particle _particle_8 = new Particle((((this.coordX + maxX) + 1) % maxX), (((this.coordY + maxY) + 1) % maxY));
    neighbours[8] = _particle_8;
    return neighbours;
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
    Particle other = (Particle) obj;
    if (other.coordX != this.coordX)
      return false;
    if (other.coordY != this.coordY)
      return false;
    if (!Objects.equals(this.owner, other.owner))
      return false;
    return super.equals(obj);
  }
  
  @Override
  @Pure
  @SyntheticMember
  public int hashCode() {
    int result = super.hashCode();
    final int prime = 31;
    result = prime * result + Integer.hashCode(this.coordX);
    result = prime * result + Integer.hashCode(this.coordY);
    result = prime * result + Objects.hashCode(this.owner);
    return result;
  }
}
