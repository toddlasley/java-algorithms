//Quick-find approach to union-find problem
//eager approach
// p and q are connected iff they have the same id

package me.toddlasley.questions.random.unionfind;

public class QuickFindUF
{
    private int[] id;
    
    public QuickFindUF(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    
    //check whether p and q are in the same component
    //2 array accesses
    public boolean connected(int p, int q)
    {
        return id[p] == id[q];
    }
    
    //change all entries with id[p] to id[q]
    //at most 2N + 2 array accesses
    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        
        for (int i = 0; i < id.length; i++)
        {
            if(id[i] == pid)
                id[i] = qid;
        }
    }
}