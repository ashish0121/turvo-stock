package com.example.ashishmehta.turvostock;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class BarActivity extends AppCompatActivity {

    int[] arr = new int[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<BarEntry> entries = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();

        int day = (int)bundle.getLong("DAY");
        int value = (int)bundle.getLong("VALUE");

        for(int i =0; i<7; i++) {
            if(i != day) {
                arr[i] = (int) Math.floor(Math.random() * 101);
            } else {
                arr[i] = value;
            }
            entries.add(new BarEntry(i+1, arr[i]));
        }

        BarDataSet dataset = new BarDataSet(entries, "Days of the week");

        final BarChart chart = new BarChart(this);
        setContentView(chart);

        BarData data = new BarData(dataset);
        chart.setData(data);

        BuySellLogic bsl = new BuySellLogic();
        final int[][] out = bsl.BuySellLogicFunction(arr, 7);

        if(out != null && out.length > 1) {
            chart.highlightValue(out[0][0] + 1, 0);
        }

        final Handler handler = new Handler();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        chart.highlightValue(out[1][0] + 1, 0);
                    }
                }, 5000);

            }
        });

    }

    int maxProfit(int price[], int n, int k)
    {
        int profit[][] = new int[k+1][n+1];

        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;

        for (int j= 0; j <= n; j++)
            profit[0][j] = 0;

        for (int i = 1; i <= k; i++)
        {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++)
            {
                prevDiff = max(prevDiff,
                        profit[i-1][j-1] - price[j-1]);
                profit[i][j] = max(profit[i][j-1],
                        price[j] + prevDiff);
            }
        }

        return profit[k][n-1];
    }

    private int max(int prevDiff, int i) {
        if(prevDiff > i)
            return prevDiff;
        else
            return i;
    }


}