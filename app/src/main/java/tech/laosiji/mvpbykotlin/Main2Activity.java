package tech.laosiji.mvpbykotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Flowable.just("hello world")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("OnSubscribe start");
                        s.request(Long.MAX_VALUE);
                        System.out.println("OnSubscribe end");
//                        s.cancel();
                    }

                    @Override
                    public void onNext(String v) {
                        System.out.println(v);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done");
                    }
                });
    }
}
