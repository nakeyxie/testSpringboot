package testHutool;

import cn.hutool.extra.mail.MailUtil;
import org.junit.Test;

public class TestSendMaill {

    @Test
    public void testSend(){
        MailUtil.send("644100976@qq.com", "测试发送邮件",
                "邮件来自Hutool测试xcy1", false);
    }
}
