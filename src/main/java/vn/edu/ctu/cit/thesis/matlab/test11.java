package vn.edu.ctu.cit.thesis.matlab;


import com.mathworks.toolbox.javabuilder.MWException;

public class test11 {
    public static void main(String[] args) {

         String file = "C:/Users/Asus/Desktop/Newfolder/du lieu da phan loai/testdata/0-duoi nhen/13-I220 (4)";
        try {
            WaveletData data = WaveletExtraction.getInstance().extract(file);
            System.out.println(data.toJson());
        } catch (MWException e) {
            e.printStackTrace();
        }
//        try {
//            Object[] a= WaveletExtraction.getInstance().testExtrack(file);
//            String[] aa= a[0].toString().trim().replaceAll("\\s+"," ").replaceAll("\\r\\n"," ").split(" ");
//            for(String e:aa){
//                System.out.println(e.trim());
//            }
//            System.out.println("------------");
//            System.out.println(aa[4]);
//        } catch (MWException e) {
//            e.printStackTrace();
//        }


    }
}
