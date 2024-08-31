public class GemList 
{
   private int size;
   private Node head;

   private class Node {
      private Gem gem;
      private Node next;
      
      public Node(Gem gem) {
         this.gem = gem;
      }
      
   }
   
   public GemList() {
      this.head = null;
   }
   
      
    public int size() {
    size = 0;
    Node current = head;
      while(current != null) {
         size++;
         current = current.next;
      }
      return size;
    }
    
    public void draw(double y) {
    int i = 0;
    Node current = head;
      while(current != null) {
         current.gem.draw(GemGame.indexToX(i), y);
         i++;
         current = current.next;
      }
    }
    
    public String toString() {
    String str = "";
      Node current = head;
      if(current == null) {
         return "<none>";
      }
      else {
         while(current != null) {
            if(current.next == null) { str+= current.gem.getType(); }
            else { str+= current.gem.getType() + " --> "; }
            current = current.next;
         }
      }
      return str;
    }
    
    public void insertBefore(Gem gem, int index) { 
    Node current = head;
    Node added = new Node(gem);
    int i = 0;
    if(index <= 0 || head == null) {
      added.next = head;
      head = added;
    }
    else if(index >= size) {
    current = head;
      while(current.next != null) {
         current = current.next;
      }
      current.next = added;
    }
    else {
    current = head;
      while(current != null && i < index - 1) {
         current = current.next;
         i++;
      } 
      added.next = current.next;
      current.next = added;
      }
    }
    
    public int score() {
    Node current = head;
    int score = 0;
      while(current != null) {
         int numGems = 1;
         int points = current.gem.getPoints();
         
         Node next = current.next;
         while(next != null && next.gem.getType() == current.gem.getType()) {
            numGems++;
            points += next.gem.getPoints();
            next = next.next;
         }
         score += numGems * points;
         current = next;

      }
      return score;
    }
    
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
 	   list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);
	}
 
}
