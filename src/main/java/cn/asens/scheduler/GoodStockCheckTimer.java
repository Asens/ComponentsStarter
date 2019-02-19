package cn.asens.scheduler;

import lombok.extern.log4j.Log4j2;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author Asens
 */

@Log4j2
public class GoodStockCheckTimer
        extends QuartzJobBean
{
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("执行库存检查定时任务2，执行时间：{}",new Date());
    }
}
