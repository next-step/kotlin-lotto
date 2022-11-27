package lotto

class Statistics(val statistic: Map<Int, Int> = HashMap()) {
    fun add(result: Int) {
        val i = statistic[result]?.plus(1)
        statistic.plus(result to i)
    }

}