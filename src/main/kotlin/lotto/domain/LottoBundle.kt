package lotto.domain

data class LottoBundle(
    private val bundle: List<Lotto>
) {
    val size = bundle.size

    override fun toString(): String {
        return bundle.joinToString("\n") { it.toString() }
    }

    operator fun plus(other: LottoBundle): LottoBundle {
        val targetBundle = bundle.toMutableList()
        targetBundle.addAll(other.bundle)
        return LottoBundle(targetBundle.toList())
    }

    fun isNotEmpty() = bundle.isNotEmpty()

    fun matchWinning(winningLotto: WinningLotto): List<WinningPlace> {
        val winnings = mutableListOf<WinningPlace>()
        bundle.forEach {
            val matchingNumber = it.countMatchingNumbers(winningLotto.lotto)
            val matchingBonus = winningLotto.bonusBall in it
            winnings.add(WinningPlace.of(matchingNumber, matchingBonus))
        }
        return winnings.toList()
    }

    companion object {
        val EMPTY = LottoBundle(emptyList())
    }
}
