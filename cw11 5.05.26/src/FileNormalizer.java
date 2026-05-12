import java.io.*;

class FileNormalizer implements Runnable {
    private File inputFile, outputFile;
    private int linesBefore, linesAfter;

    public FileNormalizer(File in, File out) { this.inputFile = in; this.outputFile = out; }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linesBefore++;
                if (!line.isBlank()) {
                    writer.write(line.strip().toLowerCase());
                    writer.newLine();
                    linesAfter++;
                }
            }
        } catch (IOException e) {
            System.out.println("Message " + e);
        }
    }
    public int getLinesBefore() { return linesBefore; }
    public int getLinesAfter() { return linesAfter; }

}