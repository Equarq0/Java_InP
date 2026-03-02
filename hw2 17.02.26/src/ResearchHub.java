import java.util.Arrays;

public class ResearchHub<S extends LaboratoryItem> {
    private S[] storage = (S[]) new LaboratoryItem[2];
    private int count;
    
    public int getCount() { return count; }
    public S get(int index) { return storage[index]; }

    public void register(S item) {
        if (count == storage.length) {
            storage = Arrays.copyOf(storage, storage.length * 2);
        }
        storage[count++] = item;
    }

    public S release(int index) {
        if (index < 0 || index >= count) return null;
        S item = storage[index];
        for (int i = index; i < count - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[--count] = null;
        return item;
    }

    public int findIndex(S item) {
        for (int i = 0; i < count; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    
    public void clearByHazardLevel(int limit) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getBiohazardLevel() > limit) {
                release(i);
                i--; 
            }
        }
    }

    public void adjustPurity(Number offset, Number multiplier) {
        for (int i = 0; i < count; i++) {
            if (storage[i] instanceof ResearchSample) {
                ResearchSample sample = (ResearchSample) storage[i];
                double result = (sample.getPurity().doubleValue() + offset.doubleValue()) * multiplier.doubleValue();
                sample.setPurity(result);
            }
        }
    }
    
    public double getAveragePurity() {
        double sum = 0;
        int samplesCount = 0;
        for (int i = 0; i < count; i++) {
            if (storage[i] instanceof ResearchSample) {
                sum += ((ResearchSample<?>) storage[i]).getPurity().doubleValue();
                samplesCount++;
            }
        }
        return samplesCount == 0 ? 0 : sum / samplesCount;
    }

    public boolean checkSession(S item, Integer sessionID) {
        return item.getSessionID() == sessionID;
    }
}
