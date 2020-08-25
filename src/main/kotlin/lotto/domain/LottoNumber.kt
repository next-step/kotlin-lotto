package lotto.domain

const val MIN_NUMBER = 1
const val MAX_NUMBER = 45
val LOTTO_NUMBER_REGULAR_EXPRESSION = "(\\d{1,2})".toRegex()

open class LottoNumber private constructor(private val number: Int = 0) {

    override fun toString(): String {
        return number.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }

    companion object {
        private val lottoNumbers: Map<Int, LottoNumber> by lazy {
            (MIN_NUMBER..MAX_NUMBER).associateWith { LottoNumber(it) }
        }

        fun from(number: Int): LottoNumber {
            return lottoNumbers[number] ?: throw IllegalArgumentException("$MIN_NUMBER~$MAX_NUMBER 사이의 숫자를 입력해 주세요.")
        }

        @Throws(NumberFormatException::class)
        fun from(number: String): LottoNumber {
            checkValidation(number)
            return from(number.toInt())
        }

        private fun checkValidation(numberString: String) {
            require(LOTTO_NUMBER_REGULAR_EXPRESSION.matches(numberString)) { "$MIN_NUMBER~$MAX_NUMBER 사이의 숫자만 입력해 주세요." }
        }
    }
}
