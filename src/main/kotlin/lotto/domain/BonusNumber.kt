package lotto.domain

data class BonusNumber(private val bonusNumber: LottoNumber) {
    companion object {
        fun of(lottoNumber: LottoNumber, lottoTicket: LottoTicket): BonusNumber {
            require(!lottoTicket.contains(lottoNumber)) { "보너스 번호는 로또 티켓의 번호와 중복될 수 없습니다" }
            return BonusNumber(lottoNumber)
        }
    }
}
