package lotto.model.game

class WinningLotto(val winningLotto: Lotto, val bonusNumber: LottoNumber) {
    init {
        require(!winningLotto.hasNumber(bonusNumber)) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }
}
