import java.util.HashMap;
import java.util.Map;

public class IntersectingNode {

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
        Message m3 = new Message("You sure?", "Then check out these more awesome offers");
        Message m4 = new Message("Really?", "I said no thanks");
        m1.setReply(m2);
        m2.setReply(m3);
        m3.setReply(m4);
        m4.setReply(null);

        Message m5 = new Message("Check out this offers", "<HEAD> IDK </HEAD>");
        Message m6 = new Message("Oh god", "Please stop");

        m5.setReply(m6);
        m6.setReply(m3);

        intersection(m1,  m5); // this returns m3
    }


    private static Message intersection(Message headList1, Message headList2){
        Map<Message, Integer> dictionary = new HashMap<>();

        while(headList1 != null){
            dictionary.put(headList1, 1);
            headList1 = headList1.reply;
        }

        while(headList2 != null){
            if (dictionary.containsKey(headList2)){
                return headList2;
            }
            headList2 = headList2.reply;
        }
        return null;
    }
}
