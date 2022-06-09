package lotto.domain

class LottoNumber private constructor(
    private val number: Int
) : Comparable<LottoNumber> {

    override fun toString(): String = number.toString()

    override fun compareTo(other: LottoNumber): Int {
        return number.compareTo(other.number)
    }

    companion object {
        fun of(number: Int): LottoNumber {
            require(number in RANGE_OF_LOTTO_NUMBER) {
                "1부터 45까지 숫자만 입력할 수 있습니다."
            }
            return cache[number] ?: throw IllegalArgumentException()
        }

        fun shuffled(): List<LottoNumber> = cache.values.shuffled()

        private val RANGE_OF_LOTTO_NUMBER = 1..45
        private val cache: Map<Int, LottoNumber> = RANGE_OF_LOTTO_NUMBER.map { it }
            .associateWith(::LottoNumber)
    }
}
