# Source Code

### SalesItem.java
```java
import java.util.ArrayList;


public class SalesItem
{
    private String name;
    private int price;
    private ArrayList<Comment> comments;
    

    public SalesItem(String name, int price)
    {
        this.name = name;
        this.price = price;
        comments = new ArrayList<Comment>();
    }

    public boolean addComment(String author, String text, int rating)
    {
        if(rating < 1 || rating > 5) {
            return false;
        }
        for(Comment comment : comments) {
            if(comment.getAuthor().equals(author)) {
                return false;
            }
        }
        Comment newComment = new Comment(author, text, rating);
        comments.add(newComment);
        return true;
    }

    public boolean removeComment(Comment comment)
    {
        return comments.remove(comment);
    }

    public int getNumberOfComments()
    {
        return comments.size();
    }

    public void showInfo()
    {
        System.out.println("=================================");
        System.out.println("Item: " + name);
        System.out.println("Price: " + price);
        System.out.println("Number of comments: " + getNumberOfComments());
        for(Comment comment : comments) {
            comment.print();
            System.out.println();
        }
    }

    public Comment findMostHelpfulComment()
    {
        if(comments.isEmpty()) {
            return null;
        }
        Comment best = comments.get(0);
        for(Comment current : comments) {
            if(current.getVoteBalance() > best.getVoteBalance()) {
                best = current;

            }
        }
        return best;
    }
}
```

### Comment
```java
public class Comment
{
    private String author;
    private String text;
    private int rating;
    private int upvotes;
    private int downvotes;
    

    public Comment(String author, String text, int rating)
    {
        this.author = author;
        this.text = text;
        this.rating = rating;
        upvotes = 0;
        downvotes = 0;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public void upvote()
    {
        upvotes++;
    }

    public void downvote()
    {
        downvotes++;
    }

    public int getVoteBalance()
    {
        return upvotes - downvotes;
    }

    public void print()
    {
        System.out.println("Author: " + author);
        System.out.println("Rating: " + rating);
        System.out.println("Comment: " + text);
        System.out.println("Votes: " + getVoteBalance());
    }
}
```

### Testing.java
```java
public class Testing
{
    public static void main(String[] args) {
        System.out.println("Test 1");
        SalesItem mouse = new SalesItem("Wireless Mouse", 100000);
        System.out.println("DEBUG: Jumlah komen: " + mouse.getNumberOfComments());
        System.out.println("DEBUG: lyudmilla memberikan komen");
        mouse.addComment("Lyudmila", "Mouse nya bagus", 4);
        System.out.println("DEBUG: Jumlah komen: " + mouse.getNumberOfComments());
        System.out.println("DEBUG: Fiona Young memberikan komen");
        mouse.addComment("Fiona Young", "Pengiriman lambat", 2);
        System.out.println("DEBUG: Joyce Moore memberikan komen");
        mouse.addComment("Joyce Moore", "Mouse yang sangat bagus, latensi rendah dan sensitivitas bisa di atur. worth it untuk harganya", 4);
        mouse.showInfo();
        mouse.findMostHelpfulComment().print();
        System.out.println();
        
        System.out.println("Test 2");
        System.out.println("DEBUG: Margaret Nearl memberikan komen");
        Comment komen1 = new Comment("Margaret Nearl", "Earphonya bagus", 5);
        System.out.println("DEBUG: umlah vote: " + komen1.getVoteBalance());
        komen1.upvote();
        System.out.println("DEBUG: Komen Margaret Nearl mendapat upvote");
        System.out.println("DEBUG: Jumlah vote: " + komen1.getVoteBalance());
        System.out.println("DEBUG: Komen Margaret Nearl mendapat downvote");
        komen1.downvote();
        komen1.print();
        System.out.println();
        
        
        System.out.println("Test 3");
        SalesItem tws = new SalesItem("TWS",200000);
        Comment komen2 = new Comment("Frederico", "TWS nya mati sebelah", 1);
        System.out.println("DEBUG: Jumlah komen: " + tws.getNumberOfComments());
        System.out.println("DEBUG: Frederico memberikan komen");
        tws.addComment(komen2.getAuthor(), "TWS nya mati sebelah", 1);
        System.out.println("DEBUG: Jumlah komen: " + tws.getNumberOfComments());
        tws.removeComment(komen2);
        System.out.println("DEBUG: Komen dihapus");
        System.out.println("DEBUG: Jumlah komen: " + tws.getNumberOfComments());
        
    }
}
```
