//Programa para decodificar dados RLE

public class Main
{
	public static void main(String[] args) {
	
	//os dados que precisam ser decodificados
	byte data[] = {3,15,6,4};
	
	//os dados decodificados
	//método de chamada decodeRLE()
	byte decoded[] = decodeRLE(data);
	
	//imprimir os dados decodificados
	for(int i=0;i<decoded.length;i++){
      System.out.println(decoded[i]);
	 }
   
	}

    //método decodedRLE
    public static byte[] decodeRLE(byte[] rleData){
    
    //tamanho dos dados que precisam ser decodificados
    int n = rleData.length;
    
    //array para armazenar os números que representam os dados repetidos
    byte repeats[] = new byte[n/2];
    
    //array para armazenar os números que devem ser repetidos
    byte data2[] = new byte[n/2];
    
    //tamanho da nova array decodificada
    int size = 0;
    
    int j = 0;
    
    //encontre as repetições
    for(int i=0;i<n;i+=2){
       repeats[j] = rleData[i];
       size += repeats[j];
       j++;
    }
    
    j=0;

    //encontre os números que devem ser repetidos
    for(int i=1;i<n;i+=2){
       data2[j] = rleData[i];
       j++;
    }
	
	//crie uma nova array para armazenar os dados decodificados
	byte decode[] = new byte[size];
	
	int l=0;
	
	//decodificar os dados
	//use dois loops para
	for (int i=0;i<n/2;i++){
	    for(byte k=0;k<repeats[i];k++){
	        decode[l] = data2[i];
	        l++;
	    }
	}
	
	//retornar a array de decodificação
	return decode;
  }

}
