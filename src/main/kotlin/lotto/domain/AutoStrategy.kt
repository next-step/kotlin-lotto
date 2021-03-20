package lotto.domain

import lotto.domain.LottoGame.Companion.LOTTO_COST

class AutoStrategy : LottoStrategy {
    override fun generateLotto(money: Money): Lottoes {
        val quantity = money.getQuantityOfAvailablePurchase()
        money.spendMoney(quantity * LOTTO_COST)
        return Lottoes(
            (1..quantity).map {
                makeAutoLottoTicket()
            }
        )
    }

    private fun makeAutoLottoTicket(): LottoTicket {
        val numbers = (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER)
            .shuffled()
            .take(LottoTicket.LENGTH_OF_LOTTO)

        return LottoTicket(numbers)
    }
}
