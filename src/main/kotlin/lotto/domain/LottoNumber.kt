package lotto.domain

@JvmInline
value class LottoNumber private constructor(private val number: Int) : Comparable<LottoNumber> {

    override fun compareTo(other: LottoNumber): Int {
        return this.number.compareTo(other.number)
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private val NUMBERS = (1..45).map { LottoNumber(it) }.toTypedArray()

        fun of(number: Int): LottoNumber {
            require(number in 1..45) { "1 ~ 45 의 숫자만 가능합니다." }
            return NUMBERS[number - 1]
        }

        fun lottoNumbers(): List<LottoNumber> {
            return NUMBERS.toList()
        }
    }
}
