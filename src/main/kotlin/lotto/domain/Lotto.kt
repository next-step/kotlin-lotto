package lotto.domain

const val COUNT_OF_NUMBERS = 6
private val LOTTO_NUMBERS = (MIN_NUMBER..MAX_NUMBER)

class Lotto() {
    var numbers: Set<LottoNumber> = emptySet()
    var countOfMatch: Int = 0
        private set

    init {
        numbers = LOTTO_NUMBERS.shuffled().subList(0, COUNT_OF_NUMBERS)
            .sorted().map { LottoNumber(it) }.toSet()
        require(numbers.size == COUNT_OF_NUMBERS) { "중복되지 않는 6개의 숫자를 입력해주세요" }
    }

    constructor(prizeNumberString: String) : this() {
        numbers = prizeNumberString.split(",").asSequence().sorted().map { LottoNumber(it.toInt()) }.toSet()
    }

    fun getPrize(lotto: Lotto): Prize {
        countOfMatch = numbers.count { lotto.numbers.contains(it) }
        return Prize.getPrize(countOfMatch)
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
