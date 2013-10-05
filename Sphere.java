public class Sphere implements Geometry{
  private int dim;
  Sphere(int d){
    this.dim = d;
  }
  
  public int dimension(){return dim;}
  
  private static double randomGaussian(){
    double x, y;
    do{
      x = Math.random()*2 - 1;
      y = Math.random()*2 - 1;
    }while(x*x + y*y > 1);
    double s = x*x + y*y;
    return x*(Math.sqrt((-2)*(Math.log(s))/s));
  }
  
  public Point newpoint(){
    Point ponto = new Point(dim);
    int i;
    double random, denominador = 0;
    
    for(i = 0; i < dim; i++){
      random = randomGaussian();
      ponto.setCoord(i, random);
      denominador += random*random;
    }
    
    denominador = 2*(Math.sqrt(denominador));
    
    for(i = 0; i < dim; i++){
      ponto.setCoord(i, ponto.coordenate(i)/denominador);
    }
    
    return ponto;
    
  }
  
}