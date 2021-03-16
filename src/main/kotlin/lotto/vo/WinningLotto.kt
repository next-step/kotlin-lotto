package lotto.vo

import lotto.domain.Lotto.Companion.LOTTO_SIZE

data class WinningLotto(val winningLotto: Set<LottoNumber>) {
    init {
        require(winningLotto.size == LOTTO_SIZE) { "당첨 로또 번호는 정확히 6개만 허용됩니다." }
    }
}
