package lotto.domain

import lotto.domain.LottoNumbers.ALL_LOTTO_NUMBERS
import lotto.domain.Ticket.Companion.LOTTO_NUMBER_COUNT


/**
 *
 * @author Leo
 */
object RandomNumberStrategy : NumberStrategy {

    override fun numbers(): List<LottoNumber> {
        return ALL_LOTTO_NUMBERS.shuffled().subList(0, LOTTO_NUMBER_COUNT).sortedBy { it.number }
    }

    override fun find(target: Int): LottoNumber {
        return ALL_LOTTO_NUMBERS.first { it.number == target }
    }

}
