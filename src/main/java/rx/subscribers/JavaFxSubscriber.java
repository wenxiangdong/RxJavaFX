/**
 * Copyright 2016 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rx.subscribers;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import javafx.beans.binding.Binding;
public enum JavaFxSubscriber {
    ;//no instances
    /**
     * Turns an Observable into an eager JavaFX Binding that subscribes immediately to the Observable. Calling the Binding's dispose() method will handle the unsubscription.
     */
    public static <T> Binding<T> toBinding(Observable<T> obs) {
        BindingObserver<T> bindingObserver = new BindingObserver<>(e -> {});
        obs.subscribe(bindingObserver);
        return bindingObserver;
    }
    /**
     * Turns an Observable into an eager JavaFX Binding that subscribes immediately to the Observable. Calling the Binding's dispose() method will handle the unsubscription.
     */
    public static <T> Binding<T> toBinding(Observable<T> obs, Consumer<Throwable> onErrorAction ) {
        BindingObserver<T> bindingObserver = new BindingObserver<>(onErrorAction);
        obs.subscribe(bindingObserver);
        return bindingObserver;
    }

    /**
     * Turns a Flowable into an eager JavaFX Binding that subscribes immediately to the Observable. Calling the Binding's dispose() method will handle the unsubscription.
     */
    public static <T> Binding<T> toBinding(Flowable<T> obs) {
        BindingSubscriber<T> bindingObserver = new BindingSubscriber<>(e -> {});
        obs.subscribe(bindingObserver);
        return bindingObserver;
    }
    /**
     * Turns a Flowable into an eager JavaFX Binding that subscribes immediately to the Observable. Calling the Binding's dispose() method will handle the unsubscription.
     */
    public static <T> Binding<T> toBinding(Flowable<T> obs, Consumer<Throwable> onErrorAction ) {
        BindingSubscriber<T> bindingObserver = new BindingSubscriber<>(onErrorAction);
        obs.subscribe(bindingObserver);
        return bindingObserver;
    }

   /* *//**
     * Turns an Observable into a lazy JavaFX Binding that subscribes to the Observable the first time the Binding's getValue() method is called. Calling the Binding's dispose() method will handle the unsubscription.
     *//*
    public static <T> Binding<T> toLazyBinding(Observable<T> obs) {
        return toLazyBinding(obs, e -> {});
    }

    *//**
     * Turns an Observable into a lazy JavaFX Binding that subscribes to the Observable the first time the Binding's getValue() method is called. Calling the Binding's dispose() method will handle the unsubscription.
     *//*
    public static <T> Binding<T> toLazyBinding(Observable<T> obs, Consumer<Throwable> onErrorAction ) {
        return BindingObserver.forObservable(obs, onErrorAction, true);
    }*/
}
