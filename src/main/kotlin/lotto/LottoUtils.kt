package lotto

private val DEFAULT_RANGE = 1..45
private const val LOTTO_NUMBERS = 6
const val LOTTO_PRICE = 1000

object LottoUtils {
    lateinit var luckyNumbers: List<Int>

    fun provideNumbers(): List<Int> {
        return DEFAULT_RANGE.shuffled().take(LOTTO_NUMBERS).sorted()
    }
}
