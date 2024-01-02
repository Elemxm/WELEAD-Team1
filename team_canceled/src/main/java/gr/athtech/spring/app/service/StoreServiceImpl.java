package gr.athtech.spring.app.service;

import gr.athtech.spring.app.model.Store;
import gr.athtech.spring.app.model.StoreCategory;
import gr.athtech.spring.app.repository.BaseRepository;
import gr.athtech.spring.app.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService {
    private final StoreRepository storeRepository;

    @Override
    protected BaseRepository<Store, Long> getRepository() {
        return storeRepository;
    }

    @Override
    public Store findByName(String name) {
        return storeRepository.findByName(name);
    }

    @Override
    public List<Store> findByCategory(StoreCategory storeCategory) {
        return storeRepository.findByCategory(storeCategory);
    }

    @Override
    public void changeSchedule(Store store, DayOfWeek day, LocalTime opening, LocalTime closing) {
        LocalTime[][] updatedHours = store.getSchedule();
        if (day == DayOfWeek.MONDAY) {
            updatedHours[0][0] = opening;
            updatedHours[0][1] = closing;
        } else if (day == DayOfWeek.TUESDAY) {
            updatedHours[1][0] = opening;
            updatedHours[1][1] = closing;
        } else if (day == DayOfWeek.WEDNESDAY) {
            updatedHours[2][0] = opening;
            updatedHours[2][1] = closing;
        } else if (day == DayOfWeek.THURSDAY) {
            updatedHours[3][0] = opening;
            updatedHours[3][1] = closing;
        } else if (day == DayOfWeek.FRIDAY) {
            updatedHours[4][0] = opening;
            updatedHours[4][1] = closing;
        } else if (day == DayOfWeek.SATURDAY) {
            updatedHours[5][0] = opening;
            updatedHours[5][1] = closing;
        } else if (day == DayOfWeek.SUNDAY) {
            updatedHours[6][0] = opening;
            updatedHours[6][1] = closing;
        }
        store.setSchedule(updatedHours);
        storeRepository.update(store);
    }
}
