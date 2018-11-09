package org.redmaplesoft.akka.practise1;

import java.io.Serializable;

/**
 * @author Max Yu
 * @version 创建时间：2018/11/9 14:59
 */
public class CommonMsg implements Serializable
{
    private String title = "";
    private String Content = "";

    public CommonMsg(String title, String content) {
        this.title = title;
        Content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
