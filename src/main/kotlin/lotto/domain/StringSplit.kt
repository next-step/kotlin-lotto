package lotto.domain

object StringSplit {

    fun makeNumbersBySplit(stringNumbers: String): List<Int> {
        return stringNumbers.replace(" ", "")
            .split(DELIMITERS)
            .map {
                it.toInt()
            }
    }

    private const val DELIMITERS = ","
}
