package lotto.domain

import lotto.domain.LottoPrice.Companion.LOTTO_PRICE

@JvmInline
value class Lottos private constructor(private val lottos: List<Lotto>) {

    fun correspondToWinningNumber(winningNumber: List<Int>): List<LottoResult> =
        LottoResults(lottos).result(winningNumber)

    fun toList(): List<Lotto> = lottos.toList()

    companion object {
        fun buy(money: Int): Lottos {
            val values = MutableList(money / LOTTO_PRICE) { Lotto() }
            return Lottos(values)
        }
    }
}
