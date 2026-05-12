import java.util.List;

class LogAnalyzer implements Runnable {
    private final List<String> chunk;
    private int errorCount = 0;
    private int apiUsersCount = 0;

    public LogAnalyzer(List<String> chunk) { this.chunk = chunk; }

    @Override
    public void run() {
        for (String line : chunk) {
            if (line.contains("ERROR")) errorCount++;
            if (line.contains("/api/users")) apiUsersCount++;
        }
    }

    public int getErrorCount() { return errorCount; }
    public int getApiUsersCount() { return apiUsersCount; }
}