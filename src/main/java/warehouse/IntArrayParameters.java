package warehouse;

public class IntArrayParameters {
  private int min;
  private int max;
  private int sum;
  private double average;

  public IntArrayParameters(int min, int max, int sum, double average) {
    this.min = min;
    this.max = max;
    this.sum = sum;
    this.average = average;
  }

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }

  public int getSum() {
    return sum;
  }

  public double getAverage() {
    return average;
  }

  @Override
  public String toString() {
    return "ArrayParameters{" +
            "min=" + min +
            ", max=" + max +
            ", sum=" + sum +
            ", average=" + average +
            '}';
  }
}
