import java.util.Scanner;

public class encoder_decoder {
	
	public static char referenceTable[] = new char[] {'A','B', 'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
    		'R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','(',')','*','+',',','-','.','/'};
	
	public static encoder_decoder test = new encoder_decoder();
	 
	public static char shiftChar;
	
    
    public static void main (String [] args) {
        
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter the string you want to encode: ");
    	String text = sc.nextLine();
    	System.out.print("Enter the character used for the shift : ");
    	shiftChar = sc.next().toUpperCase().charAt(0);
    	sc.close();
        String cipher = test.encode(text);
        System.out.println("The encoded text is: "+shiftChar+cipher);
        String decode = test.decode(cipher);
        System.out.println("The decoded text is: "+decode);
        
    }
    
    public int shift(char[] referenceTable) {
    	
    	int shift = 0;
    	for(int i=0; i < referenceTable.length; i++) {
    		if(referenceTable[i] == shiftChar) {
    			shift = i;
    		} else {
    			
    		}
    	}
		return shift;
    	
    }
    public String encode(String plainText){
        String ciphertext = "";
        char currentCharacter;
        boolean isNotFound;
        int shiftCount = shift(referenceTable);
        for(int i=0; i < plainText.length();i++) 
        {
            // Shift one character at a time
        	currentCharacter = plainText.toUpperCase().charAt(i);
            isNotFound = true;
        	if(currentCharacter == ' ') {
        		ciphertext = ciphertext + ' ';
        	} else {
        		for(int k = 0; k < referenceTable.length && isNotFound; k++) {
        			int limit = k + 2;
            		if(currentCharacter == referenceTable[k]) {
            			char newCharacter = currentCharacter;
            			if((k - shiftCount) < 0) {
            				int temp = k + 44;
            				newCharacter = referenceTable[temp - shiftCount];
            				ciphertext = ciphertext + newCharacter;
            				isNotFound = false;
            			} else {
            				newCharacter = referenceTable[k - shiftCount];
                			ciphertext = ciphertext + newCharacter;
                			isNotFound = false;
            			}
            			
            		} else if (limit > referenceTable.length) {
            			ciphertext = ciphertext + currentCharacter;
            		}
            	}
        	}
        
        }
	    return ciphertext;
    }
  
    public String decode(String encodedText){
        String plaintext = "";
        char currentCharacter;
        boolean isNotFound;
        int shiftCount = shift(referenceTable);
        for(int i=0; i < encodedText.length();i++) 
        {
            // Shift one character at a time
        	currentCharacter = encodedText.toUpperCase().charAt(i);
            isNotFound = true;
        	if(currentCharacter == ' ') {
        		plaintext = plaintext + ' ';
        	} else {
        		for(int k = 0; k < referenceTable.length && isNotFound; k++) {
        			int limit = k + 2;
            		if(currentCharacter == referenceTable[k]) {
            			char newCharacter = currentCharacter;
            			if((k + shiftCount) > 44) {
            				int temp = k - 44;
            				newCharacter = referenceTable[temp + shiftCount];
            				plaintext = plaintext + newCharacter;
            				isNotFound = false;
            			} else {
            				newCharacter = referenceTable[k + shiftCount];
            				plaintext = plaintext + newCharacter;
                			isNotFound = false;
            			}
            			
            		} else if (limit > referenceTable.length) {
            			plaintext = plaintext + currentCharacter;
            		}
            	}
        	}
        
        }
	    return plaintext;
    }
}
