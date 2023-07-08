package lotto

class Lotto(private val numbers: List<LottoNumber>) {
    fun match(lotto: Lotto): Match? {
        val matchNumbers = numbers.intersect(lotto.numbers)
        return Match.from(matchNumbers.size)
    }

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또 번호는 ${LOTTO_NUMBER_SIZE}개만 입력할 수 있습니다. [${numbers.size}]" }
        require(numbers.distinct().size == LOTTO_NUMBER_SIZE) { "로또 번호는 중복될 수 없습니다. [${numbers}]" }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6

        fun from(numbers: List<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber(it) })
        }
    }
}
