package Lecture32;

public class HTclient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashTable<String, Integer> popMap = new HashTable<>(3);
		popMap.put("China", 2000);
		popMap.put("India", 1200);
		popMap.put("US", 250);
		popMap.put("Pak", 800);
		popMap.put("UK", 50);
		popMap.put("WinterFell", 25);
		popMap.put("KingsLanding", 75);
		
		popMap.display();
		System.out.println(popMap.get("US"));
		popMap.remove("UK");
		popMap.display();
		
		System.out.println(popMap.get("WinterFell"));
		popMap.put("WinterFell", 10);
		
		popMap.display();
	//	popMap.display();
		
	}

}
