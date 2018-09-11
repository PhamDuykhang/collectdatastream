package vn.edu.ctu.cit.thesis.matlab;




import DetectBrainHemorrhage.BrainHemorrhageDetection;
import com.mathworks.toolbox.javabuilder.MWException;



import java.time.LocalTime;

public class test {
    public static void main(String[] args) {
        System.out.println("buoc 1");
        BrainHemorrhageDetection mat;
        System.out.println("Buoc 1 hoan thanh tai "+LocalTime.now().toString());
        System.out.println("buoc 2");
        String patchfile= "C:/Users/Asus/Desktop/Newfolder/7-I320_2";
//        MWCharArray path = new MWCharArray("C:/Users/Asus/Desktop/Newfolder/7-I320_2");
        System.out.println("Buoc 2 hoan thanh tai "+LocalTime.now().toString());
        System.out.println("buoc 3");
        Object[] res = null;
        System.out.println("Buoc 3 hoan thanh tai "+LocalTime.now().toString());
        System.out.println("buoc 4");
        try{
            mat = new BrainHemorrhageDetection();
            System.out.println("Buoc 4 hoan thanh tai "+LocalTime.now().toString());
            System.out.println("buoc 5");
            res = mat.detectBrainHemorrhage(2, patchfile);
            System.out.println("Buoc 5 hoan thanh tai "+LocalTime.now().toString());
            System.out.println("chay xong pt");
            System.out.println(res[0]);
            System.out.println("--------------------");
            System.out.println(res[1]);
            String info = res[0].toString();
            String[] infoarr= info.split(":");
            for(String element:infoarr){
                System.out.println(element);
            }

//            System.out.println(res[0].toString());
//            Integer rescalScope = Integer.valueOf(a[0].toString());
//            Integer height = Integer.valueOf(a[1].toString());
//            Integer with = Integer.valueOf(a[2].toString());
//            System.out.println("rescalScope : "+rescalScope);
//            System.out.println("height : "+height);
//            System.out.println("with : "+ with);
        }catch (MWException e){
            System.out.println("Loi");
            e.printStackTrace();
        }


    }
}
