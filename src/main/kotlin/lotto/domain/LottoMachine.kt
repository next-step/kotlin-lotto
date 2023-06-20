package lotto.domain

class LottoMachine(private val lottoFactory: LottoFactory) {

    fun buyAuto(cost: Int): List<Lotto> {
        val count = cost / LOTTO_COST
        return List(count) { lottoFactory.create() }
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
