package lotto.view

import lotto.domain.LottoGameResult
import lotto.domain.LottoNumbers
import lotto.domain.LottoReward
import lotto.extension.appendIf
import java.text.DecimalFormat

fun LottoNumbers.state(): String =
    value.map { it.value }.toString()

fun LottoGameResult.state(): String {
    val stringBuilder = StringBuilder()
    LottoReward.values().reversed().forEach {
        val rewardCount = getRewardCount(it)
        stringBuilder
            .append("${it.matchCount}개 일치")
            .appendIf(", 보너스 볼 일치", it.bonusMatch)
            .append(" (${it.reward}원) - ${rewardCount}개")
            .append("\n")
    }
    val performance = DecimalFormat("#,##0.00").format(calculatePerformance())
    stringBuilder.append("총 수익률은 ${performance}입니다.")
    return stringBuilder.toString()
}
