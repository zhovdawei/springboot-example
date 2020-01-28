package com.zdw;

import com.zdw.impl.CachedUidGenerator;
import com.zdw.worker.DisposableWorkerIdAssigner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class GeneratorConfig {

    @Bean
    public DisposableWorkerIdAssigner disposableWorkerIdAssigner(){
        return new DisposableWorkerIdAssigner();
    }

    @Bean(value = "cachedUidGenerator")
    public CachedUidGenerator getCachedUidGenerator(){
        CachedUidGenerator cug = new CachedUidGenerator();
        cug.setWorkerIdAssigner(disposableWorkerIdAssigner());
        cug.setEpochStr("2020-01-01");
        return cug;
    }

/*    @Bean(value = "defaultUidGenerator")
    public DefaultUidGenerator getDefaultUidGenerator(){
        DefaultUidGenerator dug = new DefaultUidGenerator();
        dug.setWorkerIdAssigner(disposableWorkerIdAssigner());
        dug.setTimeBits(29);
        dug.setWorkerBits(21);
        dug.setSeqBits(13);
        cug.setEpochStr(LocalDate.now().toString());
        return dug;
    }*/

}
