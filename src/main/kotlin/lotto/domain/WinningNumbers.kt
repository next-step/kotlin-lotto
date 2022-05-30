package lotto.domain

class WinningNumbers(numbers: List<Int>, bonus: Int) {

    private val winningNumbers: LottoTicket
    private val bonusNumber: LottoNumber

    init {
        require(!numbers.contains(bonus)) { "보너스 번호와 당첨 번호가 중복될 수 없습니다." }
        winningNumbers = LottoTicket(numbers)
        bonusNumber = LottoNumber(bonus)
    }

    fun compare(tickets: List<LottoTicket>): Map<LottoPrize, Int> = tickets
        .groupingBy {
            LottoPrize.getPrize(
                it.lottoNumbers.count { number -> winningNumbers.contains(number) },
                it.contains(bonusNumber)
            )
        }
        .eachCount()
}
