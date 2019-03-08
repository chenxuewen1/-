package a.bw.com.chenxuewen0308.bean;

/*Time:2019/3/8
 *Author:chenxuewen
 *Description:
 */
public class ComList {
    private String price;
    private String images;
    private String title;

    public ComList() {
        super();
    }

    @Override
    public String toString() {
        return "ComList{" +
                "price='" + price + '\'' +
                ", images='" + images + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ComList(String price, String images, String title) {
        this.price = price;
        this.images = images;
        this.title = title;
    }
}
