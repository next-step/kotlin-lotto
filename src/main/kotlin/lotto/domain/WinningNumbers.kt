package lotto.domain

class WinningNumbers(numbers: List<Int>, bonus: Int) {

    private val winningNumbers: LottoTicket
    private val bonusNumber: LottoNumber

    init {
        winningNumbers = LottoTicket(numbers)
        bonusNumber = LottoNumber(bonus)
    }

    fun compare(tickets: List<LottoTicket>): Map<LottoPrize, Int> = tickets
        .map { it.lottoNumbers.count { number -> winningNumbers.contains(number) } }
        .groupingBy { LottoPrize.getPrize(it) }.eachCount()
}
