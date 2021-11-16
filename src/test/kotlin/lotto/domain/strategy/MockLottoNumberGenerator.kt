package lotto.domain.strategy

import lotto.domain.LottoNumbers
import lotto.fixture.LottoNumbersFixture

object MockLottoNumberGenerator : LottoNumberGenerator {

    override fun generate(): LottoNumbers {
        return LottoNumbersFixture.LOTTO_NUMBER_SET_WINNING
    }
}
