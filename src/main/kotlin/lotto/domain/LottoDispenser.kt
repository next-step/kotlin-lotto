package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.Rank
import lotto.domain.model.WinningNumbers

class LottoDispenser(val amount: Int) {

    lateinit var ranks: List<Rank>
    lateinit var bonusNumber: LottoNumber
    lateinit var winningNumbers: WinningNumbers
    val lottoList: List<Lotto> = makeLottoList()

    init {
        require(amount >= MINIMUM_PRICE) { "구입 금액은 ${MINIMUM_PRICE}원 이하가 될 수 없습니다" }
    }

    fun checkWinningLottoList() {
        ranks = lottoList.map { lotto ->
            Rank.win(winningNumbers, lotto, bonusNumber)
        }
    }

    private fun makeLottoList(): List<Lotto> {
        return List(amount / MINIMUM_PRICE) {
            Lotto()
        }
    }
}
