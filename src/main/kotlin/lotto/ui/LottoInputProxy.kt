package lotto.ui

import lotto.domain.request.LottoOrderRequest
import lotto.domain.request.WinningInfoRequest

class LottoInputProxy(private val target: LottoInput) : LottoInput {

    override fun requestOrderLotto(): LottoOrderRequest =
        runCatching { target.requestOrderLotto() }
            .recoverCatching {
                println(it.message)
                requestOrderLotto()
            }.getOrThrow()

    override fun requestWinningInfo(): WinningInfoRequest =
        runCatching { target.requestWinningInfo() }
            .recoverCatching {
                println(it.message)
                requestWinningInfo()
            }.getOrThrow()
}
