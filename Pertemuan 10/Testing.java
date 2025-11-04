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