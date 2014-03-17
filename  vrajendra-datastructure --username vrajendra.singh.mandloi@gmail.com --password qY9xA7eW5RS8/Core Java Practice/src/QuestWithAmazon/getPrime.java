package QuestWithAmazon;
class getPrime{
public static void main(String[] args){
int number = getNumberOfPrimes(100);
System.out.println(number);
}
    
static int getNumberOfPrimes(int N) {
    int count=0;
    for(int i=0;i<N;i++){
            if(isPrime(i)==true)
                count++;
    }
    return count;
}

static boolean isPrime(int n) {
    for(int i=2;i<n;i++) {
        if(n%i==0)
            return false;
    }
    return true;
}
}
