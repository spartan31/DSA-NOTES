package interfaceandGenerics;

import java.util.Comparator;

public class carspeedcomparator implements Comparator<car> {

	@Override
	public int compare(car tcar, car ocar ){
		// TODO Auto-generated method stub
		return tcar.speed - ocar.speed;
		
	}

}
