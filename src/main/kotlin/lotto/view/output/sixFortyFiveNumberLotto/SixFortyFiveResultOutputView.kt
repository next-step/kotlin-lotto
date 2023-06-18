package lotto.view.output.sixFortyFiveNumberLotto

import lotto.SixFortyFiveLottoUtils
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinning
import lotto.view.output.OutputView

class SixFortyFiveResultOutputView(lottoList: List<SixFortyFiveLotto>, winningValue: SixFortyFiveLottoWinningNumber) :
    OutputView() {

    init {
        val lottoWinningResultMap = SixFortyFiveLottoUtils.getWinningResultMap()
        val lottoWinningResultList =
            SixFortyFiveLottoUtils.getWinningResultList(lottoList, lottoWinningResultMap, winningValue)
                .filter { it != SixFortyFiveWinning.SECOND }
        val totalResultPrice = SixFortyFiveLottoUtils.getTotalResultPrice(lottoWinningResultList)
        val totalPurchasePrice = SixFortyFiveLottoUtils.getTotalPurchasePrice(lottoList)
        var _message = "당첨 통계\n--------\n"
        listOf(
            SixFortyFiveWinning.FIFTH,
            SixFortyFiveWinning.FOURTH,
            SixFortyFiveWinning.THIRD,
            SixFortyFiveWinning.FIRST,
        ).forEach { winningEnum ->
            val winningEnumCount = lottoWinningResultMap[winningEnum]
            _message =
                _message.plus("${winningEnum.countOfMatch}개 일치 (${winningEnum.price}원) - ${winningEnumCount}개\n")
        }
        message = _message.plus("총 수익률은 ${totalResultPrice / totalPurchasePrice.toDouble()} 입니다.")
    }
}
