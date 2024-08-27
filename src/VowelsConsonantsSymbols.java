

public class VowelsConsonantsSymbols {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "AEIOUKKKKllllllllllllll&&&&&&&&&&&&&";
		int vowels = 0, consonants = 0, symbols = 0;
		while (str.toLowerCase().indexOf("a") != -1) {
			vowels++;
			str = str.substring(0,str.toLowerCase().indexOf("a")) + 
					str.substring(str.toLowerCase().indexOf("a")+1); 
		}
		while (str.toLowerCase().indexOf("e") != -1) {
			vowels++;
			str = str.substring(0,str.toLowerCase().indexOf("e")) + 
					str.substring(str.toLowerCase().indexOf("e")+1); 
		}
		while (str.toLowerCase().indexOf("i") != -1) {
			vowels++;
			str = str.substring(0,str.toLowerCase().indexOf("i")) + 
					str.substring(str.toLowerCase().indexOf("i")+1); 
		}
		while (str.toLowerCase().indexOf("o") != -1) {
			vowels++;
			str = str.substring(0,str.toLowerCase().indexOf("o")) + 
					str.substring(str.toLowerCase().indexOf("o")+1); 
		}
		while (str.toLowerCase().indexOf("u") != -1) {
			vowels++;
			str = str.substring(0,str.toLowerCase().indexOf("u")) + 
					str.substring(str.toLowerCase().indexOf("u")+1); 
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (97 <= str.toLowerCase().charAt(i)) {
				if (str.toLowerCase().charAt(i) <= 122) {
					consonants++;
				} else {
					symbols++;
				}
			} else {
				symbols++;
			}
		}
		System.out.println(vowels+"\n"+consonants+"\n"+symbols);
	}
}
