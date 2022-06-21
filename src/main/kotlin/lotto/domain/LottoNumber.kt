package lotto.domain

class LottoNumber private constructor(private val value: Int) {
    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException("$MINIMUM_NUMBER ~ $MAXIMUM_NUMBER 사이 숫자여야 해요")
        }
    }
}
