package lotto.domain

class Lotto(private val lottoNumberGenerator: LottoNumberGenerator? = null, vararg lottoNumber: Int) {
    init {
        require(!(lottoNumberGenerator == null && lottoNumber.isEmpty())) { LOTTO_PARAMETERS_ERROR_MESSAGE }
    }

    val lottoNumbers: Set<LottoNumber> =
        if (lottoNumber.isNotEmpty()) {
            getByManual(lottoNumber)
        } else {
            getByAuto()
        }

    private fun getByAuto(): MutableSet<LottoNumber> {
        lottoNumberGenerator ?: return mutableSetOf()
        val lotto: MutableSet<LottoNumber> = mutableSetOf()
        while (lotto.size < LOTTO_NUMBER_COUNT) {
            lotto.add(LottoNumber.get(lottoNumberGenerator.generateLottoNumber()))
        }
        return lotto
    }

    private fun getByManual(lottoNumber: IntArray): Set<LottoNumber> {
        require(lottoNumber.size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_COUNT_EXCEPTION_MESSAGE }
        require(lottoNumber.distinct().size == LOTTO_NUMBER_COUNT) { LOTTO_NUMBER_DISTINCT_MESSAGE }
        return lottoNumber.map { LottoNumber.get(it) }.toSet()
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val LOTTO_NUMBER_COUNT_EXCEPTION_MESSAGE = "로또 초기화시 입력된 로또 번호가 6개가 아닙니다."
        private const val LOTTO_NUMBER_DISTINCT_MESSAGE = "로또 초기화시 입력된 로또 번호에 중복이 있습니다."
        private const val LOTTO_PARAMETERS_ERROR_MESSAGE = "로또 생성시 필요한 매개변수를 잘못입력하셨습니다."
    }
}
