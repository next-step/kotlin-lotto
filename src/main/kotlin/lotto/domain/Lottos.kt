package lotto.domain

data class Lottos(val lottos: List<Lotto>) {

    fun checkMatching(lotto: Lotto): Map<Reward, Int> {
        return lottos.map { Reward.of(it.countMatchedNumbers(lotto)) }
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
