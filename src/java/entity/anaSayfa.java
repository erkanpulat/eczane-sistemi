
package entity;


public class anaSayfa {
    
    private int id;
    private String title;
    private String subtitle;
    private String content;

    public anaSayfa() {
    }

    public anaSayfa(int id, String title, String subtitle, String content) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    
}
