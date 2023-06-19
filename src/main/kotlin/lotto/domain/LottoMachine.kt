package lotto.domain

class LottoMachine(private val lottoFactory: LottoFactory) {

    fun buyAuto(cost: Int): List<Lotto> {
        val count = cost / LOTTO_COST
        return (1..count).map { lottoFactory.create() }
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
