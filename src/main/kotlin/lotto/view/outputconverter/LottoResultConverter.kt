package lotto.view.outputconverter

import lotto.domain.model.LottoRank
import lotto.domain.model.LottoResult
import lotto.domain.model.LottoWinning

object LottoResultConverter : OutputConverter<LottoResult> {
    private const val GUIDANCE_MESSAGE = "당첨 통계"
    private const val DIVIDER = "---------"

    override fun convert(printable: LottoResult): String {
        val lottoWinningMessages = printable.value.joinToString("\n") { lottoWinning ->
            lottoWinning.toPrintableText()
        }
        return "$GUIDANCE_MESSAGE\n$DIVIDER\n$lottoWinningMessages"
    }

    private fun LottoWinning.toPrintableText(): String {
        return "${rank.numberOfMatches}개 일치${rank.bonusBallText()}(${rank.winnings}원) - ${count}개"
    }

    private fun LottoRank.bonusBallText(): String {
        return if (this == LottoRank.SECOND) ", 보너스 볼 일치" else " "
    }
}
