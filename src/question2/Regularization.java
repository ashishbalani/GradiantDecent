package question2;

import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;
public class Regularization {
public int maxIteration=10;
public double alpha=0.001D;
public double[] theta= null;
public double[][] X= { {1, 3.8, 10}, {1, 3.5, 4}, {1,3.0,2}, {1,3.2,5}, {1,2.7,8},
{1,2.0,3}, {1,2.5,10}, {1,3.6,8}, {1,1.75,2},{1,3.5,9} };
public double[] Y= {98,82,61,77,85,52,87,92,33,95};
public Random random= new Random();
public double f(double[] t, double[][] p, int a){
//double fun_value=0.0D;
double result =0.0D;
result = (Math.pow(((t[0]*p[a][0]+t[1]*p[a][1]+t[2]*p[a][2])-
Y[a]),2.0)+t[0]*t[0]+t[1]*t[1]+t[2]*t[2])/20;
return result;
}
public void gradientDescent(){
double[] gradient=new double[10];
for(int i=0;i<maxIteration;i++){
for(int j=0;j<this.theta.length;j++){
gradient[i]+=this.theta[j]*this.X[i][j];
}
}
for(int i=0;i<maxIteration;i++){
for(int j=0;j<this.theta.length;j++){
this.theta[j]=this.theta[j]-
this.X[i][j]*(this.alpha*(2*(gradient[i]-Y[i])+ 2*this.theta[j]))/10;
}
}
}
public gd_test2(){
theta=new double[3];
for (int i=0;i<theta.length;i++){
theta[i]=(random.nextDouble())*10;
}
System.out.println(ArrayUtils.toString(theta));
}
public static void main(String[] args) {
// TODO Auto-generated method stub
gd_test2 gd=new gd_test2();
gd.gradientDescent();
System.out.println("Estimated value of theta :
"+ArrayUtils.toString(gd.theta));
double[][] N= { {1,3.5,11},{1,3.2,6},{1,3.2,3},{1,3.8,3},{1,2.9,7},{1,2.2,6},
{1,2.1,5},{1,3.1,10},{1,1.25,5},{1,2.35,9}};
double[] value=new double[10];
for(int i=0;i<10;i++){
for(int j=0;j<3;j++){
value[i]+=gd.theta[j]*N[i][j];
}
System.out.println(" Estimated Grade for new record "+(i+11)+": "+
value[i]);
}
}
}