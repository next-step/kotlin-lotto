package lotto.model

class Lottos private constructor(private val lottos: List<Lotto>) {
    fun getLottos() = lottos

    fun countMatchingLottoNumbers(winningNumbers: WinningNumbers): LottoMatchResults {
        val winningNumberList = winningNumbers.winnigLottoNumbers
        val bonusNumber = winningNumbers.bonusNumber

        val lottoMatchResults =
            lottos
                .map { lotto ->
                    val matchCount = lotto.countMatchingNumbers(winningNumberList)
                    val hasBonus = (matchCount == 5) && lotto.numbers.contains(bonusNumber)
                    LottoPrize.fromMatchCount(matchCount, hasBonus)
                }
                .filter { it != LottoPrize.NONE } // 당첨되지 않은 로또는 제외
                .groupingBy { it }
                .eachCount()
                .map { (prize, count) ->
                    LottoMatchResult(matchPrize = prize, count = count)
                }

        return LottoMatchResults.from(lottoMatchResults)
    }

    companion object {
        private const val PRIZE_COUNT = 3

        fun fromCountInAuto(count: Int): Lottos = from(List(count) { Lotto.fromAuto() })

        fun from(lottos: List<Lotto>) = Lottos(lottos)
    }
}
