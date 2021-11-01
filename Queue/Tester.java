public class Tester
{
    public static void main()
    {
        QueueInterface<Character> q = new LinkedQueue<Character>();

        for (Character ch = 'A'; ch < 'F'; ++ch)
            q.insert(ch);

        while (!q.isEmpty())
            System.out.println(q.remove());

        // deliberate underflow
        try {
            System.out.println(q.remove());
        }
        catch (QueueUnderflowException underflow) {
            System.out.println("Exception: " + underflow.getMessage());
            System.err.println("Exception: " + underflow.getMessage());
            System.exit(1);
        }

        System.out.println("done");
    }
}
