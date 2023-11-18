package lotto.domain.model

@JvmInline
value class LottoNumber private constructor(val value: Int) {

    init {
        require(value in lottoNumberRange) {
            OUT_OF_RANGE_EXCEPTION_MESSAGE
        }
    }

    companion object {
        private const val LOTTO_NUMBER_START = 1
        private const val LOTTO_NUMBER_END = 45
        private const val OUT_OF_RANGE_EXCEPTION_MESSAGE = "로또 숫자의 범위는 1~45 입니다."

        private val lottoNumberRange = (LOTTO_NUMBER_START..LOTTO_NUMBER_END)
        val lottoNumbers: List<LottoNumber> = lottoNumberRange.map { LottoNumber(it) }

        fun get(value: Int): LottoNumber = lottoNumbers.find { it.value == value }
            ?: throw IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE)
    }
}
