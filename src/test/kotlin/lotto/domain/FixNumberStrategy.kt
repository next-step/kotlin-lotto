package lotto.domain

/**
 *
 * @author Leo
 */
class FixNumberStrategy(private val targets: List<Int>) : NumberStrategy {

    override fun numbers(): List<LottoNumber> {
        return targets.map { LottoNumber(it) }
    }

    override fun find(target: Int): LottoNumber {
        TODO("Not yet implemented")
    }
}
