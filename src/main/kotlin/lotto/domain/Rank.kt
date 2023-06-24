package lotto.domain

enum class Rank(
    val matchCount: Int,
    val winningMoney: Long,
    var count: Int
) {
    FIRST(6, 2_000_000_000, 0),
    SECOND(5, 30_000_000, 0),
    THIRD(5, 1_500_000, 0),
    FOURTH(4, 50_000, 0),
    FIFTH(3, 5_000, 0);

    fun getRank(lottos: Lottos, winningNumber: WinningNumber): Rank {
        count = lottos.lottoNumbers.count { lottoNumbers ->
            val countOfIntersect = lottoNumbers.findIntersectCount(winningNumber.lastLottoNumbers.lottoNumbers)
            if (isCountOfIntersectFive(countOfIntersect)) {
                hasBonusNumberIfSecond(winningNumber, lottoNumbers, countOfIntersect)
            } else {
                countOfIntersect == matchCount
            }
        }
        return this
    }

    private fun isCountOfIntersectFive(countOfIntersect: Int) = countOfIntersect == 5

    private fun hasBonusNumberIfSecond(
        winningNumber: WinningNumber,
        lottoNumbers: LottoNumbers,
        countOfIntersect: Int
    ) = if (isSecond()) {
        checkBonusNumberExistence(winningNumber, lottoNumbers)
    } else {
        !checkBonusNumberExistence(winningNumber, lottoNumbers) && countOfIntersect == matchCount
    }

    private fun checkBonusNumberExistence(winningNumber: WinningNumber, lottoNumbers: LottoNumbers) =
        winningNumber.bonusNumber in lottoNumbers.lottoNumbers

    fun isSecond(): Boolean {
        return this === SECOND
    }
}
