package com.example.presensimahasiswa;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class PresensiFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 10;
    private static final int DATASET_COUNT = 60; // menampilkan data sebanyak value

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ProfileFragment.OnFragmentInteractionListener mListener;
    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RecyclerView mRecyclerView;
    protected AdapterJadwal mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] Tv_Makul,Tv_NamaDosen,Tv_Kelas,Tv_Hari,Tv_Hari1,Tv_Jam,Tv_Jam1,Tv_Ruang,Tv_Ruang1;
    protected int[] Img_Panah,Img_Hari,Img_Jam,Img_Ruang;

    int[] img_panah = {R.drawable.panah, R.drawable.panah,R.drawable.panah, R.drawable.panah,R.drawable.panah};
    int[] img_hari = {R.drawable.hari, R.drawable.hari,R.drawable.hari,R.drawable.hari,R.drawable.hari};
    int[] img_jam = {R.drawable.jam, R.drawable.jam,R.drawable.jam, R.drawable.jam,R.drawable.jam};
    int[] img_ruang = {R.drawable.ruang, R.drawable.ruang,R.drawable.ruang, R.drawable.ruang,R.drawable.ruang};
    String [] tv_makul = {"Proposal Skripsi","Interaksi Manusia & Komputer","Analisis & Perancangan Sistem","Pemrograman Web II","Komputasi Awan"};
    String [] tv_nama_dosen = {"Fuadz Hasyim, M. Kom.","Nadiyah, M. Kom.","Ratri Enggar Pawening, M. Kom.","MOh. Ainol Yakin, M. Kom","Fathurrazi Nur Fajri, M.Kom"};
    String [] tv_kelas = {"Kelas A","Kelas A","Kelas A","Kelas A","Kelas A"};
    String [] tv_hari = {"Hari","Hari","Hari","Hari","Hari"};
    String [] tv_hari1 = {"Rabu","Selasa","Minggu","Senin","Senin"};
    String [] tv_jam = {"Jam","Jam","Jam","Jam","Jam"};
    String [] tv_jam1 = {"15.00-16.30","08.50-10.50","08.50-10.50","08.50-10.50","10.50-13.40"};
    String [] tv_ruang = {"Ruang","Ruang","Ruang","Ruang","Ruang"};
    String [] tv_ruang1 = {"D2.01","D2.03","Lab 5","Lab 5","Lab 2"};

    public PresensiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PresensiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PresensiFragment newInstance(String param1, String param2) {
        PresensiFragment fragment = new PresensiFragment();
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
        initDataset();
    }

    private void initDataset() {
        Tv_Makul = new String[tv_makul.length];
        Tv_NamaDosen = new String[tv_nama_dosen.length];
        Tv_Kelas = new String[tv_kelas.length];
        Tv_Hari = new String[tv_hari.length];
        Tv_Hari1 = new String[tv_hari1.length];
        Tv_Jam = new String[tv_jam.length];
        Tv_Jam1 = new String[tv_jam1.length];
        Tv_Ruang = new String[tv_ruang.length];
        Tv_Ruang1 = new String[tv_ruang1.length];
        Img_Panah = new int[img_panah.length];
        Img_Hari = new int[img_hari.length];
        Img_Jam = new int[img_jam.length];
        Img_Ruang = new int[img_ruang.length];
        for (int i = 0; i < tv_makul.length; i++) {
            Tv_Makul [i]= tv_makul[i];
            Tv_NamaDosen[i] = tv_nama_dosen[i];
            Tv_Kelas[i] = tv_kelas[i];
            Tv_Hari[i] = tv_hari[i];
            Tv_Hari1 [i]= tv_hari1[i];
            Tv_Jam [i]= tv_jam[i];
            Tv_Jam1[i] = tv_jam1[i];
            Tv_Ruang[i] = tv_ruang[i];
            Tv_Ruang1[i] = tv_ruang1[i];
            Img_Panah [i]= img_panah[i];
            Img_Hari[i] = img_hari[i];
            Img_Jam[i] = img_jam[i];
            Img_Ruang[i] = img_ruang[i];
        }
    }
    public
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_presensi, container, false);
        rootView.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_jadwal);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new AdapterJadwal(Tv_Makul,Tv_NamaDosen,Tv_Kelas,Tv_Hari,Tv_Hari1,Tv_Jam,Tv_Jam1,Tv_Ruang,Tv_Ruang1,
                Img_Panah,Img_Hari,Img_Jam,Img_Ruang);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }

    private void setRecyclerViewLayoutManager(LayoutManagerType mCurrentLayoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (mCurrentLayoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PresensiFragment.OnFragmentInteractionListener) {
            mListener = (ProfileFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
