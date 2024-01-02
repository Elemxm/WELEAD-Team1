package gr.athtech.spring.app.service;

import gr.athtech.spring.app.model.Store;
import gr.athtech.spring.app.model.StoreCategory;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public interface StoreService extends BaseService<Store, Long> {
    Store findByName(String name);

    List<Store> findByCategory(StoreCategory storeCategory);

    void changeSchedule(Store store, DayOfWeek day, LocalTime opening, LocalTime closing);

    void calculateStoreRating(Store store);

    List<Store> findMostFamousStores();

    List<Store> findMostFamousStoresByCategory(StoreCategory storeCategory);
}
