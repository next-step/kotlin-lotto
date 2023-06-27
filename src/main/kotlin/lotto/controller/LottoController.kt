package lotto.controller

import lotto.domain.BillSlot
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoReturn
import lotto.domain.LottoReturnCalculator
import lotto.domain.LottoVendingMachine
import lotto.domain.LottoWinningNumbers
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchasedLottos = purchaseLotto()
    ResultView.printPurchasedLotto(purchasedLottos)
    ResultView.printReturn(calculateReturn(purchasedLottos))
}

private fun purchaseLotto(): PurchasedLottos {
    val totalLottoCount = BillSlot(LottoVendingMachine.LOTTO_PRICE)
        .insertMoney(InputView.getPurchaseAmount())

    val manualLottoCount = getManualLottoCount(totalLottoCount)
    val manualLottos = getManualLotto(manualLottoCount)

    val automaticLottoCount = totalLottoCount - manualLottoCount
    val automaticLottos = LottoVendingMachine.purchase(automaticLottoCount)

    return PurchasedLottos(manualLottos, automaticLottos)
}

private fun calculateReturn(purchasedLottos: PurchasedLottos): LottoReturn {
    val lottoNumbersOfLastWeek = getLottoWinningNumbers()
    return LottoReturnCalculator(purchasedLottos.allLottos)
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
            .map { LottoNumbers.fromNumbers(it) }
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
            LottoNumbers.fromNumbers(InputView.getLottoNumbersOfLastWeek()),
            LottoNumber.get(InputView.getBonusNumber())
        )
    }.onSuccess {
        return it
    }.onFailure {
        ResultView.printError(it)
    }
    return getLottoWinningNumbers()
}
