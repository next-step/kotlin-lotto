package lotto.domain
object LottoValidator {
    fun validateWinningNumberAndUserLotto(
        winningNumber: List<LottoNumber>,
        userLotto: Lotto
    ): Int {
        val lottoNumber = userLotto.getNumbers()
        var count: Int = 0
        lottoNumber.forEach {
            if (winningNumber.contains(it)) {
                count++
            }
        }

        return count
    }
}
