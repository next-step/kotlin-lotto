package lotto.domain

data class WinningTicket(val winningLotto: Lotto, val bonus: LottoNumber) {

    init {
        require(!winningLotto.contains(bonus)) { BONUS_EXCEPTION }
    }

    companion object {
        private const val BONUS_EXCEPTION = "보너스 볼은 로또번호와 달라야 합니다"
    }
}
