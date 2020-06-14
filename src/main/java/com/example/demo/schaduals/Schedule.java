/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.schaduals;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author Rehab.Abd-Elhamid
 */

/**<second> <minute> <hour> <day-of-month> <month> <day-of-week> <year>
From these, <year> field is optional.
* **/
@Component
public class Schedule{
    
   @Autowired
    private SchedulesService schadualService;
   
    @Scheduled(cron = "0 0/1 * 1/1 * ?")//adjust schadual to  every min
   public void cronJobSchTest() {
        schadualService.testSchadual();     
   }
    //https://stackoverflow.com/questions/42961533/run-a-job-with-spring-scheduled-on-specific-days
   //weekly
   @Scheduled(cron = "0 0 9 * * SUN")//adjust schadual to  each sunday @ 9:00:00 am
   public void cronJobSch() {
        schadualService.testSchadual();     
   }
   
  
//daily
   @Scheduled(cron = "0 0 9 1/1 * ?")//adjust schadual to each day @ 9:00:00 am
   public void crondailyJobSch() {
     schadualService.testSchadual();    
     
   }
   //https://stackoverflow.com/questions/25501503/run-a-timer-task-on-a-specific-day-1st-of-every-month-using-spring
   //http://www.cronmaker.com/
   //monthly on 1st day of the month @ 9:00:00 am
   @Scheduled(cron="0 0 9 1 1/1 ?")
    public void cronMonthlyJobSch()
    {
        schadualService.testSchadual();      
    }
}
