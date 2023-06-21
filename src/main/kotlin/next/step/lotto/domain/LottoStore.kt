package next.step.lotto.domain

object LottoStore {

    private const val LOTTO_PRICE: Int = 1000

    fun buy(payment: Int, algorithm: LottoNumberGenerationAlgorithm): Lottos {
        val cnt = payment / LOTTO_PRICE
        val lottos = (1..cnt).map { Lotto.of(algorithm()) }.toSet()
        return if (lottos.size == cnt) Lottos(lottos) else buy(payment, algorithm)
    }

    fun buy(payment: Int, lottos: Lottos): Int {
        val remained = payment - lottos.size() * LOTTO_PRICE
        require(remained >= 0) { "${payment}원으로는 로또를 ${lottos.size()}개 살 수 없습니다." }
        return remained
    }


}