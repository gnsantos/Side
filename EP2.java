import java.util.*;

class EP2{
  
  public static void main(String argv[]){
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter the dimension: ");
    int D = sc.nextInt();
    System.out.println("Enter the graph size: ");
    int N = sc.nextInt();
    
    System.out.println("Enter the topology: ");
    String t = sc.nextLine();
    
    Geometry x;
    
    if(t.equals("S"))
      x = new Sphere(D);
    else x = new Cube(D);
    
    Grafo g = new Grafo(x, N);
    
    System.out.println(g.threshold());
    
  }
}
       
      