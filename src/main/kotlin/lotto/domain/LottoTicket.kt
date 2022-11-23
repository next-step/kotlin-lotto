package lotto.domain

private const val NUMBER_SIZE = 6

class LottoTicket(
    private val numbers: List<LottoNumber>
) {

    constructor(vararg values: Int) : this(List(values.size) { idx -> LottoNumber(values[idx]) })

    init {
        require(numbers.size == NUMBER_SIZE) { "로또 번호의 갯수는 ${numbers.size} 일 수 없으며 6 개만 가능합니다." }
        require(hasNotEqualNumber()) { "같은 로또 번호는 올 수 없어요" }
    }


    fun matchScratch(lottoTicket: LottoTicket): Award {
        val matchCount = numbers.count { lottoTicket.numbers.contains(it) }
        return Award.of(matchCount)
    }

    private fun hasNotEqualNumber() = numbers.toSet().size == numbers.size

    companion object {
        fun randomTicket(): LottoTicket {
            return LottoTicket(
                (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER).shuffled().subList(0, NUMBER_SIZE)
                    .map { LottoNumber(it) }
            )
        }
    }
}
