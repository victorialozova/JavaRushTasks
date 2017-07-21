package com.javarush.task.task14.task1408;

/**
 * Created by Simba on 21.07.2017.
 */
public class MoldovanHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 4;
    }
    public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". " + "Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
