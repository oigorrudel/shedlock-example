package br.xksoberbado.shedlockexample.scheduling;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MySchedulers {

    @Scheduled(cron = "*/10 * * * * *")
    @SchedulerLock(name = "ten-scheduler")
    void run() {
        log.info("Here");
    }
}
