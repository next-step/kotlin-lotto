package lotto.domain

data class LottoBundle(
    private val bundle: List<Lotto>
) {
    val size = bundle.size

    init {
        require(bundle.isNotEmpty()) { "로또는 하나 이상 존재해야 합니다" }
    }

    override fun toString(): String {
        return bundle.joinToString("\n") { it.toString() }
    }

    fun matchWinning(winningLotto: WinningLotto): List<WinningPlace> {
        val winnings = mutableListOf<WinningPlace>()
        bundle.forEach {
            val matchingNumber = it.countMatchingNumbers(winningLotto.lotto)
            val matchingBonus = winningLotto.bonusBall in it
            winnings.add(WinningPlace.of(matchingNumber, matchingBonus))
        }
        return winnings.toList()
    }
}
