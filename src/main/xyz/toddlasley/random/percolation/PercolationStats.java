package xyz.toddlasley.random.percolation;

import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats
{
    int N;
    int Trials;
    double[] Thresholds;   
   
    PercolationStats(int n, int trials)
    {
        if(n <= 0 || trials <= 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        
        this.N = n;
        this.Trials = trials;
        this.Thresholds = new double[trials];
    }
    
    public double mean()
    {
        return StdStats.mean(this.Thresholds);
    }
    
    public double stddev()
    {
        return StdStats.stddev(this.Thresholds);
    }
    
    public double confidenceLo()
    {
        return this.mean() - ((1.96 * this.stddev()) / Math.sqrt(this.Trials));
    }
    
    public double confidenceHi()
    {
        return this.mean() + ((1.96 * this.stddev()) / Math.sqrt(this.Trials));
    }
    
    public void getPercolationThresholds()
    {   
        for(int i = 0; i < this.Trials; i++)
        {
            Percolation p = new Percolation(this.N);
            
            while(!p.percolates())
            {
                int row = StdRandom.uniform(1, this.N + 1);
                int column = StdRandom.uniform(1, this.N + 1);
                
                p.open(row, column);
            }
            this.Thresholds[i] = (double)p.numberOfOpenSites() / (double)(this.N * this.N);
        }
    }
    
    public static void main(String[] args)
    {   
        int n = 8;
        int t = 1000;
        
        //n and trials respectively
        if(n <= 0 || t <= 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        
        PercolationStats pStats = new PercolationStats(n, t);
        
        pStats.getPercolationThresholds();
        
        System.out.printf("mean                       %f\n", pStats.mean());
        System.out.printf("stddev                     %f\n", pStats.stddev());
        System.out.printf("95 confidence interval    [%f, %f]\n", pStats.confidenceLo(), pStats.confidenceHi());
    }
}