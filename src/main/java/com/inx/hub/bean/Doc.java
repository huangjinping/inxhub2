package com.inx.hub.bean;

public class Doc {

    private String type;
    private String word;
    private String sent;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "type='" + type + '\'' +
                ", word='" + word + '\'' +
                ", sent='" + sent + '\'' +
                '}';
    }
}
