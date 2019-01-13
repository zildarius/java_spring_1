package ru.otus.zid.dao;

import ru.otus.zid.model.Question;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDAO {

    private String questionsCsvFilePath;
    private String SEPARATOR;

    public void setQuestionsCsvFilePath(String questionsCsvFilePath) {
        this.questionsCsvFilePath = questionsCsvFilePath;
    }

    public void setSEPARATOR(String SEPARATOR) {
        this.SEPARATOR = SEPARATOR;
    }

    public List<Question> getQuestions() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        Path path = Paths.get(
                classLoader.getResource(questionsCsvFilePath).toURI());

        List<String> questionsStrings = Files.readAllLines(path);

        List<Question> questions = questionsStrings.stream()
                .map(x -> new Question(x.split(SEPARATOR)))
                .collect(Collectors.toList());

        return questions;
    }
}
