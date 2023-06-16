package lotto.view.output

import lotto.SixFortyFiveLotto
import lotto.SixFortyFiveLottoStore

class SixFortyFiveResultOutputView(lottoList: List<SixFortyFiveLotto>, winningValue: List<Int>) : OutputView() {

    init {
        val lottoResultList = mutableListOf(0, 0, 0, 0, 0, 0, 0)
        lottoList.forEach { lotto -> lottoResultList[lotto.checkWinning(winningValue)]++ }
        val totalResultPrice =
            lottoResultList.reduceIndexed { index, acc, count -> acc + count * SixFortyFiveLottoStore.LOTTO_WINNING_PRICE_MAP[index] }
        val totalPurchasePrice = lottoList.size * SixFortyFiveLottoStore.LOTTO_PRICE
        message = """
당첨 통계
--------
3개 일치 (${SixFortyFiveLottoStore.LOTTO_WINNING_PRICE_MAP[3]}) - ${lottoResultList[3]}개
4개 일치 (${SixFortyFiveLottoStore.LOTTO_WINNING_PRICE_MAP[4]}) - ${lottoResultList[4]}개
5개 일치 (${SixFortyFiveLottoStore.LOTTO_WINNING_PRICE_MAP[5]}) - ${lottoResultList[5]}개
6개 일치 (${SixFortyFiveLottoStore.LOTTO_WINNING_PRICE_MAP[6]}) - ${lottoResultList[6]}개
총 수익률은 ${totalResultPrice / totalPurchasePrice.toDouble()} 입니다.
                  """
    }
}
