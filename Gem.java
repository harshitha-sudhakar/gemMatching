import java.awt.Font;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}


public class Gem {	

   private GemType type;
   private int points;
   
   public Gem() {
   int random = (int)(Math.random() * 2);
   points = ((int)(Math.random() * 10) * 5);
      if(random == 0) {
         type = GemType.GREEN;      }
      if(random == 1) {
         type = GemType.BLUE; 
      }
      if(random == 2) {
         type = GemType.ORANGE; 
      }
   }
   
   public Gem(GemType type, int points) {
      this.type = type;
      this.points = points;
   }
   
   public String toString() {
      String str = "";
      return type.name() + " " + points; 
   }
   
   public GemType getType() {
      return type;
   }
   
   public int getPoints() {
      return points;
   }

   public void draw(double x, double y) {
      if(type == GemType.GREEN) {
         StdDraw.picture(x, y, "gem_green.png");
      }
      else if(type == GemType.BLUE) { 
         StdDraw.picture(x, y, "gem_blue.png");
         }
      else {
          StdDraw.picture(x, y, "gem_orange.png");
      }

      StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
      StdDraw.setPenColor(StdDraw.WHITE);
      StdDraw.text(x, y, ("" + points));
      
   }
   
	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
		
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
