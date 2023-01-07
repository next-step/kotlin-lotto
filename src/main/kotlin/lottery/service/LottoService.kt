package lottery.service

import lottery.domain.lotto.Lotto

class LottoService(
    private val exchangeService: ExchangeService
){

    fun issue(amount: Long): List<Lotto> {
        val quantity = exchangeService.calculateQuantity(amount)
        return List(quantity) { Lotto() }
    }
}