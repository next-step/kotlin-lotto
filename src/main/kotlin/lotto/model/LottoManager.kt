package lotto.model

import lotto.model.generator.ManualNumberGenerator
import lotto.model.lotto.Lotto
import lotto.model.lotto.Numbers
import lotto.model.lotto.WinnerNumbers
import lotto.model.prize.Money
import lotto.model.prize.Winners

class LottoManager(
    private val money: Money,
    manualNumbersList: List<Numbers> = emptyList()
) {
    init {
        money.buyLotto(manualNumbersList.size)
    }

    private val _lottos: MutableList<Lotto> by lazy {
        mutableListOf<Lotto>().apply {
            addAll(manualNumbersList.map { makeManualLotto(it) })
            addAll(generateAutoLottos(money.availableLottoCount()))
        }
    }
    val lottos: List<Lotto>
        get() = _lottos

    private fun generateAutoLottos(autoCount: Int) = (1..autoCount).map { makeAutoLotto() }

    fun checkNumbers(winningNumbers: WinnerNumbers): Winners {
        val winners = lottos.map { it.checkNumbers(winningNumbers) }
        return Winners(winners)
    }

    private fun makeAutoLotto() = Lotto.newInstance()
    private fun makeManualLotto(numbers: Numbers) =
        Lotto.newInstance(ManualNumberGenerator(numbers))
}
