package lotto.domain.shop.machine

import shffule.Shuffler
import lotto.domain.lottonumber.LottoNumber
import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.shop.LottoGame

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
