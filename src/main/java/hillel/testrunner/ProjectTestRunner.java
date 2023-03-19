package hillel.testrunner;

import org.junit.platform.console.ConsoleLauncher;

import java.io.*;
import java.time.LocalDateTime;

public class ProjectTestRunner {

    private LocalDateTime localDateTime;

    public ProjectTestRunner() {
        localDateTime = LocalDateTime.now();
    }

    private File file = new File("testinform.txt");
    public void doTestByClassName(String className){
        if(className.length() == 0 || className == null){
            return;
        }

        try(FileWriter writer = new FileWriter(file, true)) {
            if(!file.exists()){
                file.createNewFile();
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);

            ConsoleLauncher.execute(printStream, printStream, "-c " + className);

            String result = byteArrayOutputStream.toString();
            writer.write(result + "Date: " + LocalDateTime.now() + ";\n" + "===========" + "\n");

            System.out.println(result);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doTestByClass(Class class1){
        if(class1 == null){
            return;
        }

        try(FileWriter writer = new FileWriter(file, true)) {
            if(!file.exists()){
                file.createNewFile();
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);

            ConsoleLauncher.execute(printStream, printStream, "-c " + class1.getName());

            String result = byteArrayOutputStream.toString();
            writer.write(result + "Date: " + LocalDateTime.now() + ";\n" + "===========" + "\n");

            System.out.println(result);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doTestByClassesNames(String ... classes){
        if(classes.length == 0 || classes == null){
            return;
        }
        try(FileWriter writer = new FileWriter(file, true)) {
            if(!file.exists()){
                file.createNewFile();
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);

            for (String name: classes) {
                ConsoleLauncher.execute(printStream, printStream, "-c " + name);
            }


            String result = byteArrayOutputStream.toString();
            writer.write(result + "Date: " + LocalDateTime.now() + ";\n" + "===========" + "\n");

            System.out.println(result);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doTestByClassNames(Class ... classes){
        if(classes == null){
            return;
        }

        try(FileWriter writer = new FileWriter(file, true)) {
            if(!file.exists()){
                file.createNewFile();
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);

            for (Class name: classes) {
                ConsoleLauncher.execute(printStream, printStream, String.format("-c " + name.getName()));
            }

            String result = byteArrayOutputStream.toString();
            writer.write(result + "Date: " + LocalDateTime.now() + ";\n" + "===========" + "\n");

            System.out.println(result);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doTestByPackageName(String packageName){
        if(packageName.length() == 0 || packageName == null){
            return;
        }

        try(FileWriter writer = new FileWriter(file, true)) {
            if(!file.exists()){
                file.createNewFile();
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);

            ConsoleLauncher.execute(printStream, printStream, String.format("-p " + packageName));

            String result = byteArrayOutputStream.toString();
            writer.write(result + "Date: " + LocalDateTime.now() + ";\n" + "===========" + "\n");

            System.out.println(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
