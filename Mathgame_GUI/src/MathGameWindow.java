import java.awt.Color;//color for background
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;//basic window features
import javax.swing.JLabel;//displays text and images
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Random;



public class MathGameWindow extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JFrame window;
	private JPanel panel;
	//buttons
	private JButton button;//start button
	private JButton addition;//addition button
	private JButton subtraction;//subtraction button
	private JButton multiplication;//multiplication button
	private JButton division;//division button
	private JButton exit;//close program
	private JButton help;//how to play
	private JButton quit;//return to main menu
	private JButton enter;//enter input for problem
	private JButton next;//will generate another problem is answer is correct
	private JButton easy;//easy level
	private JButton medium;//medium level
	private JButton hard;//hard level
	//labels
	private JLabel title;
	private JLabel author;
	private JLabel menu;
	private JLabel printProblem;
	//private JLabel printSub;
	//private JLabel printMult;
	//private JLabel printDiv;
	
	//textField
	private JTextField input;
	
	//Random number generator
	private Random rand;
	
	//Integers
	private int answer;
	private int count;
	private int numb1;
	private int numb2;
	private int width;//width of window
	private int height;//height of window
	private int level;//determines easy(0), med(1), hard(2) 
	//Strings
	private String operant1;
	private String operant2;
	
	//characters
	private char operation;
	
	//action event
	private ActionEvent e;
	
	//booleans
	boolean boolEasy;
	boolean boolMedium;
	boolean boolHard;
	
	
	public MathGameWindow()
	{	
		//window
		window = new JFrame("Math Game");
		window.setSize(500, 500);
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//panel
		panel = new JPanel();
		panel.setBackground(Color.orange);
		panel.setLayout(null);
		window.add(panel);
		
//===================================================================		
	//buttons
		//start button
		button = new JButton("Start");
		button.setBounds(125,200, 235, 50);//width, height, button dimension width, height
		button.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30));
		button.addActionListener(this);
		button.setActionCommand("start");
		panel.add(button);
		
		//addition button
		addition = new JButton("Addition");
		addition.setBounds(125,120, 250, 50);//width, height, button dimension width, height
		addition.setFont(new Font("Serif", Font.BOLD, 30));
		addition.addActionListener(this);
		addition.setActionCommand("addition");
		panel.add(addition);
		addition.setVisible(false);
		
		//subtraction button
		subtraction = new JButton("Subtraction");
		subtraction.setBounds(125,180, 250, 50);//width, height, button dimension width, height
		subtraction.setFont(new Font("Serif", Font.BOLD, 30));
		subtraction.addActionListener(this);
		subtraction.setActionCommand("subtraction");
		panel.add(subtraction);
		subtraction.setVisible(false);
		
		//multiplication buttons
		multiplication = new JButton("Multiplication");
		multiplication.setBounds(125,240, 250, 50);//width, height, button dimension width, height
		multiplication.setFont(new Font("Serif", Font.BOLD, 30));
		multiplication.addActionListener(this);
		multiplication.setActionCommand("multiplication");
		panel.add(multiplication);
		multiplication.setVisible(false);
		
		//division buttons
		division = new JButton("Division");
		division.setBounds(125,300, 250, 50);//width, height, button dimension width, height
		division.setFont(new Font("Serif", Font.BOLD, 30));
		division.addActionListener(this);
		division.setActionCommand("division");
		panel.add(division);
		division.setVisible(false);
		
		//exit button
		exit = new JButton("Exit");
		exit.setBounds(260,360, 115, 50);//width, height, button dimension width, height
		exit.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30));
		exit.addActionListener(this);
		exit.setActionCommand("exit");
		panel.add(exit);
		exit.setVisible(false);
		
		//help button
		help = new JButton("Help");
		help.setBounds(125,360, 115, 50);//width, height, button dimension width, height
		help.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30));
		help.addActionListener(this);
		help.setActionCommand("help");
		panel.add(help);
		help.setVisible(false);
		
		//quit button - return to main menu
		quit = new JButton("Quit");
		quit.setBounds(350, 400, 115, 50);
		quit.setFont(new Font("Serif", Font.ITALIC, 30));
		quit.addActionListener(this);
		quit.setActionCommand("quit");
		quit.setVisible(false);
		panel.add(quit);
		
		//enter button - for user input
		enter = new JButton("Enter");
		enter.setBounds(180, 275, 140, 50);
		enter.setActionCommand("enter");
		enter.addActionListener(this);
		enter.setVisible(false);
		panel.add(enter);
		
		//next button - generate new math problem
		next = new JButton("Next Problem");
		next.setBounds(180, 225, 250, 50);
		next.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30));
		next.setActionCommand("next");
		next.addActionListener(this);
		next.setVisible(false);
		panel.add(next);
		
		//easy game mode
		easy = new JButton("Easy");
		easy.setBounds( 25, 175, 150, 75);
		easy.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30));
		easy.setActionCommand("easy");
		easy.addActionListener(this);
		easy.setVisible(false);
		panel.add(easy);
		
		//medium button
		medium = new JButton("Medium");
		medium.setBounds( 175, 175, 150, 75);
		medium.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30));
		medium.setActionCommand("medium");
		medium.addActionListener(this);
		medium.setVisible(false);
		panel.add(medium);
		
		//hard button
		hard = new JButton("Hard");
		hard.setBounds( 325, 175, 150, 75);
		hard.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30));
		hard.setActionCommand("hard");
		hard.addActionListener(this);
		hard.setVisible(false);
		panel.add(hard);
