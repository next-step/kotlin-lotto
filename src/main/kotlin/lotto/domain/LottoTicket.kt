package lotto.domain

class LottoTicket(val lottoNums: List<LottoNum>) {

    fun matchingCount(winNums: LottoTicket): Int {
        return (lottoNums + winNums.lottoNums)
            .groupBy { it }
            .filter { it.value.size > 1 }
            .flatMap { it.value }
            .distinct()
            .count()
    }

    companion object {
        const val TICKET_PRICE = 1_000
    }
}
