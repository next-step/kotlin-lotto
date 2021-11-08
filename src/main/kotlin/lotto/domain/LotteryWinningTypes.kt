package lotto.domain

import lotto.domain.ExceptionType.NOT_DEFINED_HIT

enum class LotteryWinningTypes(val result: LottoGameResult, val lottoWinning: LottoWinning) {
    Zero(LottoGameResult(LottoHit(0)), LottoWinning(0)),
    One(LottoGameResult(LottoHit(1)), LottoWinning(0)),
    Two(LottoGameResult(LottoHit(2)), LottoWinning(0)),
    Three(LottoGameResult(LottoHit(3)), LottoWinning(5_000)),
    Four(LottoGameResult(LottoHit(4)), LottoWinning(50_000)),
    Five(LottoGameResult(LottoHit(5)), LottoWinning(1_500_000)),
    FiveWithBonus(LottoGameResult(LottoHit(5), BonusAble(true)), LottoWinning(30_000_000)),
    Six(LottoGameResult(LottoHit(6)), LottoWinning(2_000_000_000));

    companion object {
        val MINIMUM_WINNING_HITS = LottoHit(3)

        fun findTypeByLottoGameResult(lottoGameResult: LottoGameResult) =
            values().find { it.result == lottoGameResult } ?: throw IllegalArgumentException(NOT_DEFINED_HIT)

        fun findTypesByHits(hit: LottoHit) = values().filter { it.result.numberOfHit == hit }
    }
}
