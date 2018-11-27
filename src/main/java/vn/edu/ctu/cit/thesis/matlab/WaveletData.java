package vn.edu.ctu.cit.thesis.matlab;

import com.google.gson.Gson;

public class WaveletData {
    private String filename;
    private float ContrastV2;
    private float CorrelationV2;
    private float EnergyV2;
    private float HomogeneityV2;
    private float EntropyV2;
    private float ContrastH2;
    private float CorrelationH2;
    private float EnergyH2;
    private float HomogeneityH2;
    private float EntropyH2;
    private int Label;

    public int getLabel() {
        return Label;
    }

    public void setLabel(int label) {
        Label = label;
    }

    public WaveletData() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public float getContrastV2() {
        return ContrastV2;
    }

    public void setContrastV2(float contrastV2) {
        ContrastV2 = contrastV2;
    }

    public float getCorrelationV2() {
        return CorrelationV2;
    }

    public void setCorrelationV2(float correlationV2) {
        CorrelationV2 = correlationV2;
    }

    public float getEnergyV2() {
        return EnergyV2;
    }

    public void setEnergyV2(float energyV2) {
        EnergyV2 = energyV2;
    }

    public float getHomogeneityV2() {
        return HomogeneityV2;
    }

    public void setHomogeneityV2(float homogeneityV2) {
        HomogeneityV2 = homogeneityV2;
    }

    public float getEntropyV2() {
        return EntropyV2;
    }

    public void setEntropyV2(float entropyV2) {
        EntropyV2 = entropyV2;
    }

    public float getContrastH2() {
        return ContrastH2;
    }

    public void setContrastH2(float contrastH2) {
        ContrastH2 = contrastH2;
    }

    public float getCorrelationH2() {
        return CorrelationH2;
    }

    public void setCorrelationH2(float correlationH2) {
        CorrelationH2 = correlationH2;
    }

    public float getEnergyH2() {
        return EnergyH2;
    }

    public void setEnergyH2(float energyH2) {
        EnergyH2 = energyH2;
    }

    public float getHomogeneityH2() {
        return HomogeneityH2;
    }

    public void setHomogeneityH2(float homogeneityH2) {
        HomogeneityH2 = homogeneityH2;
    }

    public float getEntropyH2() {
        return EntropyH2;
    }

    public void setEntropyH2(float entropyH2) {
        EntropyH2 = entropyH2;
    }
    public String toJson(){
        return new Gson().toJson(this);
    }
}
