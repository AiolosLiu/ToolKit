import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ComparatorUsage {
	public class Dinosaur{
		String name;
		int speed;
		public Dinosaur(String name, int speed){
			this.name  = name;
			this.speed = speed;
		}
		public String toString() {
			return this.name + ": " + this.speed;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Dinosaur> dinos = new LinkedList<>();
		dinos.add(new ComparatorUsage().new Dinosaur("Kaw", 54));
		dinos.add(new ComparatorUsage().new Dinosaur("Hsd", 41));
		dinos.add(new ComparatorUsage().new Dinosaur("Ghh", 61));
		
		System.out.println("Order by speed");
		Collections.sort(dinos, new Comparator<Dinosaur>() {
			@Override
			public int compare(Dinosaur d1, Dinosaur d2) {
				// TODO Auto-generated method stub
				// from small to big
				//return d1.speed - d2.speed;
				//from big to small 
				return d2.speed - d1.speed;
			}
		});
		for (Dinosaur d : dinos){
			System.out.println(d);
		}
		System.out.println("Order by name");
		Collections.sort(dinos, new Comparator<Dinosaur>() {
			@Override
			public int compare(Dinosaur d1, Dinosaur d2) {
				// TODO Auto-generated method stub
				// from small to big
				return d1.name.compareTo(d2.name);
				//from big to small 
				//return d2.name.compareTo(d1.name);
			}
		});
		
		for (Dinosaur d : dinos){
			System.out.println(d);
		}
	}

}
