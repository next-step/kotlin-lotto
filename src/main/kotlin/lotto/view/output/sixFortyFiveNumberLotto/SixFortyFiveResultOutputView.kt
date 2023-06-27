package lotto.view.output.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoWinningOutput
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoes
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningEnum
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningLotto
import lotto.view.output.OutputView

class SixFortyFiveResultOutputView(lottoList: SixFortyFiveLottoes, winningValue: SixFortyFiveWinningLotto) :
    OutputView() {

    init {
        val lottoWinningOutput = SixFortyFiveLottoWinningOutput(lottoList, winningValue)
        val lottoWinningMap = lottoWinningOutput.winningResultEnumMap
        val earningRate = lottoWinningOutput.getEarningRate()
        var _message = "당첨 통계\n--------\n"
        listOf(
            SixFortyFiveWinningEnum.FIFTH,
            SixFortyFiveWinningEnum.FOURTH,
            SixFortyFiveWinningEnum.THIRD,
            SixFortyFiveWinningEnum.FIRST,
        ).forEach { winningEnum ->
            val winningEnumCount = lottoWinningMap[winningEnum]
            _message =
                _message.plus("${winningEnum.countOfMatch}개 일치 (${winningEnum.price}원) - ${winningEnumCount}개\n")
        }
        message = _message.plus("총 수익률은 $earningRate 입니다.")
    }
}
