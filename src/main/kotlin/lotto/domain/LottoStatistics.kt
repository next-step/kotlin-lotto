package lotto.domain

class LottoStatistics(
    lottos: List<Lotto>,
    private val winningLotto: WinningLotto
){
    private val countsMap = mutableMapOf<Int, Int>()

    var totalPrizes = 0
        private set

    init {
        lottos.forEach {
            val equalCount = winningLotto.checkEqualCount(it.numbers)
            countsMap[equalCount] = countsMap.getOrDefault(equalCount, 0) + 1

            val prize = LottoPrizes.getMoney(equalCount)
            totalPrizes += prize
        }
    }

    fun getEqualCount(equalCount: Int): Int {
        return countsMap.getOrDefault(equalCount, 0)
    }
}
