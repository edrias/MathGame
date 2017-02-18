#include <iostream>
#include "mathgame.h"
#include <stdlib.h>
#include <time.h>
#include <set>
using namespace std;

namespace eddy_simk_ES

{
	mathgame::mathgame()
		{
			m_correct = 0;
			m_temp_correct=0;
			m_incorrect = 0;
			m_total= 0;
			m_grade = 0;
			m_operant_1 = 0;
			m_operant_2 = 0;
			m_answer = 0;
			input = 0;
		}
	
	void mathgame::menu()
	{
		cout<<endl; 
		cout<<"Choose a game-mode"<<endl;
		cout<<" 	P: Play Math Game" <<endl;
		cout<<" 	A: Level 1 -- Addition"<<endl;
		cout<<" 	S: Level 2 -- subraction"<<endl;
		cout<<" 	F: Level 3 -- Decimals"<<endl;
		cout<<" 	D: Level 4 -- Division"<<endl;
		cout<<" 	M: Level 5 -- Multiplication"<<endl;
		cout<<" 	G: Total Score"<<endl;
		cout<<" 	R: Restart Stats"<<endl;
		cout<<" 	Q: Quite the game"<<endl;
		
	} 

	char mathgame::get_user_command()
	{
		char command;
		
		cout<< "Enter choice"<<endl;
		cin>>command;

		return command;
	}
	
	void mathgame::level_addition()
	{
		srand(time(NULL));
		
		cout<<"Start of addition level"<<endl;
		cin.ignore();
		cout<<"You must answer 10 questions correctly"<<endl;
		cin.ignore();
		cout<<"Lets begin"<<endl;
		cin.ignore();
			int max =100; int min = 1;
	while ( m_correct < 10)
	{
		while (m_correct < m_temp_correct + 3 )
			{
				m_operant_1 = (rand() % max) + min;
				m_operant_2 = (rand() % max) + min;
	
				cout<< m_operant_1<<" + "<<m_operant_2<<endl;
				m_answer = m_operant_1 + m_operant_2;
				while (1)
				{
			    	cin>>input;
					if (cin.good())
					{
						if ( input == m_answer)
						{
							++m_correct;
							++m_total;
							cout<<"Correct!"<<endl;
							break;
						}
						else
						{
							cout<<"That is incorrect!"<<endl;
							cout<<"Correct answer is " <<m_answer<<endl;
							++m_total;
							++m_incorrect;
							break;
						}
					}
						else 
						{
							cout<<"Invalid input, try agin"<<endl;
							cin.clear();
							cin.ignore();
						}
				}
				
			}
		m_temp_correct += 3;

		if ( m_correct > 2 ) 
		{min = 100; max = 500;}
		if ( m_correct > 5) 
		{ min = 500; max = 1000;}
		if ( m_correct > 7) 
		{min = 1000; max = 10000;}
	}
	
		//m_temp_correct = m_correct;
		cout<<"Addiction level complete"<<endl;
}

	void mathgame::level_subtraction()	
	{
		srand(time(NULL));
		
		cout<<"Start of subtraction level"<<endl;
		cout<<"You must answer 10 questions correctly"<<endl;
		cout<<"Lets begin"<<endl;
			
		int max =100; int min = 1;
	while ( m_correct < 10)
	{
		while (m_correct < m_temp_correct + 3 )
			{
				m_operant_1 = (rand() % max) + min;
				m_operant_2 = (rand() % max) + min;
	
				cout<< m_operant_1<<" - "<<m_operant_2<<endl;
				m_answer = m_operant_1 - m_operant_2;
				while (1)
				{
			    	cin>>input;
					if (cin.good())
					{
						if ( input == m_answer)
						{
							++m_correct;
							++m_total;
							cout<<"Correct!"<<endl;
							break;
						}
						else
						{
							cout<<"That is incorrect!"<<endl;
							cout<<"Correct answer is " <<m_answer<<endl;
							++m_total;
							++m_incorrect;
							break;
						}
					}
						else 
						{
							cout<<"Invalid input, try agin"<<endl;
							cin.clear();
							cin.ignore();
						}
				}
				
			}
		m_temp_correct += 3;

		if ( m_correct > 2 ) 
		{min = 100; max = 500;}
		if ( m_correct > 5) 
		{ min = 500; max = 1000;}
		if ( m_correct > 7) 
		{min = 1000; max = 10000;}
	}
		
		cout<<"Good job!"<<endl; 
	    cout<<"Subtraction level complete"<<endl;

	}	

