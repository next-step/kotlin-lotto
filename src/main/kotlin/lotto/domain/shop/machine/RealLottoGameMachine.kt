package lotto.domain.shop.machine

import common.shffule.Shuffler
import lotto.domain.shop.LottoGame
import lotto.domain.shop.LottoNumber
import lotto.domain.shop.LottoNumbers

class RealLottoGameMachine(
    private val shuffler: Shuffler<LottoNumber>,
) : LottoGameMachine {

    private val allLottoNumbers = LottoNumber.allLottoNumbers()

    override fun create(): LottoGame {
        return LottoGame(
            lottoNumbers = LottoNumbers(
                shuffler.shuffled(allLottoNumbers)
                    .take(LOTTO_GAME_NUMBER_SIZE)
                    .sorted()
            ),
        )
    }

    companion object {
        private const val LOTTO_GAME_NUMBER_SIZE = 6
    }
}
