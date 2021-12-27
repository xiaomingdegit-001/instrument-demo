import com.sun.tools.attach.VirtualMachine;

/**
 * @author yousj
 * @since 2021-12-27
 */
public class AttachMain {

    public static void main(String[] args) throws Exception{
        VirtualMachine attach = VirtualMachine.attach("24476");
        attach.loadAgent("E:\\workspace\\stu\\instrumentdemo\\agentdemo\\target\\agentdemo-1.0.jar");
    }
}
