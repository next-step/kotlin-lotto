package lotto.view.output

import lotto.model.data.Lotto
import lotto.model.data.Lottos
import lotto.model.data.Results

class ConsoleOutputView(private val printer: ((String) -> Unit) = ::println) : OutputView {

    override fun printLottos(lottos: Lottos) {
        lottos.lottoList.map { it.toDisplayString() }
            .forEach(this.printer)
        this.printer("")
    }

    private fun Lotto.toDisplayString() =
        this.numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")

    override fun printResults(results: Results) {
    }
}

