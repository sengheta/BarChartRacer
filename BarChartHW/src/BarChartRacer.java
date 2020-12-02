import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BarChartRacer {

	String fileName; //filename of data to be graphed
	int topN; 
	String title;
	String xAxisLabel;
	String source;

	/*
	 * constructor for BarChartRacer - takes user input for filename
	 */
	BarChartRacer(String fileName){
		this.fileName = fileName;
	}

	/*
	 * creating an arraylist to store contents of file
	 * @param takes in topN from user - to display top 5 or top 10,etc through the years
	 */

	ArrayList<Bar> getData (int topN) throws IOException {
		File fileToRead = new File (fileName);


		Scanner scnr = new Scanner(fileToRead); //scan in new file
		title = scnr.nextLine(); //first line is title
		xAxisLabel = scnr.nextLine(); //second line is x axis label
		source = scnr.nextLine(); //third line is source
		BarChart bc1 = new BarChart(title, xAxisLabel, source);
		StdDraw.setCanvasSize(1000, 700);

		while(scnr.hasNextLine()) { //while the file has content i.e. while there is a next line

			int numItems = scnr.nextInt();//number of items in group                   
			scnr.nextLine(); //consume end of line character

			ArrayList<Bar> barList = new ArrayList<>(); //create new list of bars, which we will sort later
			String year = null;
			String name;
			String country;
			int value;
			String category;
			for (int i=0; i<numItems; i++){ //iterate through time period group

				String [] tokens = scnr.nextLine().split(","); //split each line by comma 

				year = tokens[0];       //first token is year
				name = tokens[1];       // second token is name
				country = tokens[2];    // third token is country
				value = Integer.parseInt(tokens[3]);    //fourth token is value
				category = tokens[4];               //fifth token is category

				Bar newBar = new Bar(name, value, category);   //create new bar for each line in file

				barList.add(newBar);                          //add this bar to our list we created

			}
			bc1.setCaption(year);                             //set caption to be the year



			Collections.sort(barList, Collections.reverseOrder());              //sort by value, call reverse order so it is largest to smallest
			for (int i=0; i< topN; i++) {                                       //choose the topN bars

				bc1.add(barList.get(i).getName(), barList.get(i).getValue(), barList.get(i).getCategory());         // add it to the bar chart we created
			}



			StdDraw.enableDoubleBuffering();            
			bc1.draw();
			StdDraw.show();
			bc1.reset();
			StdDraw.pause(100);           //pause for 100 milliseconds 
			StdDraw.clear();               // clear the board and start over, printing the next year's data
		}

		return null;

	}
	
	
	public static void main(String[] args) throws IOException {


		Scanner s = new Scanner(System.in);                            //create new scanner to interact with user
		System.out.println("Enter the name of a file to graph: ");     //ask user for file name for data source/input
		String userFile = s.next(); 
		System.out.println("Enter how many pieces of data you'd like to see: ");   //ask user for topN e.g. top 5 or 10 etc baby names each year
		int topN = s.nextInt();
		BarChartRacer bcr1 = new BarChartRacer(userFile + ".txt");                 //create a new barChartRacer with the new file name 
		bcr1.getData(topN);                                                     //call the getData method, passing in the topN to create the bar charts
	}
}






