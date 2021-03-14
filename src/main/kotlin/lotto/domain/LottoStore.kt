package lotto.domain

class LottoStore {

    fun purchaseAuto(money: Money): Lottoes {
        val quantity = money.currentMoney / LOTTO_COST
        money.spendAllMoney()
        val lottoes = (1..quantity).map { LottoTicket.generateAuto() }

        return Lottoes(lottoes)
    }

    fun purchaseManual(money: Money, numberOfManuals: Int, numbersOfTickets: List<List<Int>>): Lottoes {
        money.spendMoney(LOTTO_COST * numberOfManuals)
        val lottoes = arrayListOf<LottoTicket>()
        for (numbers in numbersOfTickets) {
            lottoes.add(LottoTicket.generateManual(numbers))
        }

        return Lottoes(lottoes)
    }

    companion object {
        const val LOTTO_COST = 1000
    }
}