//=========================================================================
	//JLabels
		
		//title = new JLabel("Math Game!");
		title = new JLabel("Math Game");
		title.setFont(new Font("Serif", Font.BOLD, 48));
		title.setBounds(120, 100, 250, 70);
		title.setVisible(true);
		panel.add(title);
		
		//JLabel - author
		author = new JLabel("By Emmanuil Simkhayev");
		author.setBounds(180, 160, 250, 20);
		author.setFont(new Font("Serif", Font.PLAIN + Font.ITALIC, 16 ));
		author.setVisible(true);
		panel.add(author);
		
		//menu label
		menu = new JLabel("Main Menu");
		menu.setBounds(125, 50, 250, 50);
		menu.setFont(new Font("Serif", Font.BOLD, 48));
		menu.setVisible(false);
		panel.add(menu);
		
		//label for printing math problems
		printProblem = new JLabel();
		printProblem.setFont(new Font("Serif", Font.BOLD, 48));
		printProblem.setBounds(175, 175, 250, 50);
		printProblem.setVisible(false);
		panel.add(printProblem);  printProblem.setVisible(false);
//==================================================================		
	//JTextField
		//user input for problems
		input = new JTextField(10);
		input.setBounds(180, 225, 140, 50);
		input.setFont(new Font("Arial", Font.PLAIN, 30));
		panel.add(input);
		input.setVisible(false);
//==================================================================		
	//random number generator
		rand = new Random();
//==================================================================		
	//Integers
		//answer
		answer = 0;
		count = 0;
		numb1 = 0;
		numb2 = 0;
		width = 500;
		height = 500;
		level = 0;
//==================================================================		
	//characters
		//operation
		operation = 0;
//==================================================================	
	//strings
		operant1 = null;
		operant2 = null;
