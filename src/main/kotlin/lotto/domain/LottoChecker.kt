package lotto.domain

object LottoChecker {
    private const val WINNING_NUMBER_ERROR_MESSAGE = "당첨번호는 ${Lotto.LOTTO_NUMBER_SIZE}개여야 합니다"
    private const val WINNING_NUMBER_RANGE_ERROR_MESSAGE =
        "당첨번호는 ${Lotto.LOTTO_MIN_NUMBER} ~ ${Lotto.LOTTO_MAX_NUMBER}사이여야 합니다"

    fun checkResult(lottos: List<Lotto>, winNumber: List<Int>): Map<WinningPrize, Int> {
        check(winNumber.size == Lotto.LOTTO_NUMBER_SIZE) { WINNING_NUMBER_ERROR_MESSAGE }
        check(winNumber.find { it !in Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER } == null) { WINNING_NUMBER_RANGE_ERROR_MESSAGE }

        val resultMap = mutableMapOf<WinningPrize, Int>()
        lottos.forEach { lotto ->
            resultMap.addResult(lotto, winNumber)
        }
        return resultMap
    }

    private fun MutableMap<WinningPrize, Int>.addResult(lotto: Lotto, winNumber: List<Int>) {
        val count = winNumber.count { number -> number in lotto.numbers }
        if (count >= Lotto.LOTTO_WINNING_MIN_COUNT) {
            val winningAmount = WinningPrize.of(count)
            this[winningAmount] = this.getOrDefault(winningAmount, 0) + 1
        }
    }
}
