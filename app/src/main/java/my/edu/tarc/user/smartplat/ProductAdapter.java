package my.edu.tarc.user.smartplat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;


    public ProductAdapter(Context context, List<Product> list) {
        this.context = context;
        this.productList = list;
    }
    /*

    public ProductAdapter(Context context, int resource, List<Product> list) {
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

*/


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.product_fragment, parent, false);
        return new ProductViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.textViewProductImage.setText(String.format("%s : %s","productImagePath",product.getProductImagePath()));
        holder.textViewProduct.setText(String.format("%s : %s","productId",product.getProductId()));
        holder.textViewProductName.setText(String.format("%s : %s","productName",product.getProductName()));
        holder.textViewProductDes.setText(String.format("%s : %s","productDes",product.getProductDes()));


    }


    @Override
    public int getItemCount() {
        return 0;
    }



    class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView textViewProductImage, textViewProduct, textViewProductName,textViewProductDes;
        RelativeLayout container;
        public ProductViewHolder(@NonNull View itemView){
            super(itemView);
            textViewProductImage = itemView.findViewById(R.id.imageView);
            textViewProduct = itemView.findViewById(R.id.textViewProductId);
            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            textViewProductDes = itemView.findViewById(R.id.textViewProductDescription);
            //container=itemView.findViewById(R.id.con)
        }
    }
}
