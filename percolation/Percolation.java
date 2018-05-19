import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    
    private int N;
    private boolean[] PercolationObject;
    private WeightedQuickUnionUF UFObject;
    
    public Percolation(int n) 
    {
        if(n <= 0)
        {
            throw new java.lang.IllegalArgumentException();
        }
        this.N = n;
        this.PercolationObject = new boolean[n * n];
        this.UFObject = new WeightedQuickUnionUF((n * n) + 1);
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) 
    {
        if(row < 0 || col < 0 || row > this.N || col > this.N)
        {
            throw new java.lang.IllegalArgumentException();
        }
        
        if(this.isFull(row, col))
        {
            System.out.printf("Opening site at row: %d, column: %d\n", row, col);
            
            this.PercolationObject[this.getUFObjectIndex(row, col)] = true;
            
            boolean isTopRow = row == 1;
            //is this on the "top row"?            
            if(isTopRow)
            {
                //if so connect to "wildcard" site
                this.UFObject.union(this.getUFObjectIndex(row, col), 
                                    this.N * this.N);
            }
            
            //check site to the left of original site
            if(col - 1 > 0)
            {
                if(this.isOpen(row, col - 1))
                {
                    this.UFObject.union(this.getUFObjectIndex(row, col), 
                                        this.getUFObjectIndex(row, col - 1));
                }
            }
            
            //check site to the right of original site
            if(col + 1 <= this.N)
            {
                if(this.isOpen(row, col + 1))
                {
                    this.UFObject.union(this.getUFObjectIndex(row, col), 
                                        this.getUFObjectIndex(row, col + 1));
                }           
            }
            
            //check site above the original site
            if(row - 1 > 0)
            {
                if(this.isOpen(row - 1, col))
                {
                    this.UFObject.union(this.getUFObjectIndex(row, col), 
                                        this.getUFObjectIndex(row - 1, col));
                }
            }
            
            //check site below the original site
            if(row + 1 <= this.N)
            {
                if(this.isOpen(row + 1, col))
                {
                    this.UFObject.union(this.getUFObjectIndex(row, col), 
                                        this.getUFObjectIndex(row + 1, col));                  
                }
            }
        }
    }
    
    // is site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        if(row < 0 || col < 0 || row > this.N || col > this.N)
        {
            throw new java.lang.IllegalArgumentException();
        }
        
        return PercolationObject[this.getUFObjectIndex(row, col)];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col)
    {
        if(row < 0 || col < 0 || row > this.N || col > this.N)
        {
            throw new java.lang.IllegalArgumentException();
        }
        
        return !PercolationObject[this.getUFObjectIndex(row, col)];
    }

    // number of open sites
    public int numberOfOpenSites()
    {
        int openSites = 0;
        
        for(int i = 0; i < this.PercolationObject.length; i++)
        {
            if(this.PercolationObject[i])
            {
                openSites++;
            }
        }
        
        return openSites;
    }
    
    // does the system percolate?
    public boolean percolates()
    {
        boolean percolates = false;
        for(int i = this.getUFObjectIndex(this.N, 1); i < this.PercolationObject.length; i++)
        {
            if(this.UFObject.connected(i, this.N * this.N))
            {
                percolates = true;
                break;
            }
        }
        return percolates;
    }
    
    private int getUFObjectIndex(int row, int column)
    {
        return ((row - 1) * this.N) + (column - 1);
    }

    // test client (optional)
    public static void main(String[] args)
    {
        int n = StdIn.readInt();
        Percolation percolation = new Percolation(n);
        
        while(!percolation.percolates())
        {
            int row = StdRandom.uniform(1, n + 1);
            int column = StdRandom.uniform(1, n + 1);
            
            percolation.open(row, column);
        }
        
        StdOut.println("It percolates!\n");
    }
}