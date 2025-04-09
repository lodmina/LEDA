package modelo;

public class Tweet {
    private String target, id, date, flag, user, text, mentionedPerson;
    private int mentionedPersonCount;

    public Tweet(String target, String id, String date, String flag, String user,
                 String text, String mentionedPerson, int mentionedPersonCount) {
        this.target = target;
        this.id = id;
        this.date = date;
        this.flag = flag;
        this.user = user;
        this.text = text;
        this.mentionedPerson = mentionedPerson;
        this.mentionedPersonCount = mentionedPersonCount;
    }

    public String getTarget() { return target; }
    public String getId() { return id; }
    public String getDate() { return date; }
    public String getFlag() { return flag; }
    public String getUser() { return user; }
    public String getText() { return text; }
    public String getMentionedPerson() { return mentionedPerson; }
    public int getMentionedPersonCount() { return mentionedPersonCount; }

    public String getDateOrdenavel() {
        String[] partes = date.split("/"); //12/05/2025
        return partes[2] + partes[1] + partes[0]; //12052025
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "target='" + target + '\'' +
                ", id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", flag='" + flag + '\'' +
                ", user='" + user + '\'' +
                ", text='" + text + '\'' +
                ", mentionedPerson='" + mentionedPerson + '\'' +
                ", mentionedPersonCount=" + mentionedPersonCount +
                '}';
    }
}


