public class Cube implements Geometry{
  private int dim;
  
  Cube(int d){
    this.dim = d;
  }
  
  public int dimension(){
    return dim;
  }
  
  public Point newpoint(){
    Point p = new Point(dim);
    double srt = Math.sqrt(dim);
    for(int i = 0; i < dim; i++){
      double r = Math.random()/srt;
      p.setCoord(i,r);
    }
    return p;
  }
  
}