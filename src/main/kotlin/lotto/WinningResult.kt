package lotto

class WinningResult(lottoList: List<Lotto>, winningLotto: WinningLotto) {

    private val winningResult = RANKING.values().map { 0 }.toTypedArray()

    init {
        lottoList.forEach { lotto ->
            val winningNumbers = winningLotto.matchNumbers(lotto)
            val ranking = RANKING.countOf(winningNumbers.size, lotto.contains(winningLotto.bonusNumber))
            winningResult[ranking.ordinal] ++
        }
    }

    fun getWinningResult(ranking: RANKING): Int {
        return winningResult[ranking.ordinal]
    }

    fun getWinningPrice(): Int {
        var winningPrice = 0

        RANKING.values().forEach { ranking ->
            winningPrice += ranking.winningPrice * winningResult[ranking.ordinal]
        }
        return winningPrice
    }
}
