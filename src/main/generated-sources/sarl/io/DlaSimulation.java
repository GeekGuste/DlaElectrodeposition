package io;

import gui.EnvironmentUi;
import io.GuiRepaint;
import io.ParticleAgent;
import io.ParticleBody;
import io.Population;
import io.Setting;
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
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class DlaSimulation implements EventListener {
  public static final UUID id = UUID.randomUUID();
  
  private SREBootstrap kernel;
  
  private AgentContext defaultSARLContext;
  
  private Population population;
  
  private ConcurrentHashMap<UUID, ParticleBody> group;
  
  private OpenEventSpace space;
  
  private final ParticleBody dimensions;
  
  private EnvironmentUi myGUI;
  
  public DlaSimulation() {
    final int scale = 2;
    final int width = (scale * 320);
    final int height = (scale * 234);
    ParticleBody _particleBody = new ParticleBody(width, height);
    this.dimensions = _particleBody;
    Population _population = new Population(this.dimensions);
    this.population = _population;
  }
  
  public void start() {
    try {
      this.kernel = SRE.getBootstrap();
      this.defaultSARLContext = this.kernel.startWithoutAgent();
      EventSpace _defaultSpace = this.defaultSARLContext.getDefaultSpace();
      this.space = ((OpenEventSpace) _defaultSpace);
      ConcurrentHashMap<UUID, ParticleBody> _concurrentHashMap = new ConcurrentHashMap<UUID, ParticleBody>();
      this.group = _concurrentHashMap;
      ParticleBody centre = new ParticleBody((this.dimensions.coordX / 2), (this.dimensions.coordY / 2));
      centre.mouvement = false;
      centre.PARTICLE_COLOR = Setting.AMA_FIRST_COLOR;
      this.group.put(UUID.randomUUID(), centre);
      IntegerRange _upTo = new IntegerRange(1, Setting.NUMBER_OF_PARTICLES);
      for (final Integer i : _upTo) {
        {
          double _random = Math.random();
          final int coordX = ((int) (_random * this.dimensions.coordX));
          double _random_1 = Math.random();
          final int coordY = ((int) (_random_1 * this.dimensions.coordY));
          final UUID uuid = UUID.randomUUID();
          ParticleBody p = new ParticleBody(coordX, coordY);
          this.kernel.startAgentWithID(ParticleAgent.class, uuid, p);
          p.owner = uuid;
          this.group.put(uuid, p);
          System.out.println(("Agent " + i));
        }
      }
      EnvironmentUi _environmentUi = new EnvironmentUi(this.dimensions, this.space, this.group);
      this.myGUI = _environmentUi;
      this.space.register(this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void receiveEvent(final Event event) {
    if ((event instanceof GuiRepaint)) {
      this.myGUI.group = this.group;
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
