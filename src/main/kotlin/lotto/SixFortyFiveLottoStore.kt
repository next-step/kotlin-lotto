package lotto

import lotto.view.output.SixFortyFiveLottoOutputView
import lotto.view.output.SixFortyFiveResultOutputView

class SixFortyFiveLottoStore : LottoStore<SixFortyFiveLotto, List<Int>> {
    override fun purchase(count: Int): List<SixFortyFiveLotto> {
        return (1..count).map { makeLotto() }
    }

    override fun makeLotto(): SixFortyFiveLotto {
        val numbers = SixFortyFiveLottoNumber.of()
        return SixFortyFiveLotto(numbers)
    }

    override fun renderWinningInsight(lottoList: List<SixFortyFiveLotto>, winningValue: List<Int>) {
        SixFortyFiveResultOutputView(lottoList, winningValue).renderMessage()
    }

    override fun renderLottos(lottoList: List<SixFortyFiveLotto>) {
        lottoList.forEach { lotto -> lotto.renderLotto(SixFortyFiveLottoOutputView(lotto)) }
    }

    companion object {
        @JvmField
        val LOTTO_WINNING_PRICE_MAP = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)
    }
}
