import java.util.Arrays;

/**
 * Created by anil on 28/02/2017.
 */
public class Job {
    Order[] jobs;

    public Job(Order[] jobs) {
        this.jobs = jobs;
    }

    public Order[] getJobs() {
        return jobs;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobs=" + Arrays.toString(jobs) +
                '}';
    }
}
