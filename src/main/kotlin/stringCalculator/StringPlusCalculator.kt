package stringCalculator

object StringPlusCalculator {

    const val DEFAULT_SEPERATOR_1 = ":"
    const val DEFAULT_SEPERATOR_2 = ","
    fun seperate(it: String): List<Int> {
        return it.split(DEFAULT_SEPERATOR_1, DEFAULT_SEPERATOR_2).map {
            it.toInt()
        }
    }
}
