package lotto

data class Statistics(
    val result: Int = 0,
    var three: Int = 0,
    var four: Int = 0,
    var five: Int = 0,
    var six: Int = 0
) {
    private var none: Int = 0
    fun plusCount(result: Int) {
        when (result) {
            3 -> three++
            4 -> four++
            5 -> five++
            6 -> six++
            else -> none++
        }
    }
}
