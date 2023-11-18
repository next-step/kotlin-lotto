package lotto.domain

class LottoTicketGenerator {

    @JvmName("createByRandom")
    fun create(): LottoTicket {
        return NUMBERS_RANGE
            .shuffled()
            .take(NUMBERS_COUNT)
            .sorted()
            .map { LottoNumber(it) }
            .let(::LottoTicket)
    }

    @JvmName("createByNumbers")
    fun create(numbers: List<Int>): LottoTicket {
        return numbers.sorted()
            .map { LottoNumber(it) }
            .let(::LottoTicket)
    }

    companion object {
        const val NUMBERS_COUNT = 6
        val NUMBERS_RANGE = 1..45
    }
}
