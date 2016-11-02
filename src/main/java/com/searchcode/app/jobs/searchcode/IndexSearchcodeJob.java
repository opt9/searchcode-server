package com.searchcode.app.jobs.searchcode;


import com.searchcode.app.dao.searchcode.CodeDAO;
import com.searchcode.app.dto.searchcode.Code;
import com.searchcode.app.service.CodeIndexer;
import com.searchcode.app.service.Singleton;
import org.quartz.*;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class IndexSearchcodeJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        if (Singleton.getBackgroundJobsEnabled() == false) {
            return;
        }

        try {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

            // Pull everything from mysql database and index it
            CodeDAO codeDAO = new CodeDAO();

            for(Code code: codeDAO.getAllCode()) {
                Singleton.getLogger().info(code.id + " " +code.location);

                CodeIndexer.indexSearchcodeDocument(code);
            }

        } catch (Exception ex) {
            // Continue at all costs
            Singleton.getLogger().warning("ERROR - caught a " + ex.getClass() + " in " + this.getClass() +  "\n with message: " + ex.getMessage());
        }
    }
}
