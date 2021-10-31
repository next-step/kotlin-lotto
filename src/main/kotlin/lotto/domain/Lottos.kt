package lotto.domain

@JvmInline
value class Lottos private constructor(private val lottos: List<Lotto>) {

    fun correspondToWinningNumber(winningNumber: List<Int>): List<LottoResult> =
        LottoResults(lottos).result(winningNumber)

    fun toList(): List<Lotto> = lottos.toList()

    companion object {
        fun buy(money: Int): Lottos {
            val values = MutableList(money / Lotto.PRICE) { Lotto() }
            return Lottos(values)
        }
    }
}
