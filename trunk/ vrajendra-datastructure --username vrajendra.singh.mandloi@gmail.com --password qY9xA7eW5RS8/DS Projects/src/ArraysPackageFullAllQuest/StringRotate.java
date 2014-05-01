package ArraysPackageFullAllQuest;
 
class StringRotate {
	
	private String str = "internationalization";
	private int ROTATIONS = 2341;
	private int len = str.length();
	
	public StringRotate(){
		if(ROTATIONS > len){
			ROTATIONS = ROTATIONS%len;
			System.out.println(ROTATIONS);
		}
	}
	
	public String rotateClockwise(){
		
		char[] chararrayStr = str.toCharArray();
		
		for (int i = 0; i < ROTATIONS; i++)
        {
              char ch = chararrayStr[0];
              for (int j = 0; j < len - 1; j++)
              {
            	  chararrayStr[j] = chararrayStr[j + 1];
              }
              chararrayStr[len - 1] = ch;
        }
		return null;
	}
 
    public static void main(String[] args) {
    		StringRotate sr1 = new StringRotate();
            System.out.println(sr1.rotateClockwise());
    	
            try
            {
                 
 
                  /*System.out.println();
                  System.out.println("Anti-clockwise Rotation of a String");
 
                  for (int i = 0; i < len; i++)
                  {
                        char ch = outstring[len - 1];
                        for (int j = len - 1; j > 0; j--)
                        {
                              outstring[j] = outstring[j - 1];
                        }
                        outstring[0] = ch;
                        {
                              for (int k = 0; k < outstring.length; k++)
                                    System.out.print(outstring[k]);
                              System.out.println();
                        }
                  }*/
                 
            }
            catch (Exception e)
            {
                  e.printStackTrace();
            }
    }
}