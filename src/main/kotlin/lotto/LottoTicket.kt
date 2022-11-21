package lotto

private const val NUMBER_SIZE = 6

class LottoTicket(
    private val numbers: List<LottoNumber>
) {

    constructor(vararg values: Int) : this(List(values.size) { idx -> LottoNumber(values[idx]) })

    init {
        require(numbers.size == NUMBER_SIZE) { "로또 번호의 갯수는 ${numbers.size} 일 수 없으며 6 개만 가능합니다." }
    }


    fun matchScratch(lottoTicket: LottoTicket): Award {
        val matchCount = numbers.count { lottoTicket.numbers.contains(it) }
        return Award.of(matchCount)
    }

}
