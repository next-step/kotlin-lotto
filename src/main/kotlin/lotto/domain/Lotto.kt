package lotto.domain

const val COUNT_OF_NUMBERS = 6
private val LOTTO_NUMBERS = (MIN_NUMBER..MAX_NUMBER)
private val PLAYER_REGULAR_EXPRESSION = "^(\\d{1,2},)+\\d{1,2}$".toRegex()

class Lotto private constructor(private val numbers: Set<LottoNumber>) {

    init {
        require(numbers.size == COUNT_OF_NUMBERS) { "중복되지 않는 6개의 숫자를 입력해주세요" }
    }

    private constructor() : this(
        LOTTO_NUMBERS.shuffled().subList(0, COUNT_OF_NUMBERS)
            .sorted().map { LottoNumber.from(it) }.toSet()
    )

    private constructor(prizeNumber: String) : this(
        prizeNumber.split(",").asSequence().sorted().map { LottoNumber.from(it.toInt()) }.toSet()
    )

    fun getCountOfMatchNumber(prizeLotto: Lotto): Int {
        return numbers.count { prizeLotto.isContainNumber(it) }
    }

    fun isContainNumber(number: LottoNumber) = numbers.contains(number)

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        fun from(prizeNumber: String = ""): Lotto {
            if (prizeNumber.isEmpty()) return Lotto()
            checkValidation(prizeNumber)
            return Lotto(prizeNumber)
        }

        private fun checkValidation(prizeNumber: String) {
            require(PLAYER_REGULAR_EXPRESSION.matches(prizeNumber)) { "$MIN_NUMBER~$MAX_NUMBER 사이의 숫자  $COUNT_OF_NUMBERS 개와`,`로 만 값을 입력해 주세요." }
        }
    }
}
