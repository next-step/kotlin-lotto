package lotto.domain.shop.machine

import lotto.domain.shop.LottoGame

interface LottoGameMachine {

    fun create(): LottoGame
}
