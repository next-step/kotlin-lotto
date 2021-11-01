package lotto.domain

data class Lottos(val lottos: List<Lotto>) {

    fun getMatchedRewards(lotto: Lotto, bonusNumber: LottoNumber): Map<Reward, Int> {
        return lottos.map { Reward.of(it.countMatchedNumbers(lotto), it.containsBonusNumber(bonusNumber)) }
            .groupingBy { it }
            .eachCount()
    }

    companion object {
        fun createLottos(purchaseInformation: PurchaseInformation): Lottos {
            val lottoAutoGenerator = LottoAutoGenerator(purchaseInformation)
            val autoGenerateLottos = lottoAutoGenerator.generateLottos()

            val lottoManualGenerator = LottoManualGenerator(purchaseInformation)
            val manualGenerateLottos = lottoManualGenerator.generateLottos()

            return Lottos(autoGenerateLottos + manualGenerateLottos)
        }
    }
}
