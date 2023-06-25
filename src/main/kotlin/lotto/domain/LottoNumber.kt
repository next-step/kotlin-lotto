package lotto.domain

class LottoNumber private constructor(val value: Int) {

    companion object {
        private const val MIN_LOTTO_NUMBER = 1;
        private const val MAX_LOTTO_NUMBER = 45;
        private val NUMBERS: Map<Int, LottoNumber> =
            (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).associateWith(::LottoNumber)

        fun from(number: Int): LottoNumber {
            return NUMBERS[number] ?: throw IllegalArgumentException("로또 번호는 1 ~ 45 사이여야 합니다.")
        }
    }
}
