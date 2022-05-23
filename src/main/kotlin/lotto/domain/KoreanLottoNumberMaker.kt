package lotto.domain

class KoreanLottoNumberMaker : LottoMaker {
    override fun makeLottoNumbers(): List<Int> {
        val range = List(LOTTO_COUNT) { it + LOTTO_START_OFFSET }
        val shuffled = range.shuffled()
        return shuffled.subList(LOTTO_START, LOTTO_END)
    }

    companion object {
        private const val LOTTO_START_OFFSET = 1
        private const val LOTTO_COUNT = 45
        private const val LOTTO_START = 0
        private const val LOTTO_END = 6
    }
}
