public class Tester
{
    public static void main()
    {
        Queue q = new Queue();
        
        for (int x = 1; x < 6; ++x)
            q.insert(x);
            
        while (!q.isEmpty())
            System.out.println(q.remove());
            
        System.out.println("done");
    }
}
