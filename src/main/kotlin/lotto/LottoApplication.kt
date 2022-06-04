package lotto

import lotto.ui.LottoInputTitle
import lotto.ui.LottoResponse
import java.math.BigDecimal

fun main() {

    val lottoMachine = LottoMachine(AutoLottoMaker(), ManualLottoMaker())

    val lottoSeller = paidMoneyToLottoSeller()

    buyLottos(lottoSeller, lottoMachine)

    val winningLotto = selectWinningLotto()

    showStatistics(winningLotto, lottoMachine)
}

private fun showStatistics(winningLotto: WinningLotto, lottoMachine: LottoMachine) {
    LottoResponse.responseStatisticTitle()
    val statistics = Statistics(winningLotto, lottoMachine.lottos.lotto)
    LottoResponse.responseStatistics(statistics.getWinningResult(), statistics.getYield())
}

private fun selectWinningLotto(): WinningLotto {
    LottoInputTitle.requestWinningLotto()
    val inputWinningLottoNumber = readln()

    LottoInputTitle.requestWinningLottoBonusNumber()
    val inputWinningBonusNumber = readln()

    return WinningLotto(convertWinningLotto(inputWinningLottoNumber), LottoNumber(inputWinningBonusNumber.toInt()))
}

private fun buyLottos(lottoSeller: LottoSeller, lottoMachine: LottoMachine) {
    LottoInputTitle.requestBuyManualLottoCount()
    val inputManualLottoCount = readln().toInt()
    lottoSeller.buyManual(inputManualLottoCount)

    LottoInputTitle.requestBuyManualLotto()
    repeat(inputManualLottoCount) {
        lottoMachine.buyManualLotto(convertWinningLotto(readln()).toList())
    }

    LottoResponse.responsePurchase(inputManualLottoCount, lottoSeller.getLottoCount())

    lottoMachine.buyLotto(lottoSeller.getLottoCount())
    LottoResponse.responseLottos(lottoMachine.lottos.lotto)
}

private fun paidMoneyToLottoSeller(): LottoSeller {
    LottoInputTitle.requestPurchaseLotto()
    return LottoSeller(Money(BigDecimal(readln().toInt())))
}

fun convertWinningLotto(lottoString: String): HashSet<LottoNumber> {
    val lottoStrings = lottoString.split(", ")
    return lottoStrings.map { CachedLottoNumbers.getLottoNumber(it.toInt()) }
        .toHashSet()
}
