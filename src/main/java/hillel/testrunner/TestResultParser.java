package hillel.testrunner;

import hillel.polezhaiev.TestResult;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestResultParser {
    public TestResult parseByFileName(String fileName){
        if(fileName == null || fileName.length() == 0){
            return null;
        }

        try (Reader reader = new FileReader(fileName)){
            BufferedReader bufferedReader = new BufferedReader(reader);

            return findInfoFromFile(bufferedReader);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TestResult parseByFile(File file){
        if(file == null || file.length() == 0){
            return null;
        }

        try (Reader reader = new FileReader(file)){
            BufferedReader bufferedReader = new BufferedReader(reader);

            return findInfoFromFile(bufferedReader);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TestResult parseByFilePath(Path filePath){
        if(filePath == null){
            return null;
        }

        try (Reader reader = new FileReader(Paths.get(filePath.toString()).toFile())){
            BufferedReader bufferedReader = new BufferedReader(reader);

            return findInfoFromFile(bufferedReader);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TestResult findInfoFromFile(BufferedReader bufferedReader) throws IOException {
        if(bufferedReader == null){
            return null;
        }

        int failed = 0;
        int success = 0;
        int amount = 0;
//        String localDateTime = null;

        String currentString;

        while((currentString = bufferedReader.readLine()) != null){

            if(currentString != null && currentString.contains("tests failed")){
                Pattern pat= Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                Matcher matcher=pat.matcher(currentString);

                while (matcher.find()) {
                    String res = matcher.group();
                    failed += Integer.parseInt(res);
                    ++amount;
                };

            } else if(currentString != null && currentString.contains("tests successful")) {
                Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                Matcher matcher = pat.matcher(currentString);

                while (matcher.find()) {
                    String res = matcher.group();
                    success += Integer.parseInt(res);
                    ++amount;
                }
            }
//            } else if (currentString != null && currentString.contains("Date:") && currentString != null) {
//                localDateTime = currentString.substring(currentString.indexOf(':') + 2, currentString.indexOf(';'));
//            }
        }
        int amountRes = amount / 2;

        TestResult testResult = new TestResult();
        testResult.setAmount(amountRes);
        testResult.setFailed(failed);
//        testResult.setLocalDateTime(localDateTime);
        testResult.setSuccess(success);

        return testResult;

    }

}
