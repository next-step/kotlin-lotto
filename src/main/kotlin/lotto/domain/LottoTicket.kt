package lotto.domain

import lotto.domain.LottoNumber.Companion.MINIMUM_NUMBER
import lotto.domain.LottoNumber.Companion.MAXIMUM_NUMBER

class LottoTicket(val lottos: List<Lotto>) {
    constructor(count: Int, lottos: List<Lotto> = listOf()) : this(
        lottos +
            List(count) {
                Lotto(
                    (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled().take(TAKE_NUMBER).sorted()
                )
            }
    )

    constructor(money: Money) : this(lottoCount(money))
    constructor(money: Money, lottos: List<Lotto>) : this(lottoCount(money), lottos)

    fun match(winningLotto: WinningLotto): LottoResult {
        val result = lottos.map { winningLotto.match(it) }.groupingBy { it }.eachCount()
        return LottoResult(result)
    }

    override fun toString(): String {
        return "$lottos"
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val TAKE_NUMBER = 6
        private fun lottoCount(money: Money) = (money / LOTTO_PRICE).toInt()
    }
}
