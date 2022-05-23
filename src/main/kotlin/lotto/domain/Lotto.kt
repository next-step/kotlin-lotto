package lotto.domain

object Lotto {
    private val BASIC_LOTTO = (1..45).toMutableList()
    private const val MIN_LOTTO_INDEX = 0
    private const val MAX_LOTTO_INDEX = 6

    fun create(): List<Int> {
        return BASIC_LOTTO.shuffled().subList(MIN_LOTTO_INDEX, MAX_LOTTO_INDEX)
    }
}
