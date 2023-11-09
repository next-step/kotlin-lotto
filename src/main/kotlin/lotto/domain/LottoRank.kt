package lotto.domain

enum class LottoRank(
    val lottoWinningResult: LottoWinningResult,
    val amount: Int
) {

    FIRST(LottoWinningResult(6, false), 2_000_000_000),
    SECOND(LottoWinningResult(5, true), 30_000_000),
    THIRD(LottoWinningResult(5, false), 1_500_000),
    FOURTH(LottoWinningResult(4, false), 50_000),
    FIFTH(LottoWinningResult(3, false), 5_000)
    ;

    companion object {
        fun valueOf(lottoWinningResult: LottoWinningResult) = values()
            .find { it.lottoWinningResult == lottoWinningResult }
    }
}
