package lotto.domain

class LottoPurchase {

    fun purchaseManualAndAuto(manualLottosNumbers: List<List<Int>>, budget: Int, priceOfLotto: Int): Lottos {
        val manualAmount = manualLottosNumbers.size
        val manualLottoList = purchaseManual(manualLottosNumbers)

        val autoBudget = budget - (manualAmount * priceOfLotto)
        val autoLottoList = purchaseAuto(autoBudget, priceOfLotto)
        return Lottos(manualLottoList.plus(autoLottoList))
    }

    private fun purchaseManual(manualLottosNumbers: List<List<Int>>): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()

        manualLottosNumbers.forEach {
            lottoList.add(Lotto.manualCreate(it))
        }
        return lottoList
    }

    private fun purchaseAuto(budget: Int, priceOfLotto: Int): List<Lotto> {
        val amount = affordableLottoCount(budget, priceOfLotto)

        val lottos = buildList {
            repeat(amount) {
                add(Lotto.autoCreate())
            }
        }
        return lottos
    }

    private fun affordableLottoCount(budget: Int, priceOfLotto: Int): Int {
        return budget / priceOfLotto
    }

    companion object {
        const val DEFAULT_PRICE: Int = 1000
    }
}
