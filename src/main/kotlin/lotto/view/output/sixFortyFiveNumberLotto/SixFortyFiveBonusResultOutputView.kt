package lotto.view.output.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningNumber
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningEnum
import lotto.view.output.OutputView

class SixFortyFiveBonusResultOutputView(
    lottoList: List<SixFortyFiveLotto>,
    winningValue: SixFortyFiveLottoWinningNumber,
) : OutputView() {

    init {
        val lottoWinningList = winningValue.getWinningResultEnumList(lottoList)
        val lottoWinningMap = winningValue.convertWinningResultEnumListToMap(lottoWinningList)
        val earningRate = winningValue.getEarningRate(lottoWinningList, lottoList.size)
        var _message = "당첨 통계\n--------\n"
        listOf(
            SixFortyFiveWinningEnum.FIFTH,
            SixFortyFiveWinningEnum.FOURTH,
            SixFortyFiveWinningEnum.THIRD,
            SixFortyFiveWinningEnum.SECOND,
            SixFortyFiveWinningEnum.FIRST,
        ).forEach { winningEnum ->
            val winningEnumCount = lottoWinningMap[winningEnum]
            val additionalMessage = if (winningEnum == SixFortyFiveWinningEnum.SECOND) ", 보너스 볼 일치" else ""
            _message =
                _message.plus("${winningEnum.countOfMatch}개 일치$additionalMessage (${winningEnum.price}원) - ${winningEnumCount}개\n")
        }
        message = _message.plus("총 수익률은 $earningRate 입니다.")
    }
}
