package ru.otus.zid.model;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private String userFIO;
    private int rightAnswerCount = 0;
    private List<UserAnswer> userAnswers = new ArrayList<>();

    public Result(String userFIO) {
        this.userFIO = userFIO;
    }

    public void addUserAnswer(String questionId, String userAnswer, boolean isAnswerRight) {
        this.userAnswers.add(new UserAnswer(questionId, userAnswer, isAnswerRight));
        if (isAnswerRight) { rightAnswerCount++; }
    }

    @Override
    public String toString() {
        return "\n_______________________________________________________\n" +
                "Result: " +
                "userFIO: " + userFIO + "\n" +
                "total right answers: " + rightAnswerCount + "\n" +
                "total answers count: " + userAnswers.size() + "\n" +
                "userAnswers:\n\n" + userAnswers;
    }

    private class UserAnswer {
        String questionId;
        String userAnswer;
        Boolean isAnswerRight;

        @Override
        public String toString() {
            return "\n  questionId: " + questionId + "\n" +
                    "  userAnswer: " + userAnswer + "\n" +
                    "  isAnswerRight: " + isAnswerRight + "\n";
        }

        public UserAnswer(String questionId, String userAnswer, Boolean isAnswerRight) {
            this.questionId = questionId;
            this.userAnswer = userAnswer;
            this.isAnswerRight = isAnswerRight;
        }

        public String getQuestionId() {
            return questionId;
        }

        public void setQuestionId(String questionId) {
            this.questionId = questionId;
        }

        public String getUserAnswer() {
            return userAnswer;
        }

        public void setUserAnswer(String userAnswer) {
            this.userAnswer = userAnswer;
        }

        public Boolean getAnswerRight() {
            return isAnswerRight;
        }

        public void setAnswerRight(Boolean answerRight) {
            isAnswerRight = answerRight;
        }
    }
}
