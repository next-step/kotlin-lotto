package lotto.sixFortyFiveNumberLotto

import lotto.LottoStore
import lotto.view.output.sixFortyFiveNumberLotto.SixFortyFiveLottoOutputView
import lotto.view.output.sixFortyFiveNumberLotto.SixFortyFiveResultOutputView

class SixFortyFiveLottoStore : LottoStore<SixFortyFiveLotto, SixFortyFiveLottoWinningNumber> {
    override fun purchase(count: Int): List<SixFortyFiveLotto> {
        return (1..count).map { makeLotto() }
    }

    override fun makeLotto(): SixFortyFiveLotto {
        val numbers = SixFortyFiveLottoNumber.of()
        return SixFortyFiveLotto(numbers)
    }

    override fun renderWinningInsight(lottoList: List<SixFortyFiveLotto>, winningValue: SixFortyFiveLottoWinningNumber) {
        SixFortyFiveResultOutputView(lottoList, winningValue).renderMessage()
    }

    override fun renderLottos(lottoList: List<SixFortyFiveLotto>) {
        lottoList.forEach { lotto -> lotto.renderLotto(SixFortyFiveLottoOutputView(lotto)) }
    }
}
