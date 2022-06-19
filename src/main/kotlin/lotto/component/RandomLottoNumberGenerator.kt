package lotto.component

import lotto.domain.Lotto
import lotto.domain.LottoNumber

private val LOTTO_NUMBERS = (LottoNumber.START_LOTTO_NUMBER..LottoNumber.END_LOTTO_NUMBER).toList()

object RandomLottoNumberGenerator : LottoNumberGenerator {

    //todo lottoNumberRange를 입력받는게 더 나을지?
    override fun generate(): List<LottoNumber> {
        return LOTTO_NUMBERS
            .shuffled()
            .subList(0, Lotto.LOTTO_NUMBER_COUNT)
            .map { LottoNumber.from(it) }
            .toList()
    }
}
