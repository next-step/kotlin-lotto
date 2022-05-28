package lotto.process

import lotto.Const
import lotto.model.LottoPrice
import lotto.model.LottoTicket
import java.util.Collections

class LottoPurchase {
    fun getMoney(money: String?): LottoPrice {
        require(!money.isNullOrBlank()) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR_MSG }
        val moneyToInt = requireNotNull(money.toIntOrNull()) { Const.ErrorMsg.INPUT_VALUE_IS_NOT_INT_ERROR_MSG }
        return LottoPrice(moneyToInt)
    }

    fun getLotto(price: LottoPrice) = price.get() / 1000

    fun getLottoTickets(count: Int): List<LottoTicket> {
        val lottoTickets = mutableListOf<LottoTicket>()
        repeat(count) {
            lottoTickets.add(LottoTicket.new())
        }
        return Collections.unmodifiableList(lottoTickets)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
