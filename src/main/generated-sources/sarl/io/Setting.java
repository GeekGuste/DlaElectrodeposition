package io;

import io.sarl.lang.annotation.SarlElementType;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.awt.Color;

@SarlSpecification("0.11")
@SarlElementType(10)
@SuppressWarnings("all")
public class Setting {
  public static final String TITLE = "Diffused Limited Aggregation(Electrodéposition)";
  
  public static final Color INITIAL_COLOR = Color.BLUE;
  
  public static final Color AMA_FIRST_COLOR = Color.RED;
  
  public static final Color AMA_SECOND_COLOR = Color.YELLOW;
  
  public static int THREAD_SLEEP_TIME = 50;
  
  public static int NUMBER_OF_PARTICLES = 30000;
  
  @SyntheticMember
  public Setting() {
    super();
  }
}
