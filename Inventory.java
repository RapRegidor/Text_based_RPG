import java.util.*;
public class Inventory
{
  private ArrayList<Object> equipped;
  private Object[][] bag;
  public Inventory(ArrayList<Object> equipped, Object[][] bag)
  {
    this.equipped = equipped;
    this.bag = bag;
  }
}