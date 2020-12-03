package io;

import io.ParticleBody;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class Population {
  private int age = 1;
  
  public ConcurrentHashMap<UUID, ParticleBody> particles;
  
  private int[][] worldMap;
  
  private ParticleBody dimensions;
  
  public Population(final ParticleBody dimensions) {
    this.dimensions = dimensions;
    this.worldMap = new int[this.dimensions.coordX][this.dimensions.coordY];
    final int x = (this.dimensions.coordX / 2);
    final int y = (this.dimensions.coordY / 2);
    this.worldMap[x][y] = this.age;
    this.age++;
  }
  
  @Pure
  public boolean hasDendriteNeighbour(final ParticleBody particle) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getNeighbours(ParticleBody) is undefined for the type ParticleBody");
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
