#include <iostream>
#include <cctype>
#include <stdlib.h>
#include <time.h>
#include <set>
#include "mathgame.h"
using namespace eddy_simk_ES;
using namespace std;

int main()
{
	mathgame math;
	char choice;
	
	cout<< "Welcome to Mathgame!"<<endl;
	
	do 
	{
		math.menu();
		choice = toupper(math.get_user_command());
		switch(choice)
		{
			case 'P': cout<<endl;
					  cout<<"A total of 50 correct answers to win."<<endl;
					  math.level_addition();       cout<<endl;
					  math.level_subtraction();    cout<<endl;
					  math.level_decimal();        cout<<endl;
					  math.level_division();       cout<<endl;
					  math.level_multiplication(); cout<<endl;
					  break;
			case 'A': math.level_addition();
					  break;
			case 'S': math.level_subtraction();
					  break;
			case 'F': math.level_decimal();
					  break;
			case 'D': math.level_division();
					  break;
			case 'M': math.level_multiplication();
					  break;
			case 'G': math.grade();
				      break;
			case 'R': math.refresh();
					  break;
			case 'Q': math.grade(); cout<<endl;
					  cout<<"Good-bye, thanks for playing."<<endl;
					  break;
			default: cout<< choice<<" is invalid."<<endl;
		}
	}
	while (( choice!= 'Q'));

	return EXIT_SUCCESS;
}
