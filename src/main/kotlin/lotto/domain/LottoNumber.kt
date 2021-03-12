package lotto.domain

class LottoNumber private constructor(val value: Int) {

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException("로또의 번호는 1~45번 까지 있습니다.")
        }
    }
}
