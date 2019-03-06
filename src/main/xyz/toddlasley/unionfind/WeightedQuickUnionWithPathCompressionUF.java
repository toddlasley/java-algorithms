//Weighted quick-union with path compression approach to union-find problem
//while computing the root of p, set the id of each examined node to point 
//to that root

package xyz.toddlasley.unionfind;

public class WeightedQuickUnionWithPathCompressionUF
{
    private int[] id;
    private int[] sz;
    
    public WeightedQuickUnionWithPathCompressionUF(int N)
    {
        id = new int[N];
        sz = new int[N];
        
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
            sz[i] = 1;
        }
    }
    
    //chase parent pointers until you reach the root
    private int root(int i)
    {
        while (i != id[i])
        {
            id[i] = id[id[i]]; //one line change
            i = id[i];
        }
        return i;
    }
    
    //check whether p and q are in the same component
    //depth of p and q array accesses
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }
    
    // if p is in the bigger tree, join that to the root of q (and vice versa)
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        
        if(i == j)
            return;
        
        if (sz[i] < sz[j])
        {
            id[i] = j;
            sz[j] += sz[i];
        }
        else
        {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}