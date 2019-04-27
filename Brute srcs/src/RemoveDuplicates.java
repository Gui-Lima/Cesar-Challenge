import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RemoveDuplicates {

    private static class Message{
        String content;
        String body;
        Message reply;

        Message(String content, String body){
            this.content = content;
            this.body = body;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Message){
                return ((Message) o).body.equals(this.body) && ((Message) o).content.equals(this.content);
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

        public Message getReply(){
            return this.reply;
        }

        public void setReply(Message reply){
            this.reply = reply;
        }
    }

    public static void main(String[] args){
        Message m1 = new Message("New Products", "Check out these new products from our company");
        Message m2 = new Message("Answer", "No thanks");
        Message m3 = new Message("New Products", "Check out these new products from our company");
        Message m4 = new Message("Answer", "No thanks");
        m1.setReply(m2);
        m2.setReply(m3);
        m3.setReply(m4);
        m4.setReply(null);

        removeDups(m1);
    }

    private static void removeDups(Message threadHead){
        Map<Message, Integer> dictonary = new HashMap<>();

        if(threadHead == null) return;

        Message next = threadHead.reply;
        Message previous = threadHead;
        dictonary.put(threadHead, 0);

        while(next != null){

            if(dictonary.containsKey(next)){
                previous.reply = next.reply;
            }
            else{
                dictonary.put(next, 0);
                previous = previous.reply;
            }
            next = next.reply;
        }
    }
}
