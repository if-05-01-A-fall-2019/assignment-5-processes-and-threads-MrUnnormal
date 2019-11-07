#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>

#define BUFFER_LEN 1024

int main(){
  char line[BUFFER_LEN];
  char* argv[100];

  while(1){
    printf("> ");
    if(!fgets(line, BUFFER_LEN, stdin)){  //get command and put it in line
      break;                                //if user hits CTRL+D break
    }
    size_t length = strlen(line);
    if (line[length - 1] == '\n')
      line[length - 1] = '\0';

    char *token;                  //split command into separate strings
    token = strtok(line, " ");
    int i = 0;
    while(token != 0 && i < 100){
      argv[i] = token;
      token = strtok(0," ");
      i++;
    }
    argv[i] = 0;

    int pid = fork();
    int status;
    if(pid != 0)
    {
      //Parent
      waitpid(-1, &status, 0);
    }
    else
    {
      //Child
      execvp(argv[0],argv);
      printf("Child process could not do execvp\n");
    }
  }
}
