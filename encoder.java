public class Enconder {
    
    public static void main (String [] args) {
        
        System.out.println("testing");
        String text = "Hello";
        MyClass test = new MyClass();
        String cipher = test.encode(text);
        System.out.println(cipher);
    }
    
    
    public String encode(String plainText){
        int shift = 3;
        String ciphertext = "";
        char alphabet;
        for(int i=0; i < plainText.length();i++) 
        {
             // Shift one character at a time
            alphabet = plainText.charAt(i);
            
            // if alphabet lies between a and z 
            if(alphabet >= 'a' && alphabet <= 'z') 
            {
             // shift alphabet
             alphabet = (char) (alphabet + shift);
             // if shift alphabet greater than 'z'
             if(alphabet > 'z') {
                // reshift to starting position 
                alphabet = (char) (alphabet+'a'-'z'-1);
             }
             ciphertext = ciphertext + alphabet;
            }
            
            // if alphabet lies between 'A'and 'Z'
            else if(alphabet >= 'A' && alphabet <= 'Z') {
             // shift alphabet
             alphabet = (char) (alphabet + shift);    
                
             // if shift alphabet greater than 'Z'
             if(alphabet > 'Z') {
                 //reshift to starting position 
                 alphabet = (char) (alphabet+'A'-'Z'-1);
             }
             ciphertext = ciphertext + alphabet;
            }
            else {
             ciphertext = ciphertext + alphabet;   
            }
        
    }
    //return System.out.println(" ciphertext : " + ciphertext);
    return ciphertext;
  }
        
}
