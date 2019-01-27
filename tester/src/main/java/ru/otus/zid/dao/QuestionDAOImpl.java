package ru.otus.zid.dao;

import ru.otus.zid.model.Question;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDAOImpl implements QuestionDAO {

    private String questionsCsvFilePath;
    private String separator;

    @Override
    public void setQuestionsCsvFilePath(String questionsCsvFilePath) {
        this.questionsCsvFilePath = questionsCsvFilePath;
    }

    @Override
    public void setSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public List<Question> getQuestions() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        Path path = Paths.get(
                classLoader.getResource(questionsCsvFilePath).toURI());

        List<String> questionsStrings = Files.readAllLines(path);

        List<Question> questions = questionsStrings.stream()
                .filter(x -> x.split(separator).length == 3)
                .map(x -> new Question(x.split(separator)))
                .collect(Collectors.toList());

        return questions;
    }
}
