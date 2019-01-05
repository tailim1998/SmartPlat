package my.edu.tarc.user.smartplat;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static my.edu.tarc.user.smartplat.Constants.URL_PRODUCT;

public class ProductFragment extends AppCompatActivity {
    public static final String TAG = "my.edu.tarc.lab44";
    RecyclerView ProductRecycleView;
    List<Product> ProductList = new ArrayList<>();
    private ProgressDialog pDialog;
    //TODO: Please update the URL to point to your own server
    private static String GET_URL = URL_PRODUCT;
    RequestQueue queue;

    @Nullable

    public void onCreate(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*
        downloadProduct(getApplicationContext(), GET_URL);
        return inflater.inflate(R.layout.product_fragment,container,false);

        */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_fragment);
        downloadProduct(this,GET_URL);
    }


    private void downloadProduct(Context context, String url) {
        // Instantiate the RequestQueue
        queue = Volley.newRequestQueue(context);

        if (!pDialog.isShowing())
            pDialog.setMessage("Syn with server...");
        pDialog.show();

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            ProductList.clear();
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject productResponse = (JSONObject) response.get(i);
                                String productId = productResponse.getString("productID");
                                String productName = productResponse.getString("productName");
                                String productDes = productResponse.getString("productDes");
                                String productImagePath = productResponse.getString("productImagePath");
                                Product product = new Product(productId, productName, productDes,productImagePath);
                                ProductList.add(product);
                            }
                            loadProduct();
                            if (pDialog.isShowing())
                                pDialog.dismiss();
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error:" + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getApplicationContext(), "Error" + volleyError.getMessage(), Toast.LENGTH_LONG).show();
                        if (pDialog.isShowing())
                            pDialog.dismiss();
                    }
                });

        // Set the tag on the request.
        jsonObjectRequest.setTag(TAG);

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
    }

    private void loadProduct() {
        ProductAdapter adapter = new ProductAdapter(ProductFragment.this, ProductList);
        ProductRecycleView.setAdapter(adapter);
        Toast.makeText(getApplicationContext(), "Count :" +  ProductList.size(), Toast.LENGTH_LONG).show();
    }











}
