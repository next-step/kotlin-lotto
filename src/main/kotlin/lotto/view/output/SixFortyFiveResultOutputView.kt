package lotto.view.output

import lotto.SixFortyFiveLotto
import lotto.SixFortyFiveLottoStore

class SixFortyFiveResultOutputView(lottoList: List<SixFortyFiveLotto>, winningValue: List<Int>) : OutputView() {

    init {
        val lottoResultList = mutableListOf(0, 0, 0, 0, 0, 0, 0)
        lottoList.forEach { lotto -> lottoResultList[lotto.checkWinning(winningValue)]++ }
        val totalResultPrice =
            lottoResultList.reduceIndexed { index, acc, count -> acc + count * SixFortyFiveLottoStore.LOTTO_WINNING_PRICE_MAP[index] }
        val totalPurchasePrice = lottoList.size * SixFortyFiveLotto.LOTTO_PRICE
        var _message = "당첨 통계\n--------\n"
        (3..6).forEach { index ->
            _message =
                _message.plus("${index}개 일치 (${SixFortyFiveLottoStore.LOTTO_WINNING_PRICE_MAP[index]}) - ${lottoResultList[index]}개\n")
        }
        message = _message.plus("총 수익률은 ${totalResultPrice / totalPurchasePrice.toDouble()} 입니다.")
    }
}
