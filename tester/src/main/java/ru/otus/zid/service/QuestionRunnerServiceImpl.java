package ru.otus.zid.service;

import ru.otus.zid.dao.QuestionDAO;
import ru.otus.zid.model.Question;
import ru.otus.zid.model.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.List;

public class QuestionRunnerServiceImpl implements QuestionRunnerService {

    private QuestionDAO questionDAO;
    BufferedReader reader;

    public QuestionRunnerServiceImpl(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void runTest() throws IOException, URISyntaxException {
        System.out.println("Please enter your surname and name:");
        String fio = reader.readLine();
        Result result = new Result(fio);

        System.out.println("Test is beginning!");
        List<Question> questions = questionDAO.getQuestions();
        for (Question question : questions) {
            System.out.println(
                    String.format("%s. %s\nYour answer:", question.getId(), question.getQuestion()));
            String answer = reader.readLine();
            boolean isAnswerCorrect = answer.equalsIgnoreCase(question.getAnswer());
            result.addUserAnswer(question.getId(), answer, isAnswerCorrect);
        }

        System.out.println(result.toString());
    }

}
