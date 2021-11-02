package lotto.domain

@JvmInline
value class Lottos private constructor(private val lottos: List<Lotto>) {
    fun toList(): List<Lotto> = lottos.toList()

    companion object {
        fun buy(money: Int): Lottos {
            val values = MutableList(money / Lotto.PRICE) { Lotto.generate() }
            return Lottos(values)
        }
    }
}
