package ru.otus.zid.dao;

import ru.otus.zid.model.Question;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface QuestionDAO {
    void setQuestionsCsvFilePath(String questionsCsvFilePath);

    void setSeparator(String separator);

    List<Question> getQuestions() throws IOException, URISyntaxException;
}
