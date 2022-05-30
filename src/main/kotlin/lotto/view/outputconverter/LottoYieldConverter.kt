package lotto.view.outputconverter

import lotto.domain.model.LottoYield
import java.text.DecimalFormat

object LottoYieldConverter : OutputConverter<LottoYield> {
    override fun convert(printable: LottoYield): String {
        return "총 수익률은 ${printable.toPrintableText()}입니다.${printable.getLossText()}"
    }

    private fun LottoYield.toPrintableText(): String {
        val df = DecimalFormat("0.00")

        return df.format(value)
    }

    private fun LottoYield.getLossText(): String = if (isLoss()) {
        "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    } else {
        ""
    }
}
