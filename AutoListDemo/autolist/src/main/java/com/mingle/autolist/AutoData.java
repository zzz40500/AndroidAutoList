package com.mingle.autolist;


import com.mingle.utils.BusProvider;

public  abstract class AutoData {

    public String formObject;

    public Poster appleAction(Object o,Action action) {
        formObject=o.getClass().getSimpleName();
        this.action=action;
        return  new Poster();
    }

    public enum  Action{
        Add,Delete,Update,Custom
    }

    public   Action action;
    public  abstract String getIdentifies();


    @Override
    public boolean equals(Object o) {
        if(o instanceof  AutoData){
            return ((AutoData) o).getIdentifies().equals(getIdentifies());
        }

        return super.equals(o);
    }
    public class Poster {

        public  void post(){
            BusProvider.getInstance().post(AutoData.this);
        }
    }
}
