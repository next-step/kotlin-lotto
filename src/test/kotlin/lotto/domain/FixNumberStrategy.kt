package lotto.domain

/**
 *
 * @author Leo
 */
class FixNumberStrategy(private val targets: List<Int>) : NumberStrategy {

    override fun numbers(): List<Int> {
        return targets
    }

}
