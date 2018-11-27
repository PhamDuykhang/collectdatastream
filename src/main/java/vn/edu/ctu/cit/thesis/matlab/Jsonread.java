package vn.edu.ctu.cit.thesis.matlab;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jsonread {
    public static void main (String[] ar){
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("data/dicomwithoutlabel.json"));
            br.lines().forEach(line->{
                System.out.println(line);
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
