package lotto.domain

import lotto.domain.LottoNumber.Companion.MINIMUM_NUMBER
import lotto.domain.LottoNumber.Companion.MAXIMUM_NUMBER

class LottoTicket constructor(val lottos: List<Lotto>) {
    constructor(count: Int) : this(
        List(count) {
            Lotto(
                (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled().take(TAKE_NUMBER).sorted()
            )
        }
    )

    constructor(money: Money) : this((money / LOTTO_PRICE).toInt())

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
    }
}
