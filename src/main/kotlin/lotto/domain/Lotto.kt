package lotto.domain

const val COUNT_OF_NUMBERS = 6
private val LOTTO_NUMBERS = (MIN_NUMBER..MAX_NUMBER)

class Lotto(private val numbers: Set<LottoNumber>) {

    init {
        require(numbers.size == COUNT_OF_NUMBERS) { "중복되지 않는 6개의 숫자를 입력해주세요" }
    }

    constructor() : this(
        LOTTO_NUMBERS.shuffled().subList(0, COUNT_OF_NUMBERS)
            .sorted().map { LottoNumber(it) }.toSet()
    )

    constructor(prizeNumberString: String) : this(
        prizeNumberString.split(",").asSequence().sorted().map { LottoNumber(it.toInt()) }.toSet()
    )

    fun getPrize(lotto: Lotto): Prize {
        return Prize.getPrize(numbers.count { lotto.numbers.contains(it) })
    }

    fun isContainBonusNumber(bonusNumber: LottoNumber) = numbers.contains(bonusNumber)

    override fun toString(): String {
        return numbers.toString()
    }
}
