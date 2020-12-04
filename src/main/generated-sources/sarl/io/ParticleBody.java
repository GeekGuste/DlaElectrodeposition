package io;

import io.Setting;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.awt.Color;
import java.util.Objects;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class ParticleBody {
  public int coordX = 0;
  
  public int coordY = 0;
  
  public UUID owner;
  
  public Color PARTICLE_COLOR = Setting.INITIAL_COLOR;
  
  public boolean mouvement = true;
  
  public ParticleBody(final int x, final int y, final UUID ow) {
    this.coordX = x;
    this.coordY = y;
    this.owner = ow;
  }
  
  public ParticleBody(final int x, final int y) {
    this.coordX = x;
    this.coordY = y;
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
    ParticleBody other = (ParticleBody) obj;
    if (other.coordX != this.coordX)
      return false;
    if (other.coordY != this.coordY)
      return false;
    if (!Objects.equals(this.owner, other.owner))
      return false;
    if (other.mouvement != this.mouvement)
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
    result = prime * result + Boolean.hashCode(this.mouvement);
    return result;
  }
}
