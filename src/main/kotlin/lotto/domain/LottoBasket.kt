package lotto.domain

import lotto.vo.WinningLotto

class LottoBasket(val lottos: List<Lotto>) : List<Lotto> by lottos {
    fun match(winningNumber: WinningLotto): Map<LottoPrize, Int> {
        return lottos.map { it.match(winningNumber) }.groupingBy { it }.eachCount()
    }
}
