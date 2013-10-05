import java.util.*;
class Grafo{
  
  private Point[] g;
  int size;
  
  Grafo(Geometry x, int n){
    Point[] a = new Point[n];
    this.size = n;
    for(int i = 0; i < n; i++)
      a[i] = x.newpoint();
    g = a;
  }
  
  int size(){return size;}
  
  void printGraph(){
    for(int i = 0; i < size(); i++)
      g[i].printPoint();
  }
  
  boolean checkConectivity(double d){
    int cont = 0, i;
    Point a;
    Queue<Point> queue = new LinkedList<Point>();
    LinkedList<Point> list = new LinkedList<Point>();
    
    for(i = 0; i < size; i++)
      list.add(g[i]);
    
    queue.add(g[0]);
    
    while(queue.size() != 0 && list.size() != 0){
      a = queue.poll();
      for (i = 0; i < list.size(); i++){
        Point o = list.get(i);
        if(a.distance(o) <= d){
          queue.add(o);
          list.remove(o);
          cont++; i--;
        }
      }
    }
    
    if(cont == size) return true;
    return false;
    
  }
  
  double threshold(){
    int pos = 0, cont = 0;
    double resposta = 0;
    Point a;
    LinkedList<Point> list = new LinkedList<Point>();
    LinkedList<Double> edges = new LinkedList<Double>();
    
    for(int i = 0; i < size; i++)
      list.add(g[i]);
    
    while(pos != size){
      a = g[pos++];
      if( list.size() != 0) list.remove(a);
      for(int i = 0; i < list.size(); i++){
        Point b = list.get(i);
        double d = a.distance(b);
        edges.add(d);
        cont++;
      }
    }
    Collections.sort(edges);
    
    int esquerda = 0;
    int direita = cont-1;
    int meio = 0;
    
    while( esquerda < direita ){
      meio = (esquerda + direita)/2;
      resposta = edges.get(meio);
      if( checkConectivity(resposta) ) direita = meio;
      else esquerda = meio + 1;
    }
    
    if( !checkConectivity(resposta) ) resposta = edges.get(meio+1);
    
    return resposta;
  }
  
}