package lotto.filter

object LottoFilter : Filter {

    private const val LOTTO_NUMBER_MIN = 1
    private const val LOTTO_NUMBER_MAX = 45
    private const val LOTTO_NUMBER_OUT_RAGE =
        "로또 번호의 범위는 $LOTTO_NUMBER_MIN ~ $LOTTO_NUMBER_MAX 만 가능합니다."

    override fun verify(value: Int): Int {
        lottoRangeCheck(value)
        return value
    }

    private fun lottoRangeCheck(value: Int) =
        require(value in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) { IllegalArgumentException(LOTTO_NUMBER_OUT_RAGE) }
}
