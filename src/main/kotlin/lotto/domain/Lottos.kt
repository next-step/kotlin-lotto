package lotto.domain

class Lottos(
    val lottos: List<Lotto>
) {

    fun numberOfAuto() = lottos.count { it.auto }

    fun numberOfManual() = lottos.count { !it.auto }

    fun winningMap(winningLotto: WinningLotto): WinningMap {
        val map = mutableMapOf<LottoPrizes, Int>()

        lottos.forEach { lotto ->
            val equalCount = lotto.numberOfMatch(winningLotto)
            val isCatchBonus = lotto.isCatchBonus(winningLotto)
            val prize = LottoPrizes.of(equalCount, isCatchBonus)

            map[prize] = map.getOrDefault(prize, 0) + 1
        }

        return WinningMap(map)
    }
}
