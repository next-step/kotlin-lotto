package lotto.domain

import lotto.domain.Ticket.Companion.LOTTO_NUMBER_COUNT


/**
 *
 * @author Leo
 */
class RandomNumberStrategy(private val targets: List<Int>) : NumberStrategy {

    override fun numbers(): List<Int> {
        return targets.shuffled().subList(0, LOTTO_NUMBER_COUNT).sorted()
    }

}
