package lotto.domain

import lotto.domain.LottoErrorMessage.OVER_BUDGET
import lotto.vo.OrderRequest

class LottoPurchase(
    private val orderRequest: OrderRequest
) {
    val manualAmount = orderRequest.manualLottosNumbers.size
    var autoAmount = 0
        private set

    init {
        val priceOfLotto = orderRequest.priceOfLotto
        val allBudget = orderRequest.allBudget

        require(manualAmount * priceOfLotto <= allBudget) { OVER_BUDGET }
    }

    fun purchaseManualAndAuto(): Lottos {
        val manualLottoList = manual()

        val autoBudget = orderRequest.allBudget - (manualAmount * orderRequest.priceOfLotto)
        val autoLottoList = auto(autoBudget)
        return Lottos(manualLottoList.plus(autoLottoList))
    }

    private fun manual(): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()

        orderRequest.manualLottosNumbers.forEach {
            lottoList.add(Lotto.manualCreate(it))
        }
        return lottoList
    }

    private fun auto(autoBudget: Int): List<Lotto> {
        val amount = autoBudget / orderRequest.priceOfLotto

        val lottos = buildList {
            repeat(amount) {
                add(Lotto.autoCreate())
            }
        }
        autoAmount = amount

        return lottos
    }

    companion object {
        const val DEFAULT_PRICE: Int = 1000
    }
}
