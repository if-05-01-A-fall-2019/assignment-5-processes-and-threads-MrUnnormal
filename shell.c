#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>

#define  MAX_COMMAND_LENGTH 64

char* getNextCommand(char const *argv[], int* startpoint);

int main(int argc, char const *argv[])
{
    int iterator_arg;
    int status;
    if(fork() != 0) {
      //printf("Hallo i bims parent\n");
      //printf("%d\n", getpid());   // Prints pid from parent ; just checking
      waitpid(-1, &status, 0);    // waits for all childs (-1) to properly end program
    }
    else {
      //printf("Hallo i bims child\n");
      //printf("%d\n", getpid()); // Prints pid from child ; just checking
      getNextCommand(argv, 0);
    }
    return 0;
}

char* getNextCommand(char const *argv[], int* startpoint)
{
  int i = startpoint;
  int current_command_iterator = 0;
  char current_command[MAX_COMMAND_LENGTH];
  while (argv[i] == '\0' || argv[i] != '&') {
    current_command[current_command_iterator] += argv[i];
    i++;
    current_command_iterator++;
  }
  //printf("%s\n", current_command);
  return current_command;
}
