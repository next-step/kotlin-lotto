package lotto

import lotto.WinningPriceEnum.Companion.find

class WinningLottoTicket(val numbers: List<LottoNumber>, val bonusNumber: LottoNumber) {

    init {
        require(numbers.size == LottoTicket.LOTTO_NUMBER_COUNT)
        require(LottoNumber.LOTTO_NUMBER_RANGE.contains(bonusNumber.number) && !numbers.contains(bonusNumber))
    }

    fun matchCount(issuedLottos: List<LottoTicket>): WinningLottoCounter {
        val result = mutableMapOf<Int, Int>()

        for (i in issuedLottos) {
            val c = count(i.ticketList, numbers)
            result[c] = result[c]?.plus(1) ?: 1
        }

        return createMatchedLottoNumber(result)
    }

    fun matchBonus(issuedLottos: List<LottoTicket>): WinningLottoCounter {
        val result = mutableMapOf<Int, Int>()

        for (i in issuedLottos) {
            val c = count(i.ticketList, listOf(bonusNumber))
            result[c] = result[c]?.plus(1) ?: 1
        }

        return createMatchedLottoNumber(result)
    }

    fun calculateRevenue(scoreInfos: List<ScoreInfo>): Int {
        return scoreInfos.sumOf { it.price }
    }

    private fun count(tickets: List<LottoNumber>, winnerNumbers: List<LottoNumber>): Int {
        return winnerNumbers.count { tickets.contains(it) }
    }

    private fun createMatchedLottoNumber(matchedMap: Map<Int, Int>): WinningLottoCounter {
        return WinningLottoCounter(matchedMap.entries.associate { find(it.key) to it.value })
    }
}
