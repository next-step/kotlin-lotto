package lotto.domain

import lotto.domain.LottoNumber.Companion.MAX_NUMBER
import lotto.domain.LottoNumber.Companion.MIN_NUMBER

class LottoTicket(val lottos: List<Lotto>) {
    constructor(count: Int, lottos: List<Lotto> = listOf()) : this(
        lottos + List(count) {
            Lotto.of(
                (MIN_NUMBER..MAX_NUMBER).shuffled().take(TAKE_NUMBER).sorted()
            )
        }
    )

    constructor(money: Money) : this((money / LOTTO_PRICE).toInt())
    constructor(money: Money, lottos: List<Lotto>) : this((money / LOTTO_PRICE).toInt() - lottos.size, lottos)

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
