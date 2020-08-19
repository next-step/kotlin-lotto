package lotto.domain

class WinningLotto(val winningNumbers: LottoTicket, val bonusNumber: LottoNumber) {
    init {
        require(!winningNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없다.")
        }
    }
}
