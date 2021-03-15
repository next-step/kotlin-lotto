package lotto.domain

import lotto.vo.WinningLotto

class LottoBasket(private val lottos: List<Lotto>) : List<Lotto> by lottos {
    fun match(winningNumber: WinningLotto): Map<LottoPrize, Int> {
        val winningLottos = mutableListOf<LottoPrize>()
        lottos.forEach {
            winningLottos.add(it.match(winningNumber))
        }
        return winningLottos.groupingBy { it }.eachCount()
    }

    fun getLottoCount(): Int {
        return lottos.size
    }

    fun doLottos(func: (Lotto) -> Unit) {
        lottos.forEach {
            func(it)
        }
    }
}
