package com.example.wmdesigns.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.uos.designs.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText editTextName, editTextAddress, editTextBustSize, editTextHipsSize;
    private AutoCompleteTextView autoCompleteProductName;
    private NumberPicker numberPickerLength;
    private Button placeOrder;

    public OrderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance(String param1, String param2) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toolbar tb = requireActivity().findViewById(R.id.toolbar);
        tb.setTitle("Order");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextName = view.findViewById(R.id.editTextName);
        editTextAddress = view.findViewById(R.id.editTextAddress);
        editTextBustSize = view.findViewById(R.id.editTextBustSize);
        editTextHipsSize = view.findViewById(R.id.editTextHipsSize);
        autoCompleteProductName = view.findViewById(R.id.autoCompleteProductName);
        numberPickerLength = view.findViewById(R.id.numberPickerLength);
        placeOrder = view.findViewById(R.id.buttonPlaceOrder);

        autoCompleteProductName.setOnItemClickListener((parent, v, position, id) -> {
            // Handle item selection, if needed
        });

        // Populate AutoCompleteTextView with data (replace with your data)
        String[] products = {
                "Layered Bisht Cut Abaya",
                "Light Sky","Luna","Sahara","Amber","Ombre","Moonstone","Lemon Meringue","Blush Bliss",
                "Pink Bloom","Sand Tropez","Crystal Rain","SilverStone","Glimmer","Golden Pearl",
                "Navy Royalty Kaftan","Azalea Kaftan","Ava Dress Yellow","Ava Dress Green","The Golden Kaftan",
                "Ivory","Lily","Mocha Charm","Pleated Blue"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, products);
        autoCompleteProductName.setAdapter(adapter);

        // Set min and max values for the NumberPicker
        numberPickerLength.setMinValue(0);
        numberPickerLength.setMaxValue(50);

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user inputs when the "Place Order" button is clicked
                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();
                String productName = autoCompleteProductName.getText().toString();
                int length = numberPickerLength.getValue();
                String bustSize = editTextBustSize.getText().toString();
                String hipsSize = editTextHipsSize.getText().toString();

                // Call the placeOrder method with the retrieved values
                placeOrder(name, address, productName, length, bustSize, hipsSize);
            }
        });

    }
    private void placeOrder(String Name, String Address, String ProductName, int Length, String Bs, String Hs) {
        String name = Name;
        String address = Address;
        String productName = ProductName;
        int length = Length;
        String bustSize = Bs;
        String hipsSize =Hs;
        // Create a message
        String message = "Hi, I'm " + name + "\n"
                + "I live in " + address + "\n"
                + "and I'd like to place an order for " + productName + "\n"
                +"with the following measurements: \n"+ "length: " + length + "\n"
                + "bust size: " + bustSize + "\n"
                + "hips size: " + hipsSize;

        // Send message via WhatsApp (replace with your seller's number)
        String sellerNumber = "+971543758384";
        String url = "https://api.whatsapp.com/send?phone=" + sellerNumber + "&text=" + Uri.encode(message);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}