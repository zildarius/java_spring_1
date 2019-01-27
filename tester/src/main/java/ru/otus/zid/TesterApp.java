package ru.otus.zid;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.zid.service.QuestionRunnerService;
import ru.otus.zid.service.QuestionRunnerServiceImpl;

public class TesterApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/context.xml");
        QuestionRunnerService questionRunnerService = context.getBean(QuestionRunnerServiceImpl.class);
        try {
            questionRunnerService.runTest();
        } catch (Exception e) {
            System.out.println("Something is went wrong:\n");
            e.printStackTrace();
        }
    }
}
