package lotto.ui

import lotto.domain.request.LottoOrderRequest
import lotto.domain.request.WinningInfoRequest

class LottoInputProxy(private val target: LottoInput) : LottoInput {

    override fun requestOrderLotto(): LottoOrderRequest {
        return try {
            target.requestOrderLotto()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            requestOrderLotto()
        }
    }

    override fun requestWinningInfo(): WinningInfoRequest {
        return try {
            target.requestWinningInfo()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            requestWinningInfo()
        }
    }
}
