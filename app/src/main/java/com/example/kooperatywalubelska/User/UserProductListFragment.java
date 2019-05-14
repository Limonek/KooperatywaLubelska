package com.example.kooperatywalubelska.User;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.database.Product;
import com.example.kooperatywalubelska.viewmodels.ProductViewModel;
import com.example.kooperatywalubelska.viewmodels.ProductViewModelFactory;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;

public class UserProductListFragment extends DaggerFragment{

    @BindView(R.id.typListy)
    TextView typListy;

    @BindView(R.id.lista)
    RecyclerView allProductsRecyclerView;

    @Inject
    ProductViewModelFactory productViewModelFactory;

    private ProductViewModel productViewModel;

    private LiveData<List<Product>> allProductsLiveData;

    private ProductRecyclerViewAdapter productProductRecyclerViewAdapter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        productViewModel = ViewModelProviders.of(getActivity(), productViewModelFactory).get(ProductViewModel.class);
        productViewModel.initOrRefreshProductsList();
        allProductsLiveData = productViewModel.getAllProductsList();

        productProductRecyclerViewAdapter = new ProductRecyclerViewAdapter(allProductsLiveData.getValue());

        allProductsLiveData.observe(this, (products)->
                productProductRecyclerViewAdapter.setList(products));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_view, container, false);
        ButterKnife.bind(this,v);
        typListy.setText("Wszystkie produkty");

        allProductsRecyclerView.setAdapter(productProductRecyclerViewAdapter);
        allProductsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                FragmentTransaction transaction = getParentFragment().getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, new UserProductInformationFragment());
//                transaction.addToBackStack(null);
//                transaction.commit();
//            }
//        });

        return v;
    }

}
