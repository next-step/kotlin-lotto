package lotto.domain

import lotto.domain.lottoticket.LottoNumber
import lotto.domain.lottoticket.LottoNumbers
import lotto.domain.lottoticket.LottoTicket
import lotto.domain.lottoticket.LottoTickets

class LottoTicketMachine(
    private var money: Money = LottoTicket.PRICE
) {
    init {
        require(money >= LottoTicket.PRICE) {
            "로또 구입을 위한 최소 금액은 ${LottoTicket.PRICE.value} 입니다."
        }
    }

    fun buyManualLottoTickets(manualNumbers: List<Int>): LottoTicket {
        val lottoNumberSet = manualNumbers.map { LottoNumber.from(it) }.toSet()
        val lottoNumbers = LottoNumbers.createWithSort(values = lottoNumberSet)
        spendMoney()
        return LottoTicket(lottoNumbers = lottoNumbers)
    }

    fun buyAutoLottoTicketsUntilSpendAllMoney(): LottoTickets {
        if (money.divideInt(LottoTicket.PRICE) < 1) {
            throw IllegalStateException("남은 금액 ${this.money.value} 으로 로또 티켓을 구입할 수 없습니다.")
        }

        return LottoTickets(
            List(money.divideInt(LottoTicket.PRICE)) {
                buyAutoLottoTicket()
            }
        )
    }

    private fun buyAutoLottoTicket(): LottoTicket {
        val lottoNumbers = LottoNumber.cachedLottoNumbers()
            .asSequence()
            .shuffled()
            .take(LottoNumbers.NUMBERS_COUNT)
            .toSet()
        spendMoney()
        return LottoTicket(lottoNumbers = LottoNumbers.createWithSort(lottoNumbers))
    }

    private fun spendMoney() {
        if (money < LottoTicket.PRICE) {
            throw IllegalStateException("남은 금액 ${this.money.value} 으로 로또 티켓을 구입할 수 없습니다.")
        }

        this.money = this.money - LottoTicket.PRICE
    }
}
