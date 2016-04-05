package Bounding;
import java.applet.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class BoundBox extends Applet 
{
	int xList [], yList[]; 
	int noOfPoints;
	public void init() 
	{
		BufferedReader br = null;  //read the user input value at runtime
		try
		{
			br = new BufferedReader(new InputStreamReader(System.in)); 
			System.out.println("Enter Number of points to draw : ");
			noOfPoints = Integer.parseInt(br.readLine()); //convert string to integer
			xList = new int[noOfPoints]; //array size init
			yList = new int[noOfPoints];
            for(int i = 0 ; i< noOfPoints; i++ )
			{
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter X"+i+" Value :");
				xList[i] = Integer.parseInt(br.readLine());
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter Y"+i+" Value :");
				yList[i] = Integer.parseInt(br.readLine());
			}
			setBackground( Color.WHITE );
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	public void paint( Graphics g ) 
	{
		this.setSize(300, 300);  
		g.setColor( Color.black );
		//Draw Dots
		for(int i = 0; i < noOfPoints; i++)
			g.fillOval(xList[i], yList[i], 5,5);
		//Sorting Array
		Arrays.sort(xList);
		Arrays.sort(yList);
		//Draw Box
		int minX = xList[0];
		int minY = yList[0];
		int maxX = xList[xList.length-1];
		int maxY = yList[yList.length-1];
		//Draw line
		g.drawLine(minX, minY, maxX, minY); // top horizontal line
		g.drawLine(minX, minY, minX, maxY); // left vertical line
		g.drawLine(minX, maxY, maxX, maxY); // down horizontal line
		g.drawLine(maxX, minY, maxX, maxY); // right vertical line
	}
}