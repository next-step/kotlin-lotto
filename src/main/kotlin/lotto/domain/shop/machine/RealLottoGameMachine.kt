package lotto.domain.shop.machine

import common.shffule.Shuffler
import lotto.domain.shop.LottoGame
import lotto.domain.shop.LottoNumber

class RealLottoGameMachine(
    private val shuffler: Shuffler<LottoNumber>,
) : LottoGameMachine {

    private val allLottoNumbers = LottoNumber.allLottoNumbers()

    override fun create(): LottoGame {
        return LottoGame(
            numbers = shuffler.shuffled(allLottoNumbers)
                .take(LOTTO_GAME_NUMBER_SIZE)
                .sorted(),
        )
    }

    companion object {
        private const val LOTTO_GAME_NUMBER_SIZE = 6
    }
}
