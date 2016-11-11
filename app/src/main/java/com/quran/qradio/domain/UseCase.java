package com.quran.qradio.domain;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by PhucTV on 6/9/16.
 */
public abstract class UseCase<T> {

    private Subscription subscription = Subscriptions.empty();

    protected final Scheduler mUiThread;
    protected final Scheduler mExecutorThread;

    public UseCase(Scheduler mUiThread, Scheduler mExecutorThread) {
        this.mUiThread = mUiThread;
        this.mExecutorThread = mExecutorThread;
    }

    public abstract Observable<T> buildObservable();

    public void execute(Subscriber useCaseSubscriber) {
        this.subscription = this.buildObservable()
                .subscribeOn(mUiThread)
                .observeOn(mExecutorThread)
                .subscribe(useCaseSubscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
