package lotto

class Statistics(val statistic: MutableMap<Int, Int?> = mutableMapOf()) {
    init {
        for (i in 1..6) {
            statistic[i] = 0
        }
    }

    fun add(result: Int) {
        val i = statistic[result]?.plus(1)
        if (i != null) {
            statistic[result] = i
        }
        if (i == null) {
            statistic[result] = 1
        }
    }
}