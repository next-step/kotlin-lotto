package lotto.domain

class WinningLotto(
    private val lotto: Lotto,
) {
    fun match(targetLotto: Lotto): Rank {
        val correctNumber = lotto.countSameLottoNumbers(targetLotto)
        return Rank.of(correctNumber)
    }
}
