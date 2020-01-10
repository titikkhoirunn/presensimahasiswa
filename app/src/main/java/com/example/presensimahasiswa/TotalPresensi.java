package com.example.presensimahasiswa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TotalPresensi extends AppCompatActivity {
    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 10;
    private static final int DATASET_COUNT = 60; // menampilkan data sebanyak value

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }
    protected LayoutManagerType mCurrentLayoutManagerType;

    protected RecyclerView mRecyclerView;
    protected AdapterPertemuan mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mPertemuan, mMateri,mTanggal;
    protected int[] mPresensi, mReview;

    int [] btn_presensi = {R.color.abstrak, R.color.abstrak,R.color.abstrak,R.color.abstrak, R.color.abstrak,R.color.abstrak};
    int [] btn_review = {R.color.abstrak, R.color.abstrak,R.color.abstrak,R.color.abstrak, R.color.abstrak,R.color.abstrak};
    String [] tv_pertemuan = {"Pertemuan 1","Pertemuan 2","Pertemuan 3","Pertemuan 4","Pertemuan 5","Pertemuan 6"};
    String [] tv_materi = {"Pembahasan Bab 1","Konsultasi Bab 1","Pembahasab Bab 2","Konsultasi Bab 2","Pembahasab Bab 3","Konsultasi bab 3"};
    String [] tv_tanggal = {"05 Desember 2019","12 Desember 2019","19 Desember 2019","26 Desember 2019","02 Januari 2019","09 Januari 2019"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataset();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_total_presensi, container, false);
        rootView.setTag(TAG);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_presensi);


        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new AdapterPertemuan(mMateri,mPertemuan,mTanggal,mReview,mPresensi);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
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
    private void initDataset() {
        mPertemuan = new String[tv_pertemuan.length];
        mMateri = new String[tv_materi.length];
        mTanggal = new String[tv_tanggal.length];
        mReview = new int[btn_review.length];
        mPresensi = new int[btn_presensi.length];
        for (int i = 0; i < tv_pertemuan.length; i++) {
            mPertemuan[i] = tv_pertemuan[i];
            mMateri[i] = tv_materi[i];
            mTanggal[i] = tv_tanggal[i];
            mPresensi[i] = btn_presensi[i];
            mReview[i] = btn_review[i];
    }
}
}