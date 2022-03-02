package aplicativo;

import java.util.Scanner;
import entidades.Produto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Aplicativo {
    public static void main(String[] args) throws IOException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Produto> lista = new ArrayList<>();
        
        System.out.println("Entre com o caminho para criar o arquivo txt: ");
        String caminho = sc.nextLine();
        
        System.out.print("Quantos produtos deseja cadastrar ? ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Inserir da seguinte forma (respeitando a vírgula)");
        for(int i = 0; i < n; i++){
            
            System.out.println("Nome,preço,quantidade: ");
            String atributos = sc.nextLine();
            String[] vet = atributos.split(",");
            lista.add(new Produto(vet[0], Double.parseDouble(vet[1]), Integer.parseInt(vet[2])));
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))){
            for(Produto p : lista){
                bw.write(p.toString());
                bw.newLine();
            }
        }
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        finally{
            if(sc != null){
                sc.close();
            }
        }
        
        
       
    }
    
}
