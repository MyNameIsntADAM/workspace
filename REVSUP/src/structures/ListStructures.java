package structures;

import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Adam H.
 */
public class ListStructures {
	
	static <T> void show(GeneralList<T> list, boolean dir) {
		Iterator<T> itr = list.iterator(dir);
		int k = 0;
		while(itr.hasNext()) {
			System.out.printf("%4d %s\n", ++k, itr.next());
		}
	}
	
	public static void main(String[] args) {
       
    	GeneralList<Integer> gl = new GeneralList<Integer>();
		GeneralList<Member> ml = new GeneralList<Member>();

		for(int i = 0; i < 10; i++) {
            ml.insert(new Member(), i);
        }
	
		Random rnd = new Random();
		for(int i = 0; i < 10; i++) {
			gl.add(new Integer(rnd.nextInt(100)));
		}
		int k;
		Member m = null;
		boolean dir = true;
		while(ml.size() > 0) {
			k = rnd.nextInt(ml.size());
			m = ml.remove(k);
			System.out.printf("\nAfter %s is removed at position %d, the list contains:\n", m.getFullName(), k);
			if(ml.size() == 0) {
				System.out.print("Nothing");
			}
			else {
				show(ml, dir);
				dir = !dir;
			}
		}
		//show(gl, true);
		
    }
    
}
