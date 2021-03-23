package domain.store

import domain.lotto.Lotto
import domain.money.Money

class LottoStore(val price: Money, private val randomLottoNumberGenerator: RandomLottoNumberGenerator = CommonRandomLottoNumberGenerator()) {
    init {
        require(price > Money.ZERO)
    }

    fun buyLottos(money: Money): List<Lotto> {
        return (1..(money.dividedBy(price))).map { generateLotto() }
    }

    private fun generateLotto() = Lotto(randomLottoNumberGenerator.generate())
}
