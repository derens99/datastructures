/**
 * Deren Singh
 * 10/12/2016
 * This class is the student class. It holds the first and last name of the student, their year of graduation, and their gpa.
 * It can print out their information along with validating a student.
 */
package student;

public class Student {
	
	private String firstName, lastName;//First and last name of student
	private int yog;//Students year of graduation
	private double gpa;//Students gpa
	
	/** Student special constructor to initialize instance variable
	 * @param f - first name
	 * @param l - last name
	 * @param y - year of graduation
	 * @param g - gpa
	 */
	public Student(String f, String l, int y, double g){
		firstName = f;
		lastName = l;
		yog = y;
		gpa = g;
	}
	
	/** Check the validity of students
	 * @param f - checking the first name
	 * @param l - checking the last name
	 * @param y - checking the year of graduation
	 * @param g - checking the gpa
	 */
	public static void validStudent(String f, String l, int y, double g){
		if(f.equals("") || l.equals("")){
			throw new IllegalArgumentException("Student's first or last name is empty!");
		}else if(y < 0){
			throw new IllegalArgumentException("Year of graduatation is negative!");
		}else if(g > 5 || g < 0){
			throw new IllegalArgumentException("GPA is not between 0.0-5.0!");
		}
	}
	
	//toString method to print class information. @return student information
	public String toString(){
		return "First Name: " + firstName + "\n" +
				"Last Name: " + lastName + "\n" +
				"Year of Graduation: " + yog + "\n" +
				"GPA: " + gpa; 
	}
}
