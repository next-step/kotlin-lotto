package lotto.vo

import lotto.domain.Lotto.Companion.LOTTO_SIZE

data class WinningLotto(val winningLotto: Set<LottoNumber>, val bonusNumber: LottoNumber) {
    init {
        require(winningLotto.size == LOTTO_SIZE) { "당첨 로또 번호는 정확히 6개만 허용됩니다." }
        require(bonusNumber !in winningLotto) { "보너스 번호는 당첨 번호 6개와 중복될 수 없습니다." }
    }
}
