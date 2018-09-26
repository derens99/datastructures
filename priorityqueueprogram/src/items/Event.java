/** Deren Singh - Ms. Stowe
 * This class holds the information needed for an event. It has an event name and 
 * a date when the event is.
 */
package items;

public class Event implements Comparable{
	
	private String name;//Event name
	private Date date;//Event date
	
	/** Special constructor to set variables
	 * @param n - name being passed in
	 * @param m - the month
	 * @param d - the day
	 * @param y - the year
	 */
	public Event(String n, int m, int d, int y){
		name = n;
		date = new Date(m, d, y);
	}
	
	public Date getDate(){
		return date;
	}
	
	/** Compare two dates to each other for events
	 * @param - event getting passed in
	 * @return - integer of which object comes first
	 */
	public int compareTo(Object o) {
		System.out.println(o.toString());
		if(o instanceof Event){
			Event e = (Event) o;
			return e.getDate().compareTo(date);
		}else{
			throw new IllegalArgumentException("Event type not passed in!");
		}
	}
	
	public String toString() {
		return "Name: " + name + "\nDate: " + date.toString();
	}
	
	//Get name
	public String getName(){
		return name;
	}
	
	//Validate event name
	public static void validName(String s){
		if(s.equals("")){
			throw new IllegalArgumentException("Invalid event name!");
		}
	}
	
	
}
