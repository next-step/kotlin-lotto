package lotto.domain

@JvmInline
value class Lottos private constructor(private val lottos: List<Lotto>) {
    fun toList(): List<Lotto> = lottos.toList()

    companion object {
        fun buyAutoLottos(money: Wallet): Lottos {
            val values = MutableList(money.getLeftMoney() / Lotto.PRICE) { Lotto.generate() }
            return Lottos(values)
        }

        fun buyManualLottos(lottoNumbers: List<LottoNumbers>): Lottos {
            val values = lottoNumbers.map { Lotto.from(it) }
            return Lottos(values)
        }
    }
}
