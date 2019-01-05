package my.edu.tarc.user.smartplat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    public ProductAdapter(Activity context, int resource, List<Product> list) {
        super(context, resource, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);

        LayoutInflater inflater  = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.product_fragment, parent, false);

        TextView textViewProductImage, textViewProduct, textViewProductName,textViewProductDes;

        textViewProductImage = rowView.findViewById(R.id.imageView);
        textViewProduct = rowView.findViewById(R.id.textViewProductId);
        textViewProductName = rowView.findViewById(R.id.textViewProductName);
        textViewProductDes = rowView.findViewById(R.id.textViewProductDescription);

        textViewProductImage.setText(String.format("%s : %s","productImagePath",product.getProductImagePath()));
        textViewProduct.setText(String.format("%s : %s","productId",product.getProductId()));
        textViewProductName.setText(String.format("%s : %s","productName",product.getProductName()));
        textViewProductDes.setText(String.format("%s : %s","productDes",product.getProductDes()));
        return rowView;
    }
}
