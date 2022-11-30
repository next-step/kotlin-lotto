package lotto.domain

class LottoTicket(
    val numbers: Set<LottoNumber>
) {

    constructor(vararg values: Int) : this(List(values.size) { idx -> LottoNumber.of(values[idx]) })
    constructor(values: List<LottoNumber>) : this(values.toSet())

    init {
        require(numbers.size == NUMBER_SIZE) { "로또 번호의 갯수는 ${numbers.size} 일 수 없으며 6 개만 가능합니다." }
        require(hasNotEqualNumber()) { "같은 로또 번호는 올 수 없어요" }
    }

    fun matchCount(lottoTicket: LottoTicket): Int {
        return numbers.count { lottoTicket.containNumber(it) }
    }

    fun notContainNumber(bonusNumber: LottoNumber): Boolean = !containNumber(bonusNumber)

    fun containNumber(lottoNumber: LottoNumber): Boolean = numbers.contains(lottoNumber)

    private fun hasNotEqualNumber() = numbers.toSet().size == numbers.size

    companion object {
        const val NUMBER_SIZE = 6
    }
}
