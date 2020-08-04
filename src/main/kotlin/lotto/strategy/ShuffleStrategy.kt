package lotto.strategy

import lotto.domain.value.LottoNumber

class ShuffleStrategy : Strategy {
    override fun shuffle(numbers: List<LottoNumber>): List<LottoNumber> {
        return numbers.shuffled()
    }
}
