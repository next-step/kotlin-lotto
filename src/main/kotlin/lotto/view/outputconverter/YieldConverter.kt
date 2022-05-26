package lotto.view.outputconverter

import lotto.domain.model.Yield
import java.text.DecimalFormat

object YieldConverter : OutputConverter<Yield> {
    override fun convert(printable: Yield): String {
        return "총 수익률은 ${printable.toPrintableText()}입니다.${printable.getLossText()}"
    }

    private fun Yield.toPrintableText(): String {
        val df = DecimalFormat("#.00")

        return df.format(value)
    }

    private fun Yield.getLossText(): String = if (isLoss()) {
        "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    } else {
        ""
    }
}
