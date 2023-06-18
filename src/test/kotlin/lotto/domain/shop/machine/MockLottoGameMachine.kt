package lotto.domain.shop.machine

import lotto.domain.shop.LottoGame

class MockLottoGameMachine(
    private val lottoGameCreateDelegator: () -> LottoGame
) : LottoGameMachine {

    override fun create(): LottoGame {
        return lottoGameCreateDelegator()
    }
}