//==================================================================
	//booleans
		boolEasy = false;
		boolMedium = false;
		boolHard = false;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String action = e.getActionCommand();
		
		
			if( action.equals("start"))//start button to game
			{
				
				//getContentPane().setBackground(Color.RED);
				button.setVisible(false);
				title.setVisible(false);
				author.setVisible(false);
				menuVisible(true);
			}
			
			if (action.equals("addition"))
			{
				menuVisible(false);
				quit.setVisible(true);
				operation = '+';
				difficulty(true);//setVisible difficulty options
				//printProblem(operation);
			}
			
			if (action.equals("subtraction"))
			{
				menuVisible(false);
				quit.setVisible(true);
				operation = '-';
				difficulty(true);
				//printProblem(operation);
			}
			
			if (action.equals("multiplication"))
			{
				menuVisible(false);
				quit.setVisible(true);
				operation = '*';
				difficulty(true);
				//printProblem(operation);
			}
			
			if (action.equals("division"))
			{
				menuVisible(false);
				quit.setVisible(true);
				operation = '/';
				difficulty(true);
				//printProblem(operation);
			}
			
			if (action.equals("exit"))
			{
				
				System.exit(0);
			}
			
			if (action.equals("help"))
			{
				menuVisible(false);
				quit.setVisible(true);
			}
			
			if ( action.equals("quit"))
			{
				quit.setVisible(false);
				menuVisible(true);
				difficulty(false);
				printProblem.setVisible(false);
				input.setVisible(false);//remove textfield
				enter.setVisible(false);//remove enter button
				title.setVisible(false);//title is now "Level complete"
				next.setVisible(false);
				count = 0;//reset problems correct
				
			}
			if ( action.equals("enter"))
			{
				
				if ((input.getText()).equals(getAnswer(answer)))//compare textfield with correct answer
				{
					input.setVisible(false);
					printProblem.setVisible(false);
					enter.setVisible(false);
					next.setVisible(true);
					++count;
				}
					
			}
			
			if ( action.equals("next"))
			{
				if ( count > 1)//for now its >1 for debugging purposes
				{
					//I am reusing JLabel title because the program never returns to the title page.
					title.setText("Level Complete!");
					title.setBounds(75, 175, 500, 50 );
					title.setVisible(true);
					next.setVisible(false);
					count = 0;
				}
				else
				{
					++count;
					generateProblem(operation,level );
				}
				
			}
			
			
			if ( action.equals("easy"))//button for easy level
			{
				level = 0;//easy
				generateProblem(operation, level);
				difficulty(false);
			}
			
			if ( action.equals("medium"))//button for medium level
			{
				level = 1;//medium
				generateProblem(operation, level);
				difficulty(false);
			}
			if ( action.equals("hard"))
			{
				level = 2;//hard
				generateProblem(operation, level);//button for hard level
				difficulty(false);
			}
			
			
		
		
	}
	
	
	
	public void menuVisible(boolean bool)//set the menu visible or not visible
	{
		
		menu.setVisible(bool);
		addition.setVisible(bool);
		subtraction.setVisible(bool);
		multiplication.setVisible(bool);
		division.setVisible(bool);
		exit.setVisible(bool);
		help.setVisible(bool);
		
	}
	
	public String getAnswer(int answer)//converts answer to string so we can compare to textField
	{
		String solution = Integer.toString(answer);
		
		return solution;
	}
	
	
	public void difficulty(boolean bool)//sets visible the three difficulty modes
	{
		easy.setVisible(bool);
		medium.setVisible(bool);
		hard.setVisible(bool);
	}
	
	
	public void generateProblem(char operation, int level )//int level is either 0,1, or 2 easy, med, hard
	{
		rand.nextInt();
		numb1 = rand.nextInt(getLevel(level)) + 1;//minimum value is getLevel/2
		numb2 = rand.nextInt(getLevel(level)) + 1;//or getLevel/10 if division
		System.out.println(numb1 + numb2);
		//get the bounds for random number generator from getLevel method.
		numb1 = Math.max(numb1, numb2);//makes it easier if numb1 is larger 
		numb2 = Math.min(numb1, numb2);//when we subtract and divide
		
		if ( isDivision(operation) == true)
		{
			
			numb2 = numb2/10 + rand.nextInt(10) + 1;//eliminate chance of dividing by zero
		}
		answer = returnAnswer(operation, numb1, numb2);
		
		operant1 = Integer.toString(numb1);
		operant2 = Integer.toString(numb2);

		printProblem.setText(operant1 + " " + operation + " " + operant2);
		printProblem.setBounds( 200, 175, 300, 50);
		printProblem.setVisible(true);

		input.setVisible(true);
		input.setText(null);
		enter.setVisible(true);
		next.setVisible(false);
	}
	
	public int returnAnswer(char operation, int numb1, int numb2)//returns answer based on operation
	{
		if ( operation == '+')
			answer = numb1 + numb2;
		
		if ( operation == '-')
		{
			numb1 = Math.max(numb1, numb2);//avoiding negative numbers 
			numb2 = Math.min(numb1, numb2);
			answer = numb1 - numb2;
		}
		
		if (operation == '*')
			answer = numb1*numb2;
		
		if ( operation == '/')
		{
			numb1 = Math.max(numb1, numb2);//we want the larger number to be in the denominator
			numb2 = Math.min(numb1, numb2);
			answer = numb1/numb2;
		}
		return answer;
	}
	
	public int getLevel(int level)//return maximum number for each level
	{
		if ( level == 0)
			return 10;
		
		if (level == 1)
			return 100;
		
		if (level == 2)
			return 1000;
		
		return 0;
	}
	
	//if operation is division we want to make the minimum random number no more than 10
	public boolean isDivision(char operation)
	{
		if ( operation == '/')
			return true;
	
		return false;
	}
}