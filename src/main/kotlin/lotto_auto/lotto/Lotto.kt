package lotto_auto.lotto

data class Lotto(
    val numberList: LottoNumbers = createLotto(),
) {

    /**
     * 각각 구매한 로또 마다 당첨 번호와 대조 하여 맞은 개수를 판별 합니다.
     */
    fun lottoMatchCount(lastWeekLottoNumber: Lotto): Int {
        return lastWeekLottoNumber.numberList.numbers.mapNotNull { number ->
            if (myLottoNumberContainsNumberOrNull(number)) number else null
        }.count()
    }

    private fun myLottoNumberContainsNumberOrNull(number: Int): Boolean {
        return numberList.numbers.contains(number)
    }

    fun isMatchedBonusBall(bonusNumber: Int): Boolean = numberList.numbers.contains(bonusNumber)

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

fun List<Int>.toLotto() = Lotto(numberList = this.toLottoNumbers())
