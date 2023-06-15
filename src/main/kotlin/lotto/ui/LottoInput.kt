package lotto.ui

import lotto.domain.request.LottoOrderRequest
import lotto.domain.request.WinningInfoRequest

interface LottoInput {
    fun requestOrderLotto(): LottoOrderRequest
    fun requestWinningInfo(): WinningInfoRequest
}
