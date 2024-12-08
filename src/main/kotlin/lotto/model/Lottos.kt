package lotto.model

class Lottos private constructor(private val lottos: List<Lotto>) {
    fun getLottos() = lottos

    fun countMatchingLottoNumbers(winningNumbers: Lotto): LottoMatchResults {
        val lottoMatchResults =
            lottos
                .map { it.countMatchingNumbers(winningNumbers.getNumbers()) }
                .filter { it >= PRIZE_COUNT }
                .groupingBy { it }
                .eachCount()
                .map { LottoMatchResult(matchPrize = LottoPrize.fromMatchCount(it.key), count = it.value) }

        return LottoMatchResults.from(lottoMatchResults)
    }

    companion object {
        private const val PRIZE_COUNT = 3

        fun fromCountInAuto(count: Int): Lottos = from(List(count) { Lotto.fromAuto() })

        fun from(lottos: List<Lotto>) = Lottos(lottos)
    }
}
