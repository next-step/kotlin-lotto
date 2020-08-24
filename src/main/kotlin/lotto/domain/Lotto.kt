package lotto.domain

const val COUNT_OF_NUMBERS = 6
val LOTTO_NUMBERS = (MIN_NUMBER..MAX_NUMBER)
private val PLAYER_REGULAR_EXPRESSION = "^(\\d{1,2},)+\\d{1,2}$".toRegex()

open class Lotto(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == COUNT_OF_NUMBERS) { "중복되지 않는 6개의 숫자를 입력해주세요" }
    }

    constructor(numbers: List<Int>) : this(
        numbers.sorted().map { LottoNumber.from(it) }.toSet()
    )

    fun getCountOfMatchNumber(prizeLotto: Lotto) = numbers.count { prizeLotto.isContainNumber(it) }
    fun isContainNumber(lottoNumber: LottoNumber) = numbers.contains(lottoNumber)
    override fun toString(): String = numbers.toString()

    companion object {
        fun from(numbers: String = ""): Lotto {
            if (numbers.isEmpty()) return AutoLotto()
            checkValidation(numbers)
            return ManualLotto(numbers)
        }

        private fun checkValidation(numbers: String) {
            require(PLAYER_REGULAR_EXPRESSION.matches(numbers)) { "$MIN_NUMBER~$MAX_NUMBER 사이의 숫자  $COUNT_OF_NUMBERS 개와`,`로 만 값을 입력해 주세요." }
        }
    }
}
