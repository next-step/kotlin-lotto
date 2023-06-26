package lotto.domain

class Lottos(
    private val lottos: List<Lotto>
) {

    fun printAll() = lottos.forEach { println(it.toString()) }

    fun numberOfAuto() = lottos.count { it.isAuto() }

    fun numberOfManual() = lottos.count { !it.isAuto() }

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
