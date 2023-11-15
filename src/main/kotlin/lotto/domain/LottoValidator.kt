package lotto.domain
object LottoValidator {
    fun validateWinningNumberAndUserLotto(
        winningNumber: List<LottoNumber>,
        userLottoNumbers: LottoNumbers
    ): Int {
        val lottoNumber = userLottoNumbers.getNumbers()
        var count = 0
        lottoNumber.forEach {
            if (winningNumber.contains(it)) {
                count++
            }
        }

        return count
    }
}
