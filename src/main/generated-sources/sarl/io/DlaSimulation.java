package io;

import com.google.common.base.Objects;
import gui.EnvironmentUi;
import io.GuiRepaint;
import io.Particle;
import io.ParticleAgent;
import io.Population;
import io.sarl.bootstrap.SRE;
import io.sarl.bootstrap.SREBootstrap;
import io.sarl.core.OpenEventSpace;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.AgentContext;
import io.sarl.lang.core.Event;
import io.sarl.lang.core.EventListener;
import io.sarl.lang.core.EventSpace;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class DlaSimulation implements EventListener {
  public static final UUID id = UUID.randomUUID();
  
  private SREBootstrap kernel;
  
  private AgentContext defaultSARLContext;
  
  private Population population;
  
  private ConcurrentHashMap<UUID, Particle> group;
  
  private OpenEventSpace space;
  
  private final Particle dimensions;
  
  private EnvironmentUi myGUI;
  
  public DlaSimulation() {
    final int scale = 2;
    final int width = (scale * 320);
    final int height = (scale * 234);
    Particle _particle = new Particle(width, height);
    this.dimensions = _particle;
    Population _population = new Population(this.dimensions);
    this.population = _population;
  }
  
  public void start() {
    try {
      this.kernel = SRE.getBootstrap();
      this.defaultSARLContext = this.kernel.startWithoutAgent();
      EventSpace _defaultSpace = this.defaultSARLContext.getDefaultSpace();
      this.space = ((OpenEventSpace) _defaultSpace);
      ConcurrentHashMap<UUID, Particle> _concurrentHashMap = new ConcurrentHashMap<UUID, Particle>();
      this.group = _concurrentHashMap;
      EnvironmentUi _environmentUi = new EnvironmentUi(this.dimensions, this.space, this.population);
      this.myGUI = _environmentUi;
      for (final Particle p : this.population.particles) {
        {
          final UUID uuid = UUID.randomUUID();
          this.kernel.startAgentWithID(ParticleAgent.class, uuid, p);
          p.owner = uuid;
          this.group.put(uuid, p);
        }
      }
      this.space.register(this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void receiveEvent(final Event event) {
    if ((event instanceof GuiRepaint)) {
      Particle particle = ((GuiRepaint)event).particle;
      for (final Particle p : this.population.particles) {
        boolean _equals = Objects.equal(p.owner, particle.owner);
        if (_equals) {
          p.coordX = particle.coordX;
          p.coordY = particle.coordY;
        }
      }
      this.myGUI.population = this.population;
      this.myGUI.repaint();
    }
  }
  
  @Pure
  public UUID getID() {
    return DlaSimulation.id;
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
}
