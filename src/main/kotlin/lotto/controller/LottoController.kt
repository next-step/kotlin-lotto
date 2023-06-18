package lotto.controller

import lotto.domain.BillSlot
import lotto.domain.LottoNumbers
import lotto.domain.LottoReturn
import lotto.domain.LottoReturnCalculator
import lotto.domain.LottoVendingMachine
import lotto.domain.LottoWinningNumbers
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchasedLottoNumbers = purchaseLotto()
    ResultView.printPurchasedLotto(purchasedLottoNumbers)
    ResultView.printReturn(calculateReturn(purchasedLottoNumbers))
}

private fun purchaseLotto(): PurchasedLottoNumbers {
    val totalLottoCount = BillSlot(LottoVendingMachine.LOTTO_PRICE)
        .insertMoney(InputView.getPurchaseAmount())

    val manualLottoCount = getManualLottoCount(totalLottoCount)
    val manualLottoList = getManualLotto(manualLottoCount)

    val automaticLottoCount = totalLottoCount - manualLottoCount
    val automaticLottoList = LottoVendingMachine.purchase(automaticLottoCount)

    return PurchasedLottoNumbers(manualLottoList, automaticLottoList)
}

private fun calculateReturn(purchasedLottoNumbers: PurchasedLottoNumbers): LottoReturn {
    val lottoNumbersOfLastWeek = getLottoWinningNumbers()
    return LottoReturnCalculator(purchasedLottoNumbers.allLottoList)
        .calculate(lottoNumbersOfLastWeek)
}

private tailrec fun getManualLottoCount(totalLottoCount: Int): Int {
    val manualLottoCount = InputView.getManualLottoCount()
    if (manualLottoCount <= totalLottoCount) return manualLottoCount
    return getManualLottoCount(totalLottoCount)
}

private tailrec fun getManualLotto(count: Int): List<LottoNumbers> {
    runCatching {
        InputView.getManualLotto(count)
            .map { LottoNumbers(it) }
    }.onSuccess {
        return it
    }.onFailure {
        ResultView.printError(it)
    }
    return getManualLotto(count)
}

private tailrec fun getLottoWinningNumbers(): LottoWinningNumbers {
    runCatching {
        LottoWinningNumbers(
            LottoNumbers(InputView.getLottoNumbersOfLastWeek()),
            InputView.getBonusNumber()
        )
    }.onSuccess {
        return it
    }.onFailure {
        ResultView.printError(it)
    }
    return getLottoWinningNumbers()
}
