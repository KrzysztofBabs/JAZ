package org.example.scheduler.abstractions;

import java.time.Duration;
import java.time.LocalDateTime;

public class Chron {
    private LocalDateTime startTime = LocalDateTime.now();
    private LocalDateTime endDate;
    private int maxExecutionTimes;
    private Duration intervalDuration = Duration.ofSeconds(3);

    public Chron builder() {
        return this;
    }

    public Chron setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public Chron setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public Chron setMaxExecutionTimes(int maxExecutionTimes) {
        this.maxExecutionTimes = maxExecutionTimes;
        return this;
    }

    public Chron setIntervalDuration(Duration intervalDuration) {
        this.intervalDuration = intervalDuration;
        return this;
    }

    public IProvideNextExecutionTime buildNextTimeExecutionProvider() {
        return this::getNextTime; // dziala jak lambda
//        int counter=0;
//       if(startTime.isAfter(endDate)) {
//           return null;
//       }
//       if(maxExecutionTimes<=0){
//           return null;
//       }
//       if(endDate!=null){
//           return () ->startTime.plus(intervalDuration);
//
//       }
//
//       if(intervalDuration==null){
//           intervalDuration.plusSeconds(5);
//       }
    }

        private LocalDateTime getNextTime(){
            // ... tutaj logike kodu dac
        return null;
        }




}

