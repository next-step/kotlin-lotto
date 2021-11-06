package lotto.domain

import lotto.domain.ExceptionType.NOT_DEFINED_HIT

enum class LotteryWinningTypes(val result: LottoGameResult, val winnings: Int) {
    Zero(LottoGameResult(0), 0),
    One(LottoGameResult(1), 0),
    Two(LottoGameResult(2), 0),
    Three(LottoGameResult(3), 5_000),
    Four(LottoGameResult(4), 50_000),
    Five(LottoGameResult(5), 1_500_000),
    FiveWithBonus(LottoGameResult(5, true), 30_000_000),
    Six(LottoGameResult(6), 2_000_000_000);

    companion object {
        const val MINIMUM_WINNING_HITS = 3

        fun findTypeByLottoGameResult(lottoGameResult: LottoGameResult) =
            values().find { it.result == lottoGameResult } ?: throw IllegalArgumentException(NOT_DEFINED_HIT)
    }
}
// 보너스가 있음. -> 근데 hits = 4 rmfja?
