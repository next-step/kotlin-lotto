package lotto.view.output

import lotto.model.data.Lottos
import lotto.model.data.Results

interface OutputView {
    fun printLottos(lottos: Lottos)
    fun printResults(results: Results)
}
