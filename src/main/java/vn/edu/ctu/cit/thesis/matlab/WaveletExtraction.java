package vn.edu.ctu.cit.thesis.matlab;




import WaveletExtraction2jpg.WaveletEtraction;
import com.mathworks.toolbox.javabuilder.MWException;
import vn.edu.ctu.cit.thesis.kafka.kafkautils.DirUtils;

import java.util.Objects;

public class WaveletExtraction {
    private WaveletEtraction  waveletExtract;
    private Object[] result;
    private static WaveletExtraction instance;
    private WaveletExtraction() throws MWException {
        waveletExtract = new WaveletEtraction();
        result =null;
    }
    public static synchronized WaveletExtraction getInstance() throws MWException {
        if(Objects.isNull(instance)){
            instance = new WaveletExtraction();
        }
        return instance;
    }
    public Object[] testExtrack(String file){
        try {
            result = this.waveletExtract.WaveletExtraction2jpg(1,file);
        } catch (MWException e) {
            e.printStackTrace();
        }
        return result;
    }
    public WaveletData extract(String filename){
        try {
            result = this.waveletExtract.WaveletExtraction2jpg(1,filename);
        } catch (MWException e) {
            e.printStackTrace();
        }
        ResultUtils util = new ResultUtils();
       return util.WaveletNomalizeResult(DirUtils.getFileNameFormPatch(filename),result).toWaveletData();
    }
}
