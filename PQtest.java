package new_sem.lab_1;

public class PQtest
{

	public static void main(String[] args) {

        System.out.println("--------------------------------------------------\n");

		Integer[] array = {17,35,29,44};

        PQ<Integer> PQ = new PQ<>(array,10);

        PQ.add(12);
        PQ.add(479);
        PQ.add(14);
        PQ.add(111);
        PQ.add(41);
        PQ.add(850);

        System.out.println("--------------------------------------------------\n");

        System.out.println("Наибольшее значение = " + PQ.maxval() + "\n");

        System.out.println("--------------------------------------------------\n");

        System.out.println("Число элементов в очереди = " + PQ.length() + "\n");

        System.out.println("--------------------------------------------------\n");

        PQ.remove();
        PQ.delete(41);

        System.out.println("--------------------------------------------------\n");

        System.out.println("Число элементов в очереди = " + PQ.length() + "\n");

        System.out.println("--------------------------------------------------\n");

        System.out.println("Извлечение элементов из очереди: \n");

        //Извлекаем элементы до тех пор, пока очередь не станет пустой
		while (!PQ.EmptyCheck())
            System.out.println(PQ.RemovingAllFromQueue() + "\n");

        System.out.println("--------------------------------------------------\n");
        
        System.out.println("Число элементов в очереди = " + PQ.length() + "\n");

        System.out.println("--------------------------------------------------\n");
	}
}
