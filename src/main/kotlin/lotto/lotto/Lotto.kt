package lotto.lotto

data class Lotto(
    val numberList: LottoNumbers = createLotto(),
) {

    /**
     * 각각 구매한 로또 마다 당첨된 번호만 남겨 맞은 개수를 판별 합니다.
     * ex) 1,2,3,4,5,6 중 1,2,3만 맞았다면 [1,2,3].count() -> intersect를 통해 교집합을 구함
     */
    fun lottoPrize(lastWeekLottoNumber: WinningLotto): LottoPrize {
        val matchCount = lastWeekLottoNumber.intersect(numberList).count()
        val bonusMatched = numberList.contains(lastWeekLottoNumber.bonusNumber)
        return LottoPrize.getLottoPrize(matchCount, bonusMatched)
    }

    fun isMatchedBonusBall(bonusNumber: Int): Boolean = numberList.contains(bonusNumber)

    companion object {
        private const val NUMBER_LIST_COUNT = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private fun createLotto(): LottoNumbers = (MIN_NUMBER..MAX_NUMBER)
            .shuffled()
            .take(NUMBER_LIST_COUNT)
            .sorted()
            .toLottoNumbers()
    }
}
