package lotto

import lotto.ui.Request
import lotto.ui.Response
import java.math.BigDecimal

fun main() {

    Request.requestPurchaseLotto()
    val lottoSeller = LottoSeller(Money(BigDecimal(readln().toInt())))
    Response.responsePurchase(lottoSeller.getLottoCount())

    val lottoMachine = LottoMachine(AutoLottoMaker())
    val buyLottos = lottoMachine.buyLotto(lottoSeller.getLottoCount())
    Response.responseLottos(buyLottos.get)

    Request.requestWinningLotto()
    val winningLotto = WinningLotto(convertWinningLotto(readln()))

    Response.responseStatisticTitle()
    val statistics = Statistics(winningLotto, buyLottos.get)
    Response.responseStatistics(statistics.getWinningResult(), statistics.getYield())
}

fun convertWinningLotto(lottoString: String): HashSet<LottoNumber> {
    val lottoStrings = lottoString.split(", ")
    return lottoStrings.map { CachedLottoNumbers.getLottoNumber(it.toInt()) }
        .toHashSet()
}
