package lotto.domain

data class Lottos(val lottos: List<Lotto>) {

    fun checkMatching(lotto: Lotto, bonusNumber: LottoNumber): Map<Reward, Int> {
        return lottos.map { Reward.of(it.countMatchedNumbers(lotto), it.containsBonusNumber(bonusNumber)) }
            .groupingBy { it }
            .eachCount()
    }

    companion object {
        fun createLottos(budgets: Budget): Lottos {
            val lottoGenerator = LottoGenerator(RandomNumberGenerator())
            return Lottos(lottoGenerator.generateLottos(budgets))
        }
    }
}
