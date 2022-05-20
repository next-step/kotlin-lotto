package lotto.domain

class LottoBundle(
    val bundle: List<Lotto>
) {
    init {
        require(bundle.isNotEmpty()) { "로또는 하나 이상 존재해야 합니다" }
    }

    fun confirmWinning(winningLotto: Lotto): List<WinningPlace> {
        val winnings = mutableListOf<WinningPlace>()
        bundle.forEach {
            val matching = it.countMatchingNumbers(winningLotto)
            winnings.add(WinningPlace.of(matching))
        }
        return winnings.toList()
    }
}
