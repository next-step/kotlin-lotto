package lotto.view.output

import lotto.model.data.Results

interface OutputView {
    fun printResults(results: Results)
}
