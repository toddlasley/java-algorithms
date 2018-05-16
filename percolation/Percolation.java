import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    
    private int N;
    private boolean[][] PercolationObject;
    private WeightedQuickUnionUF UFObject;
    
    public Percolation(int n) {
        this.N = n;
        this.PercolationObject = new boolean[n][n];
        this.UFObject = new WeightedQuickUnionUF((n * n) + 1);
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if(this.isFull(row, col))
        {
            int x = row - 1;
            int y = col - 1;
            this.PercolationObject[x][y] = true;
            //TODO: handle UFObject
            
            //check site to the left of original site
            if(y - 1 > -1)
            {
                if(this.isFull(row, col - 1))
                {
                    this.PercolationObject[x][y - 1] = true;
                    //TODO: handle UFObject; connect to 'odd' character
                }
            }
            
            //check site to the right of original site
            if(y + 1 < this.N)
            {
                if(this.isFull(row, col + 1))
                {
                    this.PercolationObject[x][y + 1] = true;
                    //TODO: handle UFObject
                }           
            }
            
            //check site above the original site
            if(x - 1 > 0)
            {
                if(this.isFull(row - 1, col))
                {
                    this.PercolationObject[x - 1][y] = true;
                    //TODO: handle UFObject
                }
            }
            
            //check site below the original site
            if(x + 1 < this.N)
            {
                if(this.isFull(row + 1, col))
                {
                    this.PercolationObject[x + 1][y] = true;
                    //TODO: handle UFObject
                }
            }
        }
    }
    
    // is site (row, col) open?
    public boolean isOpen(int row, int col){
        return PercolationObject[row - 1][col - 1];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col){
        return !PercolationObject[row - 1][col - 1];
    }

    // number of open sites
    public int numberOfOpenSites(){
        return 0;
    }
    
    // does the system percolate?
    public boolean percolates(){
        return false;
    }
    
    private int getUFObjectIndex(int row, int column)
    {
        return ((row - 1) * this.N) + (column - 1);
    }

    // test client (optional)
    public static void main(String[] args){
    }
}