package lotto.agency.number

class LottoNumberMaker : LottoNumberStrategy {
    override fun makeLottoNumbers(): Set<Int> {
        return LottoNumber.LOTTO_NUMBER_RANGE
            .shuffled()
            .slice(LOTTO_NUMBER_COUNT)
            .toSet()
    }

    companion object {
        private val LOTTO_NUMBER_COUNT = IntRange(1, 6)
    }
}
