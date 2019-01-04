package my.edu.tarc.user.smartplat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<ProductFragment> {

    public ProductAdapter(Activity context,int resource,List<ProductFragment> list) {
        super(context,resource,list);
    }

    public View getView(int position,View convertView,ViewGroup parent){
        ProductFragment product =getItem(position);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView=inflater.inflate(R.layout.product_fragment,parent,false);

        TextView productID,productName,productDes,productImagePath;

        productID=rowView.findViewById(R.id.productID);
        productName=rowView.findViewById(R.id.productName);
        productDes=rowView.findViewById(R.id.productDes);
        productImagePath=rowView.findViewById(R.id.productImagePath);

        productID.setText(String.format("%s : %s","productId",Product.getProductId());
        productName.setText(String.format("%s : %s","productName",Product.getProductName()));
        productID.setText(String.format("%s : %s","productId",product.getProductDes()));
        productID.setText(String.format("%s : %s","productId",product.getId()));



    }
}
