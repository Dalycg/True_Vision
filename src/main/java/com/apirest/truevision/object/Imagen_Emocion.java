package com.apirest.truevision.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Imagen_Emocion {

    @JsonProperty(value = "Classifier")
    private String Classifier;

    @JsonProperty(value = "Emotion")
    private String Emotion;

    public Imagen_Emocion() {
    }

    public String getClassifier() {
        return Classifier;
    }

    public void setClassifier(String Classifier) {
        this.Classifier = Classifier;
    }

    public String getEmotion() {
        return Emotion;
    }

    public void setEmotion(String Emotion) {
        this.Emotion = Emotion;
    }

    @Override
    public String toString() {
        return "Imagen_Emotion{" + "Classifier: " + Classifier + ", Emotion: " + Emotion + "}";
    }

}