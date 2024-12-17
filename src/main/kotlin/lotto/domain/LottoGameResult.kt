package lotto.domain

import lotto.entity.Lotto
import lotto.enums.prize.Prize

class LottoGameResult(val lotto: Lotto, val winningLottoNumber: WinningLottoNumber) {
    fun getResult(): Map<Prize, Int> {
        return lotto.getResultMap(
            mutableMapOf(
                Prize.THREE to 0,
                Prize.FOUR to 0,
                Prize.FIVE to 0,
                Prize.BONUS to 0,
                Prize.SIX to 0,
            ),
            winningLottoNumber,
        )
    }
}
