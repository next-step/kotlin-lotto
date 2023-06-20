package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoStatics

interface ResultView {

    fun printLottosPickedNumbers(lottos: List<Lotto>)
    fun printCountOfPurchasedLotto(countOfLotto: Int)
    fun printLottoStatics(lottoStatics: LottoStatics)
}
