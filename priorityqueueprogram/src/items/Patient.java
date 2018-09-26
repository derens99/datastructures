/** Deren Singh - Ms. Stowe
 * This class holds the data for a patient such as the name and priority. It also compares
 * two patients to each other using their priority.
 */
package items;

public class Patient implements Comparable{
	
	private String name;//Patient name
	private int priority;//Patient priority
	
	
	/** Special constructor
	 * @param n - name 
	 * @param p - priority
	 */
	public Patient(String n, int p){
		name = n;
		priority = p;
	}
	
	//Getters
	public int getPriority(){
		return priority;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString() {
		return "Name: " + name + "\nPriority: " + priority; 
	}
	
	/** Compare two patients to each other
	 * @param o - the patient getting compared
	 * @return - an integer of two patients getting compared
	 */
	public int compareTo(Object o) {
		if(o instanceof Patient){
			Patient temp = (Patient)o;
			return temp.getPriority() - priority;
		}else{
			throw new IllegalArgumentException("Patient object not passed in!");
		}
	}
	
	//Validate patient
	public static void validPatient(String n, int p){
		if(n.equals("")){
			throw new IllegalArgumentException("Invalid patient name!");
		}
	}
	
}
