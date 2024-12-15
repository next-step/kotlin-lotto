package lotto.domain

data class BonusNumber(private val number: LottoNumber) {
    fun isMatched(numbers: Set<LottoNumber>): Boolean {
        return numbers.contains(number)
    }

    companion object {
        fun of(
            lottoTicket: LottoTicket,
            number: LottoNumber,
        ): BonusNumber {
            require(!lottoTicket.contains(number)) { "보너스 번호는 로또 티켓의 번호와 중복될 수 없습니다" }
            return BonusNumber(number)
        }
    }
}
