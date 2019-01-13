package ru.otus.zid.model;

public class Question {

    private String id;
    private String question;
    private String answer;

    public Question(String... args) {
        this.id = args[0];
        this.question = args[1];
        this.answer = args[2];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
