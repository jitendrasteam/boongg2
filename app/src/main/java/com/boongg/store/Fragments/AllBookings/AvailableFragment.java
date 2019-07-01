package com.boongg.store.Fragments.AllBookings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.boongg.store.Fragments.VehicleInventoryFragments.AllBikesFragment;
import com.boongg.store.Interfaces.INotifier;
import com.boongg.store.MainActivity;
import com.boongg.store.Models.Responses.AvailableVehicles.VehicleInventoryResponse;
import com.boongg.store.Models.Responses.PreDropBookings.PreDropBooking;
import com.boongg.store.Networking.APIClient;
import com.boongg.store.Networking.BookingRequest;
import com.boongg.store.Networking.OAPIClient;
import com.boongg.store.Networking.OwnerInventory;
import com.boongg.store.R;
import com.boongg.store.RecyclerViews.VehicleInventoryAdapter;
import com.boongg.store.Utilities.LoginToken;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableFragment extends Fragment {
    RecyclerView recyclerView=null;
     TextView msg;
    INotifier notifier;

    View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_available, container, false);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.rv_inventory_all_bikes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        OwnerInventory inventory= APIClient.getClient().create(OwnerInventory.class);
        Call<List<VehicleInventoryResponse>> call1 = inventory.getAvailableVehicles(LoginToken.id);
        msg=(TextView)rootView.findViewById(R.id.all_bikes_inventory_no_msg);
        getAvailableBikes();
       // onAttachToParentFragment(getParentFragment());


        return rootView;
    }
    BookingRequest request;
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    @Override
    public void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
    public void setupRecycleView(List<PreDropBooking> bookings){

            Toast.makeText(getContext(),"Ok",Toast.LENGTH_LONG).show();
            if (recyclerView == null) {
                recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_inventory_all_bikes);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }
            if (bookings.size() > 0) {
                VehicleInventoryAdapter adapter = new VehicleInventoryAdapter(bookings, getContext());
                recyclerView.setAdapter(adapter);
                msg.setVisibility(View.GONE);
                notifier.notify(0, bookings.size());
            } else {
                notifier.notify(0, 0);

                msg.setVisibility(View.VISIBLE);
            }

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment p=null;
        for(Fragment a:getActivity().getSupportFragmentManager().getFragments()){
            if(a instanceof  AllBikesFragment){
                p=a;
            }
        }
        try
        {
            notifier = (INotifier) p;
        }
        catch (Exception e)
        {
            Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
        }    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Fragment p=null;
        for(Fragment a:getActivity().getSupportFragmentManager().getFragments()){
            if(a instanceof  AllBikesFragment){
                p=a;
            }
        }
        try
        {
            notifier = (INotifier) this;

        }
        catch (Exception e)
        {
            Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
        }    }

    List<PreDropBooking> avaialble,maintainance,ongoining;
    private void getAvailableBikes() {
        BookingRequest request= OAPIClient.getClient().create(BookingRequest.class);
        compositeDisposable.add(request.getAvailableBikes().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<PreDropBooking>>() {
            @Override
            public void accept(List<PreDropBooking> dropBookings) throws Exception {
                setupRecycleView(dropBookings);
            }
        }));

    }
    private void getMaintainance() {
        compositeDisposable.add(request.getMaintainanceBikes().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<PreDropBooking>>() {
            @Override
            public void accept(List<PreDropBooking> dropBookings) throws Exception {
                maintainance=dropBookings;
            }
        }));

    }
    private void getOngoing() {
        compositeDisposable.add(request.getOnGoingBikes().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<PreDropBooking>>() {
            @Override
            public void accept(List<PreDropBooking> dropBookings) throws Exception {
                ongoining=dropBookings;
            }
        }));

    }
    public interface INotifier {
        public void notify(int position,int data);
    }

}
