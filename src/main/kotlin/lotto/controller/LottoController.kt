package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import lotto.domain.LottoPurchase
import lotto.uI.InputView
import lotto.uI.OutputView

class LottoController {

    fun purchase(): List<Lotto> {
        val money = InputView.inputMoney()

        val lottoCount = LottoPurchase(price = money).getLottoCount()

        val lottoList: List<Lotto> =
            (1..lottoCount).map {
                Lotto(LottoGenerator.generateLottoNumbers())
            }

        OutputView.outputLottoList(lottoList)
        return lottoList
    }
}
