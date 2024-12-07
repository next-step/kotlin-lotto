package lotto.domain

class Lotto(private val lottoNumberGenerator: LottoNumberGenerator) {
    var lottoNumbers: Set<LottoNumber> = getByAuto()
        private set

    private fun getByAuto(): Set<LottoNumber> {
        lottoNumberGenerator ?: return setOf()
        return buildSet { while (size < 6) add(LottoNumber.get(lottoNumberGenerator.generateLottoNumber())) }
    }

    fun setLottoByManual(vararg lottoNumber: Int) {
        require(lottoNumber.size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_COUNT_EXCEPTION_MESSAGE }
        require(lottoNumber.distinct().size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_DISTINCT_MESSAGE }
        lottoNumbers = lottoNumber.map { LottoNumber.get(it) }.toSet()
    }

    fun match(winningNumber: List<LottoNumber>): MatchingResult? =
        MatchingResult.fromMatchNumber(lottoNumbers.intersect(winningNumber).size)

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val LOTTO_NUMBER_COUNT_EXCEPTION_MESSAGE = "로또 초기화시 입력된 로또 번호가 6개가 아닙니다."
        private const val LOTTO_NUMBER_DISTINCT_MESSAGE = "로또 초기화시 입력된 로또 번호에 중복이 있습니다."
    }
}
