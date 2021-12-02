package lotto.domain


/**
 *
 * @author Leo
 */
class RandomNumberStrategy(private val targets: List<Int>) : NumberStrategy {

    override fun numbers(): List<Int> {
        return targets.shuffled().subList(0, 6).sorted()
    }

}
