//Quick-union approach to union-find problem
//lazy approach
//creating a tree structure of objects that point to their parent which points to
//a parent which points to a parent... until hitting the root

public class QuickUnionUF
{
    private int[] id;
    
    public QuickUnionUF(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    
    //chase parent pointers until you reach the root
    private int root(int i)
    {
        while (i != id[i])
            i = id[i];
        return i;
    }
    
    //check whether p and q are in the same component
    //depth of p and q array accesses
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }
    
    //change root of p to change to root of q
    //depth of p and q array accesses
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        
        id[i] = j;
    }
}