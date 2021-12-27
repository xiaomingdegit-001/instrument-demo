package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

/**
 * @author yousj
 * @link https://juejin.cn/post/6844903614087954439
 * @since 2021-12-27
 */
public class AgentApplication {

    private static final String filename = "E:\\workspace\\stu\\instrumentdemo\\agentdemo\\src\\test\\Test.class";

    public static void agentmain(String agentArgs, Instrumentation inst) throws Exception {
        System.out.println("agent startup ......");
        Class<?>[] classes = inst.getAllLoadedClasses();
        for (Class<?> cls : classes) {
            if (cls.getName().equals("demo.Test")) {
                ClassDefinition classDefinition = new ClassDefinition(cls, getBytes(filename));
                inst.redefineClasses(classDefinition);
            }
        }
    }

    public static byte[] getBytes(String filename) throws Exception {
        File file = new File(filename);
        InputStream is = new FileInputStream(file);
        long length = file.length();
        byte[] bytes = new byte[(int) length];

        // Read in the bytes
        int offset = 0;
        int numRead;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "
                    + file.getName());
        }
        is.close();
        return bytes;
    }

}
