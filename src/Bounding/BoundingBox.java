package Bounding;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
class Surface extends JPanel
{
   private void doDrawing(Graphics g) 
   {
        Graphics2D g2d = (Graphics2D) g;
        // to put dots
        g2d.fillOval(50, 30, 5, 5); //(put the dot and size of dot
        g2d.fillOval(30, 80, 5, 5);
        g2d.fillOval(50, 200, 5, 5);
        g2d.fillOval(200, 50, 5, 5);
        g2d.fillOval(70, 60, 5, 5);
        g2d.fillOval(100, 90, 5, 5);
        g2d.fillOval(100, 110, 5, 5);
        g2d.fillOval(90, 60, 5, 5);
        g2d.fillOval(50, 100, 5, 5);
        g2d.fillOval(300, 50, 5, 5);     
        int[] xList = {50,30,50,200,70,100,100,90,50, 300};
        int[] yList = {30,80,200,50,60,90,110,60,100,50 };
        Arrays.sort(xList); // to find max and min value of x axis
        System.out.println("X Min value "+xList[0]);
        System.out.println("X Max value "+xList[xList.length-1]);        
        Arrays.sort(yList);// to find max and min value of y axis
        System.out.println("Y Min value "+yList[0]);
        System.out.println("Y Max value "+yList[yList.length-1]);
        int minX;
        int minY;
        int maxX;
        int maxY;
        minX = xList[0]; //minimum value of x axis in the arraylist
        minY = yList[0]; //minimum value of y axis in the arraylist
        maxX = xList[xList.length-1];
        maxY = yList[yList.length-1];
        g2d.drawLine(minX, minY, maxX, minY); // top horizontal line
        g2d.drawLine(minX, minY, minX, maxY);// left vertical line
        g2d.drawLine(minX, maxY, maxX, maxY);// down horizontal line
        g2d.drawLine(maxX, minY, maxX, maxY);// right vertical line
    }
    @Override
    public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       doDrawing(g);
    }
}
public class BoundingBox extends JFrame 
{
    public BoundingBox() 
    { 
    	initUI();
    }
    private void initUI()
    {
        add(new Surface());
        setTitle("Lines");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {    
            	BoundingBox ex = new BoundingBox();
                ex.setVisible(true);
            }
        });
    }
}