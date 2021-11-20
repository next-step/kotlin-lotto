package lotto.domain.strategy

import lotto.domain.LottoNumbers
import lotto.fixture.LottoNumbersFixture

object MockLottoNumberAutoGenerator : LottoNumberAutoGenerator {

    override fun generate(): LottoNumbers {
        return LottoNumbersFixture.LOTTO_NUMBER_SET_WINNING
    }
}
