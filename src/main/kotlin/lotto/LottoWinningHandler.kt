package lotto

object LottoWinningHandler {

    fun matchCount(issuedLottos: List<List<Int>>, winningInfo: LottoWinningInfo): MutableMap<Int, Int> {
        val result = mutableMapOf<Int, Int>()

        for (ticket in issuedLottos) {
            val c = count(ticket, winningInfo.getWinningNumbers())
            result[c] = result[c]?.plus(1) ?: 1
        }

        return result
    }

    private fun count(ticket: List<Int>, winnerNumbers: List<Int>): Int {
        return winnerNumbers.count { ticket.contains(it) }
    }
}
