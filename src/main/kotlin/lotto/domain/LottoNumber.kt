package lotto.domain

class LottoNumber private constructor(val number: Int) {

    companion object {
        const val INVALID_MESSAGE = "은/는 로또 번호가 아닙니다. 1 ~ 45사이의 값을 넣어주세요."
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith(::LottoNumber)

        fun of(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException("$value$INVALID_MESSAGE")
        }
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

    override fun toString() = "$number"
}
