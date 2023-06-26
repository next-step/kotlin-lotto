package lotto.domain

class Lottos(
    val lottos: List<Lotto>
) {

    fun countAutoLottos() = lottos.count { it.auto }

    fun countManualLottos() = lottos.count { !it.auto }

    fun generateWinningMap(winningLotto: WinningLotto): Map<LottoPrizes, Int> {
        val map = mutableMapOf<LottoPrizes, Int>()

        lottos.forEach { lotto ->
            val equalCount = lotto.checkEqualCount(winningLotto)
            val isCatchBonus = lotto.isCatchBonus(winningLotto)
            val prize = LottoPrizes.of(equalCount, isCatchBonus)

            map[prize] = map.getOrDefault(prize, 0) + 1
        }

        return map
    }
}
