package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

// Format dans le fichier 'f' : Titre / sous-titre / timecode / date de réalisation
    public static void main(String[] args) {
      File f = new File("films.txt");
      System.out.println("Fichier lu: "+f.getAbsolutePath());

        try {
           
            InputStream ips = new FileInputStream(f);
            InputStreamReader ipsr=new InputStreamReader(ips);
            
            BufferedReader br=new BufferedReader(ipsr);
            String ligne; 
            while ((ligne=br.readLine())!=null)
            { 
                String[] parts = ligne.split(";");
                String[] parts2 = parts[2].split(":");
                System.out.println("Titre: "+parts[0]+" / Sous-titre: "+parts[1]+" / Timecode: "+parts2[0]+ " minutes et "+parts2[1]+" secondes / Date de réalisation: "+parts[3]); 
                
                }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
        }

    }
}
