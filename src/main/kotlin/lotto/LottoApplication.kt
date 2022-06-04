package lotto

import lotto.ui.LottoInputTitle
import lotto.ui.LottoResponse
import java.math.BigDecimal

fun main() {

    val lottoMachine = LottoMachine(AutoLottoMaker(), ManualLottoMaker())

    val lottoSeller = paidMoneyToLottoSeller()

    val lottos = buyLottos(lottoSeller, lottoMachine)

    val winningLotto = selectWinningLotto()

    showStatistics(winningLotto, lottos)
}

private fun showStatistics(winningLotto: WinningLotto, lottos: Lottos) {
    LottoResponse.responseStatisticTitle()
    val statistics = Statistics(winningLotto, lottos.lottos)
    LottoResponse.responseStatistics(statistics.getWinningResult(), statistics.getYield())
}

private fun selectWinningLotto(): WinningLotto {
    LottoInputTitle.requestWinningLotto()
    val inputWinningLottoNumber = readln()

    LottoInputTitle.requestWinningLottoBonusNumber()
    val inputWinningBonusNumber = readln()

    return WinningLotto(convertLotto(inputWinningLottoNumber), LottoNumber(inputWinningBonusNumber.toInt()))
}

private fun buyLottos(lottoSeller: LottoSeller, lottoMachine: LottoMachine) : Lottos {
    LottoInputTitle.requestBuyManualLottoCount()
    val inputManualLottoCount = readln().toInt()
    lottoSeller.buyManual(inputManualLottoCount)

    val manualLottos = buyManualLottos(inputManualLottoCount, lottoMachine)
    val autoLottos = buyAutoLottos(inputManualLottoCount, lottoSeller, lottoMachine)
    manualLottos.addAll(autoLottos.toList())

    val lottos = Lottos(manualLottos.toList())
    LottoResponse.responseLottos(lottos.lottos)
    return lottos
}

private fun buyAutoLottos(inputManualLottoCount: Int, lottoSeller: LottoSeller, lottoMachine: LottoMachine) : List<Lotto> {
    LottoResponse.responsePurchase(inputManualLottoCount, lottoSeller.getLottoCount())
    return lottoMachine.buyLotto(lottoSeller.getLottoCount())
}

private fun buyManualLottos(inputManualLottoCount: Int, lottoMachine: LottoMachine): MutableList<Lotto> {
    LottoInputTitle.requestBuyManualLotto()
    val manualLottos: MutableList<Lotto> = mutableListOf()
    repeat(inputManualLottoCount) {
        manualLottos.add(lottoMachine.buyManualLotto(convertLotto(readln()).toList()))
    }
    return manualLottos
}

private fun paidMoneyToLottoSeller(): LottoSeller {
    LottoInputTitle.requestPurchaseLotto()
    return LottoSeller(Money(BigDecimal(readln().toInt())))
}

fun convertLotto(lottoString: String): HashSet<LottoNumber> {
    val lottoStrings = lottoString.split(", ")
    return lottoStrings.map { CachedLottoNumbers.getLottoNumber(it.toInt()) }
        .toHashSet()
}
