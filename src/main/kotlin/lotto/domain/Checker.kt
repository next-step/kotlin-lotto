package lotto.domain

class Checker(private val lastNumbers: LottoTicket, private val bonusNumber: LottoNumber) {
    init {
        require(bonusNumber !in lastNumbers.numbers) { "보너스번호는 당첨번호와 달라야합니다." }
    }

    fun match(lottoTicket: LottoTicket): Pair<Int, Boolean> {
        val size = lottoTicket.numbers
            .intersect(lastNumbers.numbers.toSet())
            .size
        return size to isBonusNumber(size, lottoTicket)
    }

    private fun isBonusNumber(size: Int, lottoTicket: LottoTicket) =
        size == JUDGMENT_BONUS_NUMBER && bonusNumber in lottoTicket.numbers

    companion object {
        private const val JUDGMENT_BONUS_NUMBER = 4
    }
}
