package my.edu.tarc.user.smartplat;

public class Product{
    private String productId;
    private String ProductName;
    private String ProductDes;
    private String ProductImagePath;



    public Product(String productId, String productName, String productDes, String productImagePath) {
        this.productId = productId;
        this.ProductName = productName;
        this.ProductDes = productDes;
        this.ProductImagePath = productImagePath;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDes() {
        return ProductDes;
    }

    public void setProductDes(String productDes) {
        ProductDes = productDes;
    }

    public String getProductImagePath() {
        return ProductImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        ProductImagePath = productImagePath;
    }
}
