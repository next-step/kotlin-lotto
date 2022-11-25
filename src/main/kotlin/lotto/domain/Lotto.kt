package lotto.domain

import lotto.domain.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.domain.LottoConstants.LOTTO_NUMBER_RANGE

class Lotto(val numbers: Set<LottoNumber> = createLottoNumbers()) {

    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 당첨 번호는 ${LOTTO_NUMBER_COUNT}개입니다." }
    }

    fun matchingCount(lottoNumbers: Lotto): Int = numbers.count { lottoNumbers.numbers.contains(it) }

    companion object {
        fun createLottoNumbers(): Set<LottoNumber> =
            (LOTTO_NUMBER_RANGE).shuffled().take(LOTTO_NUMBER_COUNT)
                .sorted()
                .map { LottoNumber(it) }
                .toSet()
    }
}
