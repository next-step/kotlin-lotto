package lotto.domain.shop

import lotto.domain.lottonumber.LottoNumber
import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.shop.lottonumberprovider.LottoNumberProvider
import shffule.Shuffler

class LottoGameMachine(
    private val lottoNumberProvider: LottoNumberProvider,
    private val shuffler: Shuffler<LottoNumber>,
) {

    fun create(): LottoGame {
        return LottoGame(
            lottoNumbers = LottoNumbers(
                shuffler.shuffled(lottoNumberProvider.getAllLottoNumbers())
                    .take(LOTTO_GAME_NUMBER_SIZE)
                    .sorted()
            ),
        )
    }

    companion object {
        private const val LOTTO_GAME_NUMBER_SIZE = 6
    }
}
