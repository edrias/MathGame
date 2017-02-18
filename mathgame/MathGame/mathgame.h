#ifndef EDDY_SIM_MATHGAME_H
#define EDDY_SIM_MATHGAME_H
//
namespace eddy_simk_ES
{
	class mathgame
	{
		public: 
			mathgame();
			void menu();
			void level_addition();
			void level_subtraction();
			void level_multiplication();
			void level_decimal();
			void level_division();
			void level_();
			void refresh();
			char get_user_command();
			double grade();

		private:
			int m_correct;
			int m_temp_correct;
			int m_incorrect;
			int m_total;
			int m_operant_1;
			int m_operant_2;
			int m_answer;
			int input;
			double m_grade;
			//arrays
		
				
	};
}
#endif
