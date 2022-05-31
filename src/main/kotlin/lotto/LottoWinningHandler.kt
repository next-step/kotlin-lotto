package lotto

object LottoWinningHandler {

    fun matchCount(issuedLottos: List<List<Int>>, numbers: List<Int>): Map<Int, Int> {
        val result = mutableMapOf<Int, Int>()

        for (ticket in issuedLottos) {
            val c = count(ticket, numbers)
            result[c] = result[c]?.plus(1) ?: 1
        }

        return result.toMap()
    }

    fun calculateRevenue(scoreInfos: List<ScoreInfo>): Int {
        return scoreInfos.sumOf { it.price }
    }

    private fun count(ticket: List<Int>, winnerNumbers: List<Int>): Int {
        return winnerNumbers.count { ticket.contains(it) }
    }
}
