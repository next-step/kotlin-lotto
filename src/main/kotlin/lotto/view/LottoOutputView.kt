package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoReward
import lotto.domain.LottoRoundStatistics

class LottoOutputView {
    fun currentLottos(lottos: List<Lotto>) {
        val lottoSize = lottos.size
        println("${lottoSize}개를 구매했습니다.")
        repeat(lottoSize) { index ->
            lottos[index].lottoNumbers.map { it.number }.joinToString(prefix = "[", separator = ", ", postfix = "]").also { println(it) }
        }
    }

    fun result(payment: Long, lottoRoundStatistics: LottoRoundStatistics) {
        println(WINNING_C0MMENT)

        with(LottoReward.WINNER_4ST) {
            lottoRoundStatistics.getLottoRewardOf(this).run {
                println("${sameNumberCount}개 일치 (${prize}원)- $size")
            }
        }

        with(LottoReward.WINNER_3ST) {
            lottoRoundStatistics.getLottoRewardOf(this).run {
                println("${sameNumberCount}개 일치 (${prize}원)- $size")
            }
        }

        with(LottoReward.WINNER_2ST) {
            lottoRoundStatistics.getLottoRewardOf(this).run {
                println("${sameNumberCount}개 일치 (${prize}원)- $size")
            }
        }

        with(LottoReward.WINNER_1ST) {
            lottoRoundStatistics.getLottoRewardOf(this).run {
                println("${sameNumberCount}개 일치 (${prize}원)- $size")
            }
        }

        println("총 수익률은 ${lottoRoundStatistics.totalPrize.value / payment}입니다.")
    }

    companion object {
        private const val WINNING_C0MMENT = """당첨 통계
            |---------
        """
    }
}
