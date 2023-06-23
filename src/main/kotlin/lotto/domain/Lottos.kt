package lotto.domain

class Lottos(
    private val lottos: List<Lotto>,
) : List<Lotto> by lottos {
    fun getWinningPrizes(winningLotto: WinningLotto): List<Prize> {
        return lottos.map { it.matchPrize(winningLotto) }
            .filter { it.isNotMiss() }
    }

    fun getWinningCountsByPrize(winningLotto: WinningLotto): Map<Prize, Int> {
        val winningCountByPrize = getWinningPrizes(winningLotto)
            .groupingBy { it }
            .eachCount()

        return Prize.values()
            .filter { it.isNotMiss() }
            .reversed()
            .associateWith { winningCountByPrize[it] ?: 0 }
    }

    operator fun plus(other: Lottos): Lottos {
        return Lottos(lottos + other)
    }

    companion object {
        fun auto(quantity: Int): Lottos {
            val randomLottoGenerator = RandomLottoGenerator()
            return Lottos(List(quantity) { Lotto.draw(randomLottoGenerator) })
        }

        fun manual(manualLottoNumbers: List<List<Int>>): Lottos {
            val manualLottoGenerator = ManualLottoGenerator()
            return Lottos(
                manualLottoNumbers.map {
                    Lotto.draw(manualLottoGenerator, it)
                }
            )
        }
    }
}
