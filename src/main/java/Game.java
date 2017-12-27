import org.apache.commons.math3.distribution.PoissonDistribution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public int nbCooperators;
    public int nbDefectors;
    private double fn; // baseline reproductive rate
    private PublicGood publicGood;
    public List<Integer> logStatCooperatorLuxe = new ArrayList<Integer>();
    public List<Integer> logStatDefectismeLuxe = new ArrayList<Integer>();
    public List<Double> logStatFrontNational = new ArrayList<Double>();
    private Random rand = new Random();

    public Game(){
        this.nbCooperators = 100;
        this.nbDefectors = 100;
        this.publicGood = new PublicGood(0, 2);
    }

    public void play()
    {
       fn = computeFn(1, 0.001, 5000);
        generateOffsprings();
    }

    public double computeFn(double fk, double r, int k)
    {
        return Math.max(0, fk + r*(1 - (nbCooperators+nbDefectors)/k));
    }

    public double getReproductiveRateCooperator(){
        return (1-publicGood.w + publicGood.w*publicGood.R*(nbCooperators/(nbCooperators+nbDefectors)))*fn;
    }

    public double getReproductiveRateDefector(){
        return (1 + publicGood.w*publicGood.R*(nbCooperators/(nbCooperators+nbDefectors)))*fn;
    }

    public void generateOffsprings()
    {
        int tmpC = 0, tmpD = 0;
        for(int i = 0; i < nbCooperators; i++){
            int nbChildren = new PoissonDistribution(Math.max(1, getReproductiveRateCooperator())).sample();
            for(int j = 0; j < nbChildren; j++){
                tmpC++;
                // if(mutate() == 0){
                //     tmpC++;
                // } else {
                //     tmpD++;
                // }
            }
        }
        for(int i = 0; i < nbDefectors; i++){
            int nbChildren = new PoissonDistribution(Math.max(1, getReproductiveRateDefector())).sample();
            for(int j = 0; j < nbChildren; j++){
                tmpD++;
                // if(mutate() == 0){
                //     tmpD++;
                // } else {
                //     tmpC++;
                // }
            }
        }
        nbCooperators = tmpC;
        nbDefectors = tmpD;
        this.logStatCooperatorLuxe.add(nbCooperators);
        this.logStatDefectismeLuxe.add(nbDefectors);
        this.logStatFrontNational.add(fn);

    }

    public int mutate(){
        return rand.nextInt(2);
    }
}
