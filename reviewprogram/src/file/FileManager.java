/**
 * Deren Singh
 * 9/15/2016
 * This class writes, edits, and clears a certain file. It also names a file with the instance
 * variable named "filename" so it is easy to implement into other projects.
 */
package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {
	
	private final static String FILENAME = "employees.dat";//File Name
	private File f;//File for database objects
	
	//Constructor
	public FileManager(){
		f = new File(FILENAME);
	}
	
	/** Write to the file
	 * @param o - the object stored onto the file
	 */
	public static void write(Object o){
		try{
			FileOutputStream file = new FileOutputStream(FILENAME);
			ObjectOutputStream output = new ObjectOutputStream(file);
			output.writeObject(o);
			file.close();
			output.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	
	/** Get the instance of the file
	 * @return - the file instance
	 */
	public File getFile1(){
		return f;
	}
	
	/**Get the data within the file
	 * @return - file data
	 */
	public static Object getFile(){
		Object output = new Object();
		try{
			FileInputStream file2 = new FileInputStream(FILENAME);
			ObjectInputStream input = new ObjectInputStream(file2);
			output = input.readObject();
			file2.close();
			input.close();
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		return output;
	}
	
	//Clear file by deleting it and recreating it.
	public static void clearFile(){
		try{
			FileInputStream file2 = new FileInputStream(FILENAME);
			ObjectInputStream input = new ObjectInputStream(file2);
			file2.close();
			input.close();
			new File(FILENAME).delete();
			System.out.println("Deleted");
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
}
