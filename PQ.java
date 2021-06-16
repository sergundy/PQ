package new_sem.lab_1;

import java.util.Arrays;

public class PQ<T extends Comparable<T>>
{
	private T[] Queue;
	private int length;

	@SuppressWarnings("unchecked")
	public PQ(T[] array, int SIZE)
	{
		Queue = (T[]) new Comparable[SIZE];
		length = 0;

		/*данный цикл позволяет добалять в очередь как отдельные элементы (через add()), так и элементы из заранее заданного массива, 
		если бы не было этого цикла, то массив изначально должен был бы быть пустым*/
		for (T each : array)
		{
			add(each);
		}

	}

	//добавление элемента
	public void add(T value)
	{
		if (this.length >= Queue.length - 1)
		{
			Queue = this.sizechanger();
		}
		System.out.println("Элемент " + value + " был добавлен в вашу очередь \n");
		length++;
		Queue[length] = value;
		PercolatesUp();
	}

	//удаление наибольшего элемента
	public T remove()
	{
		T result = maxval();

		swap(1, length);
		Queue[length] = null;
		length--;

		System.out.println("Наибольший элемент (" + result + ") был удалён из вашей очереди\n");

		PercolatesDown();

		return result;
	}

	//удаление элемента по значению
	public boolean delete(T value)
	{
		for (int i = 0; i < Queue.length; i++)
		{
			if (value.equals(Queue[i]))
			{
				System.out.println("Элемент " + value + " был удалён из вашей очереди \n");
				swap(i, length);
				Queue[length] = null;
				length--;
				PercolatesDown();
			}
        }
        return true;
	}

	//извлечение всех элементов из очереди
	public T RemovingAllFromQueue()
	{
		if (EmptyCheck()) return null;

		T result = maxval();

		swap(1, length);
		Queue[length] = null;
		length--;

		PercolatesDown();

		return result;
	}

	//проверка на пустоту
 	boolean EmptyCheck()
	{
		return length == 0;
	}

	//получение значения наибольшего элемента
	public T maxval()
	{
		if (EmptyCheck()) throw new IllegalStateException();
		return Queue[1];
	}

	//получение числа элементов в очереди
	public int length()
	{
		return length;
	}

	//расширение очереди в случае, если число элементов превышает изначально выбранное значение
	private T[] sizechanger()
	{
		return Arrays.copyOf(Queue, Queue.length + 10);
	}

	//просачивание элемента вверх
	private void PercolatesUp()
	{
		int index = length;
		
			while (hasParent(index) && (parent(index).compareTo(Queue[index]) < 0))
			{
				swap(index, parentIndex(index));
				index = parentIndex(index);
			}	

	}

	//просачивание элемента вниз
	private void PercolatesDown()
	{
		int index = 1;
			while (LElement(index))
			{
				
				int larger = LIndex(index);
				if (RElement(index) && Queue[LIndex(index)].compareTo(Queue[RIndex(index)]) < 0)
				{
					larger = RIndex(index);
				}
				if (Queue[index].compareTo(Queue[larger]) < 0)
				{
					swap(index, larger);
				}
				else break;

				index = larger;
			}				

	}

	//перестановка элементов 
	private void swap(int index1, int index2)
	{
		T temp = Queue[index1];
		Queue[index1] = Queue[index2];
		Queue[index2] = temp;
	}
	
	//Проверка на наличие родительского элемента
	private boolean hasParent(int i)
	{
		return i > 1;
	}

	//Получение индекса родительского элемента
	private int parentIndex(int i)
	{
		return i / 2;
	}

	//Получение значения родительского элемента
	private T parent(int i)
	{
		return Queue[parentIndex(i)];
	}

	//Получение индекса левого элемента
	private int LIndex(int i)
	{
		return i * 2;
	}

	//Получение индекса правого элемента
	private int RIndex(int i)
	{
		return i * 2 + 1;
	}

	//Проверка на наличие левого элемента
	private boolean LElement(int i)
	{
		return LIndex(i) <= length;
	}

	//Проверка на наличие правого элемента
	private boolean RElement(int i)
	{
		return RIndex(i) <= length;
	}
}