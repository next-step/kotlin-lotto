package lotto.domain

import lotto.domain.LottoErrorMessage.OVER_BUDGET
import lotto.vo.LottoPurchaseRequest

class LottoPurchase(
    private val lottoPurchaseRequest: LottoPurchaseRequest
) {
    val manualAmount = lottoPurchaseRequest.manualLottosNumbers.size
    var autoAmount = 0
        private set

    init {
        val priceOfLotto = lottoPurchaseRequest.priceOfLotto
        val allBudget = lottoPurchaseRequest.allBudget

        require(manualAmount * priceOfLotto <= allBudget) { OVER_BUDGET }
    }

    fun purchaseManualAndAuto(): Lottos {
        val manualLottoList = manual()

        val autoBudget = lottoPurchaseRequest.allBudget - (manualAmount * lottoPurchaseRequest.priceOfLotto)
        val autoLottoList = auto(autoBudget)
        return Lottos(manualLottoList.plus(autoLottoList))
    }

    private fun manual(): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()

        lottoPurchaseRequest.manualLottosNumbers.forEach {
            lottoList.add(Lotto.manualCreate(it))
        }
        return lottoList
    }

    private fun auto(autoBudget: Int): List<Lotto> {
        val amount = autoBudget / lottoPurchaseRequest.priceOfLotto

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
