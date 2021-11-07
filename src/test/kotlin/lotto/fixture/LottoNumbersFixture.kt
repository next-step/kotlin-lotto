package lotto.fixture

import lotto.domain.LottoNumbers

class LottoNumbersFixture {

    companion object {
        val LOTTO_NUMBER_SET_FIRST = LottoNumbers.of(LottoNumberFixture.LOTTO_NUMBER_LIST_FIRST)
        val LOTTO_NUMBER_SET_SECOND = LottoNumbers.of(LottoNumberFixture.LOTTO_NUMBER_LIST_SECOND)
        val LOTTO_NUMBER_SET_WINNING = LottoNumbers.of(LottoNumberFixture.LOTTO_NUMBER_LIST_WINNING)
    }
}
