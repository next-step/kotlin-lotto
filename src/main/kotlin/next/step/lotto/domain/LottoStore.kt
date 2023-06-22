package next.step.lotto.domain

class LottoStore(private val generator: LottoNumberGenerator) {

    fun buy(payment: Int): Lottos {
        val cnt = payment / LOTTO_PRICE
        val lottos = (1..cnt).map { Lotto.of(generator.generate()) }.toSet()
        return if (lottos.size == cnt) Lottos(lottos) else buy(payment)
    }

    fun buy(payment: Int, lottos: Lottos): Int {
        val remained = payment - lottos.size() * LOTTO_PRICE
        require(remained >= 0) { "${payment}원으로는 로또를 ${lottos.size()}개 살 수 없습니다." }
        return remained
    }

    companion object {
        private const val LOTTO_PRICE: Int = 1000

        fun of(generator: LottoNumberGenerator): LottoStore = LottoStore(generator)
    }


}