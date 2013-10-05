public class Point{
  private int dim;
  private double[] coord;
  
  Point(int d){
    this.dim = d;
    double[] p = new double[d];
    this.coord = p;
  }
  
  int pointDimension(){
    return dim;
  }
  
  void setCoord(int index, double valeu){
    coord[index] = valeu;
  }
  
  double coordenate(int index){
    return this.coord[index];
  }
  
  double distance(Point b){
    double dist = 0;
    for(int i = 0; i < dim; i++)
      dist += (coordenate(i) - b.coordenate(i))*(coordenate(i) - b.coordenate(i));
    dist = Math.sqrt(dist);
    return dist;
  }
  
  void printPoint(){
   for(int i = 0; i < dim; i++)
     System.out.print(" "+coordenate(i));
   System.out.println("");
  }
}
  
  