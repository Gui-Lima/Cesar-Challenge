package com.example.ggfl.emailreciever;

public class Email {
    String content;
    String body;
    Email reply;

    Email(String content, String body){
        this.content = content;
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Email){
            return ((Email) o).body.equals(this.body) && ((Email) o).content.equals(this.content);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Content :" + content + '\n' + "Body: " + body;
    }

    @Override
    public int hashCode() {
        return body.hashCode() + content.hashCode();
    }

    public Email getReply(){
        return this.reply;
    }

    public void setReply(Email reply){
        this.reply = reply;
    }
}
