import Money.Companion.NO_MONEY
import Money.Companion.plus

class LottoRoundStatistics(
    lottos: List<Lotto>,
    private val winningLotto: Lotto
) {
    val lottoResults: List<LottoResult> = lottos.map { LottoResult(it, winningLotto) }

    val totalPrize: Money = lottoResults.mapNotNull { it.reward }
        .fold(NO_MONEY) { money, lottoReward ->
            money + lottoReward.toMoney()
        }

    fun getLottoRewardOf(lottoReward: LottoReward): List<LottoResult> = lottoResults.filter { it.reward == lottoReward }.toList()
}

@JvmInline value class Money(val value: Long) {
    companion object {
        fun Long.toMoney(): Money = Money(this)

        operator fun Money.plus(other: Money): Money = (value + other.value).toMoney()

        val NO_MONEY: Money = 0L.toMoney()
    }
}
