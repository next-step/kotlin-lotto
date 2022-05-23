package lotto.agency

object LottoNumber {
    private val LOTTO_NUMBER_RANGE = IntRange(1, 45)

    fun getRandomOne(): Int {
        return LOTTO_NUMBER_RANGE.random()
    }
}
