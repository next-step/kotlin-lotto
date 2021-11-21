package lotto.fixture

import lotto.domain.LottoNumbers

class LottoNumbersFixture {

    companion object {
        val LOTTO_NUMBER_SET_FIRST = LottoNumbers.of(LottoNumberFixture.LOTTO_NUMBER_LIST_FIRST)
        val LOTTO_NUMBER_SET_SECOND = LottoNumbers.of(LottoNumberFixture.LOTTO_NUMBER_LIST_SECOND)
        val LOTTO_NUMBER_SET_WINNING = LottoNumbers.of(LottoNumberFixture.LOTTO_NUMBER_LIST_WINNING)

        fun `수동으로_선택된_로또번호_목록`(manual: Int): List<LottoNumbers> {
            return (1..manual)
                .map { LOTTO_NUMBER_SET_FIRST }
                .run { toList() }
        }
    }
}
