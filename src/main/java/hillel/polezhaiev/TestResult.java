package hillel.polezhaiev;

import java.time.LocalDateTime;
import java.util.Objects;

public class TestResult {
    private int amount;
    private int success;
    private int failed;
    private LocalDateTime localDateTime;

    public TestResult() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestResult that = (TestResult) o;
        return amount == that.amount && success == that.success && failed == that.failed && Objects.equals(localDateTime, that.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, success, failed, localDateTime);
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "amount=" + amount +
                ", success=" + success +
                ", failed=" + failed +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
