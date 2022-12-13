package lotto.domain

class LottoNumber private constructor(val value: Int) : Comparable<LottoNumber> {
    override fun compareTo(other: LottoNumber): Int = value.compareTo(other.value)

    companion object {
        private const val START_RANGE = 1
        private const val END_RANGE = 45
        private const val OUT_OF_LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 범위에 해당하는 숫자가 아닙니다. [%d], [$START_RANGE ~ $END_RANGE] 범위에 숫자만 입력하세요."
        private val lottoNumbers: Map<Int, LottoNumber> = init()

        private fun init(): Map<Int, LottoNumber> =
            (START_RANGE..END_RANGE)
                .mapIndexed { index, number -> index + 1 to LottoNumber(number) }
                .toMap()

        fun of(inputNumber: Int): LottoNumber =
            lottoNumbers[inputNumber] ?: throw IllegalArgumentException(OUT_OF_LOTTO_NUMBER_RANGE_ERROR_MESSAGE.format(inputNumber))
    }
}
