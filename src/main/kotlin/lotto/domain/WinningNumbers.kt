package lotto.domain

class WinningNumbers(numbers: List<Int>) {

    private val winningNumbers: LottoTicket

    init {
        winningNumbers = LottoTicket(numbers)
    }

    fun compare(tickets: List<LottoTicket>): Map<LottoPrize, Int> = tickets
        .map { it.lottoNumbers.count { number -> winningNumbers.contains(number) } }
        .groupingBy { LottoPrize.getPrize(it) }.eachCount()
}
