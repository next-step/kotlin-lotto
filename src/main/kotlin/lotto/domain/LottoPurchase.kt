package lotto.domain

import lotto.domain.LottoErrorMessage.OVER_BUDGET

class LottoPurchase(
    private val allBudget: Int,
    private val priceOfLotto: Int,
    private val manualLottosNumbers: List<List<Int>>,
) {
    private val manualAmount = manualLottosNumbers.size

    init {
        require(manualAmount * priceOfLotto <= allBudget) { OVER_BUDGET }
    }

    fun purchaseManualAndAuto(): Lottos {
        val manualLottoList = purchaseManual()

        val autoBudget = allBudget - (manualAmount * priceOfLotto)
        val autoLottoList = purchaseAuto(autoBudget)
        return Lottos(manualLottoList.plus(autoLottoList))
    }

    private fun purchaseManual(): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()

        manualLottosNumbers.forEach {
            lottoList.add(Lotto.manualCreate(it))
        }
        return lottoList
    }

    private fun purchaseAuto(autoBudget: Int): List<Lotto> {
        val amount = affordableLottoCount(autoBudget)

        val lottos = buildList {
            repeat(amount) {
                add(Lotto.autoCreate())
            }
        }
        return lottos
    }

    private fun affordableLottoCount(autoBudget: Int): Int {
        return autoBudget / priceOfLotto
    }

    companion object {
        const val DEFAULT_PRICE: Int = 1000
    }
}
