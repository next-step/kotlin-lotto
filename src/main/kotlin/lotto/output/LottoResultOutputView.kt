package lotto.output

import lotto.domain.LottoResult
import lotto.domain.Rank

class LottoResultOutputView() {
    companion object {
        fun print(lottoResult: LottoResult) {
            val matchMap = lottoResult.matchMap
            println(
                """
당첨 통계
${
                    Rank.entries.filter { it != Rank.MISS }
                        .sorted()
                        .reversed()
                        .joinToString("\n") {
                            val matchDescription =
                                when (it) {
                                    Rank.SECOND -> "${it.countOfMatch}개 일치, 보너스 볼 일치"
                                    else -> "${it.countOfMatch}개 일치"
                                }
                            "$matchDescription (${it.winningMoney}원)- ${
                                matchMap.getOrDefault(it, 0)
                            }개"
                        }
                }
총 수익률은 %.2f 입니다."
"""
                    .trimIndent()
                    .format(lottoResult.rateOfReturn),
            )
        }
    }
}
