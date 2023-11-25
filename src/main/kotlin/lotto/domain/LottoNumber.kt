package lotto.domain

class LottoNumber private constructor(private val number: Int) {
    override fun toString(): String {
        return number.toString()
    }

    companion object {
        const val LOTTO_NUMBER_MIN = 1
        const val LOTTO_NUMBER_MAX = 45
        private val LOTTO_NUMBER_SET: Map<Int, LottoNumber> = (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX).associateWith(::LottoNumber)
        fun of(number: Int): LottoNumber {
            return LOTTO_NUMBER_SET[number] ?: throw IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다.")
        }
    }
}
