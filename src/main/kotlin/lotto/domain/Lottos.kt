package lotto.domain

data class Lottos(val lottos: List<Lotto>) {

    fun getMatchedRewards(lotto: Lotto, bonusNumber: LottoNumber): Map<Reward, Int> {
        return lottos.map { Reward.of(it.countMatchedNumbers(lotto), it.containsBonusNumber(bonusNumber)) }
            .groupingBy { it }
            .eachCount()
    }

    companion object {
        fun createLottos(purchaseInformation: PurchaseInformation): Lottos {
            val lottoGenerator = LottoGenerator(RandomNumberGenerator())
            return Lottos(lottoGenerator.generateLottos(purchaseInformation))
        }
    }
}
