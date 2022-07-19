package interfaceandGenerics;
import java.util.Comparator;
public class carpowercomparator implements Comparator<car>{

	@Override
	public int compare(car o1, car o2) {
		// TODO Auto-generated method stub
		return o1.power - o2.power;
	} 

}
