package lotto.entity

class LottoTicketMachine() {
    fun printMaxTicket(money: Int): MutableList<LottoTicket> {
        return mutableListOf<LottoTicket>().apply {
            repeat(money / 1000) { this.add(print()) }
        }
    }

    fun print(numbers: List<Int> = getRandomNumber()): LottoTicket {
        return LottoTicket(numbers)
    }

    fun getRandomNumber(): List<Int> {
        return (1..45).toList().shuffled().take(6)
    }
}
