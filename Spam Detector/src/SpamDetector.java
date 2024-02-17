public class SpamDetector {

    public SpamType[] detectSpams(Message[] messages) {
        SpamType[] st = new SpamType[messages.length];

        for (int i = 0; i < messages.length; i++) {
            if (messages[i].getContent().contains(SpamType))
        }

        return st;
    }

}