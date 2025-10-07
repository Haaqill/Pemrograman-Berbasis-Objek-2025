# Source code

### SupportSystem
```java
import java.util.Map;  
import java.util.HashMap;  
import java.util.Random;  
public class SupportSystem {  
    private Map<String, String> responses;  
    private Random random;
    private InputReader reader;
   
    public SupportSystem() {  
        responses = new HashMap<>();  
        random = new Random();
        reader = new InputReader();
         // beberapa pasangan kata kunci → respons  
        responses.put("error", "Apakah Anda menerima pesan kesalahan? Coba restart sistem.");  
        responses.put("help", "Apa yang bisa saya bantu?");  
        responses.put("crash", "Kapan crash terjadi? Apakah ada pesan spesifik?");  
        responses.put("slow", "Sudahkah Anda memeriksa penggunaan CPU dan RAM?");  
        responses.put("lemot", "Sudahkah Anda memeriksa penggunaan CPU dan RAM?");  
    }  
   
    public String getResponse(String userInput) {  
        String[] words = userInput.toLowerCase().split("\\s+");  
        for (String w : words) {  
            if (responses.containsKey(w)) {  
                return responses.get(w);  
            }  
        }  
         // kalau tidak ada kata kunci cocok, jawaban acak generik  
        String[] generic = {  
            "Coba jelaskan lebih rinci.",  
            "Saya belum mengerti, bisa ulangi?",  
            "Bisakah Anda memberi detail lebih lanjut?"  
        };  
        return generic[random.nextInt(generic.length)];  
    }
    
    public void start() {  
        boolean finished = false;
        
        while(!finished){
            System.out.println("Tolong ceritakan keluhan anda (ketik \"x\" untuk keluar):");
            String input = reader.getInput();
            if(input.charAt(0) == 'x'){
                finished = true;
            }
            else {
               System.out.println(getResponse(input)); 
            }
        }
        
        System.out.println("goodbye");
    }  
 }
```


### InputReader
```java
import java.util.Scanner;

public class InputReader
{
    private Scanner scanner;
    
    public InputReader(){
        scanner = new Scanner(System.in);
    }
    
    public String getInput(){  
        String inputLine = scanner.nextLine();
        
        return inputLine;
    }
}
```
