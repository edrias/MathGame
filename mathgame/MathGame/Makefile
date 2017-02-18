objects = mathgame.o main.o

CC= g++
CFLAGS = -Wall

main  : mathgame.o main.o
	$(CC) $(CFLAGS) -o $@ mathgame.o main.o

mathgame.o : mathgame.cpp mathgame.h
	$(CC) $(CFLAGS) -c $< -o $@


.PHONY : clean
clean : 
	rm -f $(objects) test
