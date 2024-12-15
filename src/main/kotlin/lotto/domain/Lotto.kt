package lotto.domain

class Lotto(private val lottoNumberGenerator: LottoNumberGenerator) {
    var lottoNumbers: Set<LottoNumber>
        private set
    var bonusNumber: LottoNumber
        private set

    init {
        getByAuto().run {
            lottoNumbers = first
            bonusNumber = second
        }
    }

    private fun getByAuto(): Pair<Set<LottoNumber>, LottoNumber> {
        val normal = buildSet { while (size < 6) add(LottoNumber.get(lottoNumberGenerator.generateLottoNumber())) }
        val bonus = getBonus(normal)
        return Pair(normal, bonus)
    }

    private fun getBonus(normal: Set<LottoNumber>): LottoNumber {
        while (true) {
            val stepNumber = LottoNumber.get(lottoNumberGenerator.generateLottoNumber())
            if (stepNumber !in normal) return stepNumber
        }
    }

    fun setLottoByManual(
        bonus: Int,
        vararg lottoNumber: Int,
    ) {
        require(lottoNumber.size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_COUNT_EXCEPTION_MESSAGE }
        require(lottoNumber.distinct().size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_DISTINCT_MESSAGE }
        require(bonus !in lottoNumber) { LOTTO_NUMBER_DISTINCT_MESSAGE }
        lottoNumbers = lottoNumber.map { LottoNumber.get(it) }.toSet()
        bonusNumber = LottoNumber.get(bonus)
    }

    fun match(
        winningNumber: List<LottoNumber>,
        bonusNumber: LottoNumber,
    ): MatchingResult? {
        return MatchingResult.getResult(lottoNumbers.intersect(winningNumber).size, bonusNumber == this.bonusNumber)
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val LOTTO_NUMBER_COUNT_EXCEPTION_MESSAGE = "로또 초기화시 입력된 로또 번호가 6개가 아닙니다."
        private const val LOTTO_NUMBER_DISTINCT_MESSAGE = "로또 초기화시 입력된 로또 번호에 중복이 있습니다."
    }
}
