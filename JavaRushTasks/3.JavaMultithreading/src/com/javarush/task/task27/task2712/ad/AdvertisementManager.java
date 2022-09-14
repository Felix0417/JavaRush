package com.javarush.task.task27.task2712.ad;

import java.util.List;
import java.util.stream.Collectors;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }

        List<Advertisement> ads = storage.list().stream().sorted().collect(Collectors.toList());

//        long adCostPerSecond;
//        for (Advertisement advertisement: ads){
//            adCostPerSecond = (advertisement.getAmountPerOneDisplaying() / advertisement.getDuration()) * 1000;
//            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
//                    + advertisement.getAmountPerOneDisplaying() + ", " + adCostPerSecond);
//        }
    }
}
