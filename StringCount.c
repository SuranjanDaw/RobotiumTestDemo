#include <stdio.h>
int main()
{
    int n,i=0;
    int countSpace=0, countLine=0, countTab=0;
    /*printf("Enter the number of characters you want:" );
    scanf("%d",&n);*/
    char s[30];
    printf("Enter name: ");
    gets(s);     //Function to read string from user.
    printf("Name: ");
    puts(s);//Function to display string.
    for(i=0; i<n; i++)
    {
      if(s[i]==' ') countSpace++;
      else if(s[i]=='\n') countLine++;
      else if(s[i]=='\t') countTab++;
    }
    printf("%d %d %d",countSpace, countLine, countTab );

    return 0;
}
