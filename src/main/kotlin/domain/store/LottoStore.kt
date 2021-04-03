package domain.store

import domain.lotto.Lotto
import domain.lotto.LottoNumbers
import domain.money.Money

class LottoStore(val price: Money, private val randomLottoNumberGenerator: RandomLottoNumberGenerator = CommonRandomLottoNumberGenerator()) {
    init {
        require(price > Money.ZERO)
    }

    fun buyLottos(money: Money, manualPicks: List<LottoNumbers> = emptyList()): List<Lotto> {
        val totalLottoCount = money.dividedBy(price)

        require(manualPicks.size <= totalLottoCount)

        val manualPickLottos = generateManualPickLottos(manualPicks)
        val autoPickLottos = generateAutoPickLottos(size = totalLottoCount - manualPickLottos.size)

        return manualPickLottos + autoPickLottos
    }

    private fun generateAutoPickLottos(size: Long) = (1..size).map { generateLotto() }

    private fun generateManualPickLottos(manualPicks: List<LottoNumbers>): List<Lotto> {
        return manualPicks.map { Lotto(it) }
    }

    private fun generateLotto() = Lotto(randomLottoNumberGenerator.generate())
}
