package testHutool;

import cn.hutool.extra.mail.MailUtil;
import org.junit.Test;

public class TestSendMaill {

    @Test
    public void testSend(){
        MailUtil.send("xiechengyu5@163.com", "测试发送邮件",
                "邮件来自Hutool测试xcy1", false);
    }
}
