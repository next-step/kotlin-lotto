package lotto.fixture

import lotto.domain.LottoNumber

class LottoNumberFixture {

    companion object {
        fun create(number: Int): LottoNumber {
            return LottoNumber.valueOf(number)
        }
    }
}
