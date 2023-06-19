package lotto.view.output.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningEnum
import lotto.sixFortyFiveNumberLotto.SixFortyFiveWinningLotto
import lotto.view.output.OutputView

class SixFortyFiveResultOutputView(lottoList: List<SixFortyFiveLotto>, winningValue: SixFortyFiveWinningLotto) :
    OutputView() {

    init {
        val lottoWinningList = winningValue.getWinningResultEnumList(lottoList)
            .filter { it != SixFortyFiveWinningEnum.SECOND }
        val lottoWinningMap = winningValue.convertWinningResultEnumListToMap(lottoWinningList)
        val earningRate = winningValue.getEarningRate(lottoWinningList, lottoList.size)
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
