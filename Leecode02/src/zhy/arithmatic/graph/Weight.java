package zhy.arithmatic.graph;

public class Weight implements Comparable<Weight> {
    private double weight;

    public Weight(double weight) {
     
        this.weight = weight;
    }
    
    public double getWeight() {
    	return weight;
    }

    /**
     * 实现 compareTo 方法
     * 返回 负数: this < o
     * 返回 零:   this == o
     * 返回 正数: this > o
     */
    @Override
    public int compareTo(Weight o) {
        // 推荐做法：使用静态包装类的 compare 方法，避免浮点数精度和溢出问题
        int weightCompare = Double.compare(this.weight, o.weight);
        return weightCompare;
    }
}
