package lotto.domain

const val COUNT_OF_NUMBERS = 6
val LOTTO_NUMBERS = (MIN_NUMBER..MAX_NUMBER)
private val PLAYER_REGULAR_EXPRESSION = "^(\\d{1,2},)+\\d{1,2}$".toRegex()

open class Lotto(val numbers: Set<LottoNumber>) {

    constructor(numbers: List<Int>) : this(
        numbers.sorted().map { LottoNumber.from(it) }.toSet()
    )

    fun getCountOfMatchNumber(prizeLotto: Lotto) = numbers.count { prizeLotto.isContainNumber(it) }
    fun isContainNumber(lottoNumber: LottoNumber) = numbers.contains(lottoNumber)
    override fun toString(): String = numbers.toString()

    companion object {
        fun from(): Lotto = AutoLotto()

        fun from(numbers: String): Lotto? {
            if (!PLAYER_REGULAR_EXPRESSION.matches(numbers)) return null
            val lotto = ManualLotto(numbers)
            if (!lotto.isValidSize()) return null
            return ManualLotto(numbers)
        }
    }
}
