# Game of life

This project represents a game of life. 
It is a simulation game developed by the mathematician Conway.
The game is played on a matrix of square cells. Each cell 
is in one of two possible states: live(black) or dead(white).
Rules of the game are:
1.Any live cell with two or three live neighbours survives.
2.Any dead cell with three live neighbours becomes a live cell.
3.All other live cells die in the next generation. Similarly, all other dead cells stay dead.

First, program creates matrix with random states.
There is a dialog box that asks user if he wants to 
create the next generation.
Next generation is created by applying the above rules to every cell in the matrix.
