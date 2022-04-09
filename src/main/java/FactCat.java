public class FactCat {
    private final String id;
    private final String text;
    private final String type;
    private final String user;
    private final Integer upvotes;

    public FactCat(String id, String text, String type, String user, Integer upvotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' + "\n" +
                "text='" + text + '\'' + "\n" +
                "type='" + type + '\'' + "\n" +
                "user='" + user + '\'' + "\n" +
                "upvotes='" + upvotes + '\'' + "\n";
    }
}
