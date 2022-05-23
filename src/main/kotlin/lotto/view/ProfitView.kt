package lotto.view

import lotto.domain.Profit

class ProfitView(private val output: Output) {

    fun print(profit: Profit) {
        output.print(
            "총 수익률은 ${String.format("%.2f", profit.value)}입니다.${getSuffix(profit.value)}"
        )
    }

    private fun getSuffix(value: Double): String =
        if (value < 1.0) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        else ""
}
