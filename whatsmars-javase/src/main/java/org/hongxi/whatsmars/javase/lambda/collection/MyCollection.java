package org.hongxi.whatsmars.javase.lambda.collection;

/**
 * Created by shenhongxi on 2018/1/11.
 */
public interface MyCollection {

    int size();

    default String notRequired() {
        return "Default implementation";
    }
}
