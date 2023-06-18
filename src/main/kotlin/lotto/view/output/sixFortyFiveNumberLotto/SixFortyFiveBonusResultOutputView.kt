package lotto.view.output.sixFortyFiveNumberLotto

import lotto.SixFortyFiveLottoUtils
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinning
import lotto.view.output.OutputView

class SixFortyFiveBonusResultOutputView(
    lottoList: List<SixFortyFiveLotto>,
    winningValue: SixFortyFiveLottoWinningNumber,
) : OutputView() {

    init {
        val lottoWinningResultMap = SixFortyFiveLottoUtils.getWinningResultMap()
        val lottoWinningResultList = SixFortyFiveLottoUtils.getWinningResultList(lottoList, lottoWinningResultMap, winningValue)
        val totalResultPrice = SixFortyFiveLottoUtils.getTotalResultPrice(lottoWinningResultList)
        val totalPurchasePrice = SixFortyFiveLottoUtils.getTotalPurchasePrice(lottoList)
        var _message = "당첨 통계\n--------\n"
        listOf(
            SixFortyFiveWinning.FIFTH,
            SixFortyFiveWinning.FOURTH,
            SixFortyFiveWinning.THIRD,
            SixFortyFiveWinning.SECOND,
            SixFortyFiveWinning.FIRST,
        ).forEach { winningEnum ->
            val winningEnumCount = lottoWinningResultMap[winningEnum]
            val additionalMessage = if (winningEnum == SixFortyFiveWinning.SECOND) ", 보너스 볼 일치" else ""
            _message =
                _message.plus("${winningEnum.countOfMatch}개 일치$additionalMessage (${winningEnum.price}원) - ${winningEnumCount}개\n")
        }
        message = _message.plus("총 수익률은 ${totalResultPrice / totalPurchasePrice.toDouble()} 입니다.")
    }
}
