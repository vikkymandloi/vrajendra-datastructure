package QuestWithAmazon;

class Cc1_2{
     
	static void reverse(char[] target){
          int head = 0;
          int tail = target.length - 2;
          while(head < tail){
              char temp = target[head];
              target[head] = target[tail];
              target[tail] = temp;
              head++;
              tail--;
          }
     }
 
     public static void main(String[] args){
          char [] test = {'1','2','3','3','1','5','\0'};
          reverse(test);
          System.out.println(test);
     }
}