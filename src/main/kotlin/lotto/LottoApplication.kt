package lotto

import lotto.ui.LottoInputTitle
import lotto.ui.LottoResponse
import java.math.BigDecimal

fun main() {

    val lottoMachine = LottoMachine(AutoLottoMaker(), ManualLottoMaker())

    LottoInputTitle.requestPurchaseLotto()
    val lottoSeller = LottoSeller(Money(BigDecimal(readln().toInt())))

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

    LottoInputTitle.requestWinningLotto()
    val inputWinningLottoNumber = readln()

    LottoInputTitle.requestWinningLottoBonusNumber()
    val inputWinningBonusNumber = readln()

    val winningLotto = WinningLotto(convertWinningLotto(inputWinningLottoNumber), LottoNumber(inputWinningBonusNumber.toInt()))

    LottoResponse.responseStatisticTitle()
    val statistics = Statistics(winningLotto, lottoMachine.lottos.lotto)
    LottoResponse.responseStatistics(statistics.getWinningResult(), statistics.getYield())
}

fun convertWinningLotto(lottoString: String): HashSet<LottoNumber> {
    val lottoStrings = lottoString.split(", ")
    return lottoStrings.map { CachedLottoNumbers.getLottoNumber(it.toInt()) }
        .toHashSet()
}
