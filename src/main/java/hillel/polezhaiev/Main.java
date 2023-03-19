package hillel.polezhaiev;


import hillel.testrunner.TestResultParser;
import hillel.testrunner.ProjectTestRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        ProjectTestRunner testRunner = new ProjectTestRunner();

        testRunner.doTestByClassName("hillel.polezhaiev.SimpleMathLibrary");
        testRunner.doTestByClass(SimpleMathLibrary.class);
        testRunner.doTestByClassesNames("hillel.polezhaiev.SimpleMathLibrary");
        testRunner.doTestByClassNames(SimpleMathLibrary.class);
        testRunner.doTestByPackageName("hillel.polezhaiev");

        TestResultParser testResultParser = new TestResultParser();

        File file = new File("testinform.txt");

        if(!file.exists()){
            file.createNewFile();
        }

        TestResult testResultByFileName = testResultParser.parseByFileName("testinform.txt");
        TestResult testResultByFile = testResultParser.parseByFile(file);
        TestResult testResultByFilePath = testResultParser.parseByFilePath(Path.of(file.getPath()));

        testResultByFileName.setLocalDateTime(testRunner.getLocalDateTime());
        testResultByFile.setLocalDateTime(testRunner.getLocalDateTime());
        testResultByFilePath.setLocalDateTime(testRunner.getLocalDateTime());

        System.out.println(testResultByFileName);
        System.out.println(testResultByFile);
        System.out.println(testResultByFilePath);


    }
}