package lotto.domain.shop

import lotto.domain.lottonumber.LottoNumber
import lotto.domain.lottonumber.LottoNumbers
import shffule.Shuffler

class LottoGameMachine(
    private val shuffler: Shuffler<LottoNumber>,
) {

    private val allLottoNumbers = LottoNumber.allLottoNumbers()

    fun create(): LottoGame {
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