	void mathgame::level_multiplication()
	{

			
		srand(time(NULL));
	 	cout<<"Start of multiplication"<<endl;
		cout<<"You must answer 10 questions correctly"<<endl;
		cout<<"Lets begin"<<endl;
		
		int max =100; int min = 1;
	while ( m_correct < 10)
	{
		while (m_correct < m_temp_correct + 3 )
			{
				m_operant_1 = (rand() % max) + min;
				m_operant_2 = (rand() % max) + min;
	
				cout<< m_operant_1<<" * "<<m_operant_2<<endl;
				m_answer = m_operant_1 * m_operant_2;
				while (1)
				{
			    	cin>>input;
					if (cin.good())//if answer is not a number, will return false
					{
						if ( input == m_answer)
						{
							++m_correct;
							++m_total;
							cout<<"Correct!"<<endl;
							break;
						}
						else
						{
							cout<<"That is incorrect!"<<endl;
							cout<<"Correct answer is " <<m_answer<<endl;
							++m_total;
							++m_incorrect;
							break;
						}
					}
						else 
						{
							cout<<"Invalid input, try agin"<<endl;
							cin.clear();
							cin.ignore();
						}
				}
				
			}
		m_temp_correct += 3;

		if ( m_correct > 2 ) 
		{min = 100; max = 500;}
		if ( m_correct > 5) 
		{ min = 500; max = 1000;}
		if ( m_correct > 7) 
		{min = 1000; max = 10000;}
	}
			m_temp_correct = m_correct;
			cout<<"Multiplication level complete"<<endl;
	}	

	void mathgame::level_division()
		{
		srand(time(NULL));
		
		cout<<"Start of Division Level"<<endl;
		cout<<"You must answer 10 questions correctly"<<endl;
		cout<<"Lets begin"<<endl;
		cout<<"By the way..if you get a decimal number as your answer,"<<endl; 
		cout<<"round down to the nearest whole number."<<endl;
		
		int max =100; int min = 1;
	while ( m_correct < 10)
	{
		while (m_correct < m_temp_correct + 3 )
			{
				m_operant_1 = (rand() % max) + min;
				m_operant_2 = (rand() % max) + min;
	
				cout<< m_operant_1<<" + "<<m_operant_2<<endl;
				m_answer = m_operant_1 + m_operant_2;
				while (1)
				{
			    	cin>>input;
					if (cin.good())
					{
						if ( input == m_answer)
						{
							++m_correct;
							++m_total;
							cout<<"Correct!"<<endl;
							break;
						}
						else
						{
							cout<<"That is incorrect!"<<endl;
							cout<<"Correct answer is " <<m_answer<<endl;
							++m_total;
							++m_incorrect;
							break;
						}
					}
						else 
						{
							cout<<"Invalid input, try agin"<<endl;
							cin.clear();
							cin.ignore();
						}
				}
				
			}
		m_temp_correct += 3;

		if ( m_correct > 2 ) 
		{min = 100; max = 500;}
		if ( m_correct > 5) 
		{ min = 500; max = 1000;}
		if ( m_correct > 7) 
		{min = 1000; max = 10000;}
	}
	
		m_temp_correct = m_correct;
		cout<<"End of Division level\n";
	}

	void mathgame::refresh()
	{
			m_correct = 0;
			m_incorrect = 0;
			m_total= 0;
			m_grade = 0;
			m_temp_correct=0;
			cout<<"Stats have been reset"<<endl;
	}

	double mathgame::grade()
		{
			cout<< "Total number of questions attempted = " << m_total<<endl;
			cout<< "Number of incorrect answers = " <<m_incorrect<<endl;
			m_grade = m_correct /(double) m_total;	
			cout<< "Score = " << m_grade*100;
			
			
			return m_grade;
		}

	void mathgame::level_decimal()
	{
		cout<<"Start of decimal level"<<endl;
		cout<<"You must get 10 correct to complete this level"<<endl;
		cout<<"Lets begin"<<endl;


		cout<<"##Under Construction##"<<endl;
		
		
	}


}
