package io;

import io.DlaSimulation;
import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class DlaSimulationLauncher {
  public static void main(final String... args) {
    DlaSimulation dlaS = new DlaSimulation();
    dlaS.start();
  }
  
  @SyntheticMember
  public DlaSimulationLauncher() {
    super();
  }
}
