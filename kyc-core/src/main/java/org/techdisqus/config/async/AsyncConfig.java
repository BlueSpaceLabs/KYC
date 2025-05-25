package org.techdisqus.config.async;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor baseExecutor = new ThreadPoolTaskExecutor();
        baseExecutor.setCorePoolSize(10);
        baseExecutor.setMaxPoolSize(100);
        baseExecutor.setQueueCapacity(500);
        baseExecutor.setThreadNamePrefix("Async-");
        baseExecutor.initialize();

        return new ContextAwareExecutorService(baseExecutor.getThreadPoolExecutor());
    }
}
