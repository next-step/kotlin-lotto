package lotto.view.order.impl

import lotto.model.LottoGame
import lotto.model.LottoNumber
import lotto.view.InputView
import lotto.view.order.LottoOrderStrategy

object LottoManualOrderStrategy : LottoOrderStrategy {

    override fun issue(count: Int): List<LottoGame> {
        return InputView.manualOrderNumbers(count)
            .asSequence()
            .map { input -> manualIssue(input) }
            .toList()
    }

    fun manualIssue(manualLottoGameInput: String): LottoGame {
        return LottoGame(
            manualLottoGameInput.split(DELIMITER)
                .map { LottoNumber(it.toInt()) }
                .toSet()
        )
    }

    private const val DELIMITER: String = ","
}
