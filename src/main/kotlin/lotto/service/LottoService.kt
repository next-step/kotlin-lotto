package lotto.service

import Lottos
import lotto.domain.Lotto
import lotto.domain.LottoFactory
import lotto.domain.LottoNumber
import lotto.domain.LottoPrice
import lotto.domain.WinningLotto
import lotto.domain.WinningResult

class LottoService {
    fun purchase(price: LottoPrice): Lottos {
        return LottoFactory.create(price)
    }

    fun checkWinning(
        lottos: Lottos,
        winningNumbers: Lotto,
        bonusNumber: LottoNumber,
    ): WinningResult {
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        return winningLotto.checkWinning(lottos)
    }
}
