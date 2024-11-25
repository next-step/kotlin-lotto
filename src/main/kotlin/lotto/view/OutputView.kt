package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Lottos

interface OutputView {
    fun printLottoQuantity(quantity: Int)

    fun printLottoNumbers(lottos: Lottos)

    fun printLottoResult(lottoResult: LottoResult)
}
