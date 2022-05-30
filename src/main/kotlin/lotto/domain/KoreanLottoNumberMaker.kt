package lotto.domain

class KoreanLottoNumberMaker : LottoMaker {
    private val lottoNumberCandidate = List(LOTTO_COUNT) { LottoNumber(it + LOTTO_START_OFFSET) }
    private val _manualLotto = mutableListOf<LottoNumbers>()
    override val manualLotto
        get() = _manualLotto.toList()

    override fun buyAutoLotto(): LottoNumbers {
        val shuffled = lottoNumberCandidate.shuffled()
        return LottoNumbers(shuffled.subList(LOTTO_START, LOTTO_END))
    }

    override fun buyManualLotto(numbers: List<List<Int>>) {
        _manualLotto.addAll(
            numbers.map {
                LottoNumbers.of(it)
            }
        )
    }

    companion object {
        private const val LOTTO_START_OFFSET = 1
        private const val LOTTO_COUNT = 45
        private const val LOTTO_START = 0
        private const val LOTTO_END = 6
    }
}
