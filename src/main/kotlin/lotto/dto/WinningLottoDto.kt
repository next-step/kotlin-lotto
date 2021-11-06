package lotto.dto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto

data class WinningLottoDto(val lotto: List<Int>, val bonus: Int) {
    fun toWinningLotto(): WinningLotto {
        return WinningLotto(Lotto.from(lotto), LottoNumber(bonus))
    }
}
