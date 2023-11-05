package lotto.domain

class LottoTicketGenerator(
    private val numbersRange: IntRange = LottoSpec.NUMBERS_RANGE,
    private val numbersCount: Int = LottoSpec.NUMBERS_COUNT,
) {
    init {
        require(numbersRange.count() >= numbersCount) { "로또의 범위의 수 개수 보다 많은 개수를 추출할 수는 없습니다" }
    }

    fun create(): LottoTicket {
        val numbers = numbersRange
            .shuffled()
            .take(numbersCount)
            .sorted()
        return LottoTicket(numbers)
    }
}
