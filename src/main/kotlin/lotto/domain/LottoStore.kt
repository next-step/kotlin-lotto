package lotto.domain

class LottoStore {

    fun purchaseAuto(quantity: Int): Lottoes {
        val lottoes = (1..quantity).map { LottoTicket.generateAuto() }

        return Lottoes(lottoes)
    }

    fun purchaseManual(numberOfManuals: Int, numbersOfTickets: List<List<Int>>): Lottoes {
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
