package com.example.giaodien;

public interface Constract {
    interface IView{
        void showloginsuccess();
        void showloginFailed();
    }
    interface IPresenter{
        void dologin(String email, String pass, MainActivity activity);
        void forgotpass();
    }
}
