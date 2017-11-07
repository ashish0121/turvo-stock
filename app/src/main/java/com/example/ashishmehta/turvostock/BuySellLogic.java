package com.example.ashishmehta.turvostock;
import java.util.ArrayList;


public class BuySellLogic {
    class Interval {
        int buy, sell;
    }

    int[][] BuySellLogicFunction(int price[], int n) {
        int curdiff = 0;
        int maxdiff = 0;
        int index = 0;
        int out[][] = new int[2][2];
        for (int j = 0; j < price.length -1; j++) {
            curdiff = price[j + 1] - price[j];
            if (maxdiff < curdiff) {
                out[0][0] = j;
                out[0][1] = j+1;
                maxdiff = curdiff;
                index = j;
            }
            System.out.println("Buy on day: " + j
                    + "        " + "Sell on day : " + (j+1));

        }

        maxdiff = 0;
        for (int j = 0; j < price.length -1; j++) {
            if(j != index) {
                curdiff = price[j + 1] - price[j];
                if (maxdiff < curdiff) {
                    out[1][0] = j;
                    out[1][1] = j+1;
                    maxdiff = curdiff;
                }
                System.out.println("Buy on day: " + j
                        + "        " + "Sell on day : " + (j+1));
            }
        }

        System.out.println(out[0][0] + " " + out[0][1]);
        System.out.println(out[1][0] + " " + out[1][1]);
        return out;
    }

/*    int[][] BuySellLogicFunction(int price[], int n)
    {
        int[][] out = null;
        if (n == 1)
            return out;

        int count = 0;

        ArrayList<Interval> sol = new ArrayList<Interval>();

        int i = 0;
        while (i < n - 1)
        {
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;

            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;

            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            e.sell = i-1;
            sol.add(e);

            count++;
        }

        if (count == 0)
            return out;
        else {
            out = new int[2][2];
            System.out.println("Count is " + count);
            for(i =0; i<sol.size(); i++) {
                System.out.println(sol.get(i).buy);
                System.out.println(sol.get(i).sell);
            }
            int curdiff = 0;
            int maxdiff = 0;
            int index = 0;
            for (int j = 0; j < count; j++) {
                curdiff = sol.get(j).sell - sol.get(j).buy;
                if (maxdiff < curdiff) {
                    out[0][0] = sol.get(j).buy;
                    out[0][1] = sol.get(j).sell;
                    maxdiff = curdiff;
                    index = j;
                }
                System.out.println("Buy on day: " + sol.get(j).buy
                        + "        " + "Sell on day : " + sol.get(j).sell);
            }
            System.out.println("out 0" + out[0][0] + " " + out[0][1]);

            if (count > 1) {
                for (int j = 0; j < count; j++) {
                    curdiff = sol.get(j).sell - sol.get(j).buy;

                    if (maxdiff < curdiff && j != index) {
                        out[1][0] = sol.get(j).buy;
                        out[1][1] = sol.get(j).sell;
                        maxdiff = curdiff;
                    }
                    System.out.println("Buy on day: " + sol.get(j).buy
                            + "        " + "Sell on day : " + sol.get(j).sell);
                }
                System.out.println("out 1" + out[1][0] + " " + out[1][1]);

            }
        }

        return out;
    }*/
}