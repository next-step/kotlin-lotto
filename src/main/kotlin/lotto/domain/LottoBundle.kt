package lotto.domain

data class LottoBundle(
    private val bundle: List<Lotto>
) {
    val size = bundle.size

    override fun toString(): String {
        return bundle.joinToString("\n") { it.toString() }
    }

    operator fun plus(other: LottoBundle): LottoBundle {
        return LottoBundle(bundle + other.bundle)
    }

    fun isNotEmpty(): Boolean = bundle.isNotEmpty()

    fun matchWinning(winningLotto: WinningLotto): List<WinningPlace> {
        return bundle.map {
            val matchingNumber = it.countMatchingNumbers(winningLotto.lotto)
            val matchingBonus = winningLotto.bonusBall in it
            WinningPlace.of(matchingNumber, matchingBonus)
        }
    }

    companion object {
        val EMPTY = LottoBundle(emptyList())
    }
}
