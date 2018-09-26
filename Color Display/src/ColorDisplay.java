			import java.awt.*;
			import java.util.*;
			import java.awt.image.BufferedImage;
			import javax.imageio.ImageIO;
			public class ColorDisplay {
			  public static final Scanner CONSOLE = new Scanner(System.in);
			  // Set main method, Using scanner to input value of each 
			  public static void main(String[] args) {
			    DrawingPanel panel = new DrawingPanel(550,550);  // Panel size
			    Graphics g = panel.getGraphics();
			    System.out.println("Project 2 written by An Tri Bao nguyen\n");      // Initial code from project 2
			    Color color1 = readColor();
			    Color color2 = readColor();
			    Color color3 = readColor();
			    Color color4 = readColor();
			    String string1 = colorToString(color1);            
			    String string2 = colorToString(color2);
			    String string3 = colorToString(color3);
			    String string4 = colorToString(color4);
			    System.out.println("\nThe first color is " + string1 + "\n");
			    System.out.println("\nThe second color is " + string2 + "\n");
			    System.out.println("\nThe third color is " + string3 + "\n");
			    System.out.println("\nThe fourth color is " + string4 + "\n");
			    displayColors(g, color1, color2, color3, color4);
			  }
			  // This method reads three color components (ints between 0 and 255)
			  // from the user and returns a color.
			  public static Color readColor() {   // Create a method read color
			    System.out.print("\nPlease enter the values for red, green and blue to determine a color three times: ");
			    int r = CONSOLE.nextInt();   // 	input integer red
			    int g = CONSOLE.nextInt();    // input integer Green
			    int b = CONSOLE.nextInt();    // intput integer blue
			    int outofrange = 0;    // using outofrange key word to indentified if any values input are out of range
			    
			    
			     //  if ((r<0 || r>255) && ( g <0 || g >255) && ( b < 0 || b > 255))  combine all 3 colors in if statement.
			    
			    
			    // set values out of range, If any of color input is out of range then the loop will goes back to that color asking for input
			    if (r < 0 || r > 255)    
			    {
			      System.out.println("The red value " + r + " is not within the range of 0 and 255 , Please re-enter the value again: ");
			      r = CONSOLE.nextInt();
			      outofrange++;
			    }
			    if (g < 0 || g > 255)
			    {
			      System.out.println("The green value " + g + " is not within the range of 0 and 255, Please re-enter the value again: ");
			      g = CONSOLE.nextInt();
			      outofrange++;
			    }
			    if (b < 0 || b > 255)
			    {
			      System.out.println("The blue value " + b + " is not within the range of 0 and 255, Please re-enter the value again: ");
			      b = CONSOLE.nextInt();
			      outofrange++;
			    }
			    
			    Color newColor = new Color(r, g, b);
			    return newColor;
			  }
			  //prints out what r,g and b are from user input
			  public static String colorToString(Color c) {
				 
			    int r = c.getRed();    //Returns the red component in the range 0-255 in the default sRGB space.
			    int g = c.getGreen();  //Returns the green component in the range 0-255 in the default sRGB space.
			    int b = c.getBlue();   //Returns the blue component in the range 0-255 in the default sRGB space.
			
			    return "[ r=" + r + "," + "g=" + g + "," + " b=" + b + "]";
			  }
			  // This method displays the four colors and combinations of these colors
			  // in the window.
			  public static void displayColors(Graphics g, Color c1, Color c2, Color c3, Color c4)
			  {
			    for (int i = 0; i <= 10; i++)     // 11 columns and 11 rows,  50 x 50 pixels. 
			    {
			      
			      for (int k = 0; k <= 10; k++)
			      {
			    	    // Prints out all 3 colors depend on user input values
			        int red = average3colors(i, k, c1.getRed(), c2.getRed(), c3.getRed(), c4.getRed());     
			       
			        int green = average3colors(i, k, c1.getGreen(), c2.getGreen(), c3.getGreen(), c4.getGreen());
			       
			        int blue = average3colors(i, k, c1.getBlue(), c2.getBlue(), c3.getBlue(), c4.getBlue());
			       
			        g.setColor(new Color(red, green, blue));
			        g.fillRect(i*50, k*50, 550, 550);
			    
			      }
			    }
			  }
			 
			  public static int average3colors(int column, int row, int h1, int h2, int h3, int h4)
			  {
				 // use the formula given to caculate all 3 colors
			    int w1 = (10 - row) * (10 - column);
			    int w2 = (10 - row) * column;
			    int w3 = row * (10 - column);
			    int w4 = row * column;
			    int Calc = (w1 * h1 + w2 * h2 + w3 * h3 + w4 * h4) / (w1 + w2 + w3 + w4);      
			    return Calc;
			  }
			}