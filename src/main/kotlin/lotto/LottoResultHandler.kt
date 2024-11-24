package lotto

object LottoResultHandler {

    fun match(
        userLotto: List<LottoNumbers>,
        winningLotto: LottoNumbers,
    ): List<Int> {
        return userLotto.map { it.countMatch(winningLotto) }
    }
}
