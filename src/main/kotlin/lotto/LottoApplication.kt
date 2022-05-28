package lotto

import lotto.ui.LottoInputTitle
import lotto.ui.LottoResponse
import java.math.BigDecimal

fun main() {

    LottoInputTitle.requestPurchaseLotto()
    val lottoSeller = LottoSeller(Money(BigDecimal(readln().toInt())))
    LottoResponse.responsePurchase(lottoSeller.getLottoCount())

    val lottoMachine = LottoMachine(AutoLottoMaker())
    val buyLottos = lottoMachine.buyLotto(lottoSeller.getLottoCount())
    LottoResponse.responseLottos(buyLottos.lottos)

    LottoInputTitle.requestWinningLotto()
    val winningLotto = WinningLotto(convertWinningLotto(readln()))

    LottoResponse.responseStatisticTitle()
    val statistics = Statistics(winningLotto, buyLottos.lottos)
    LottoResponse.responseStatistics(statistics.getWinningResult(), statistics.getYield())
}

fun convertWinningLotto(lottoString: String): HashSet<LottoNumber> {
    val lottoStrings = lottoString.split(", ")
    return lottoStrings.map { CachedLottoNumbers.getLottoNumber(it.toInt()) }
        .toHashSet()
}
