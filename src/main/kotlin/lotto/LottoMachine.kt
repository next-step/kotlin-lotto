package lotto

object LottoMachine {
    private const val SIX = 6
    private const val FIVE = 5
    private const val FOUR = 4
    private const val THREE = 3

    fun createLotto(numberList: List<Int>): Lotto {
        return Lotto(numberList)
    }

    fun checkLotto(winningLotto: Lotto, purchaseLotto: Lotto): LottoRanking {
        val winningLottoToSet = winningLotto.selectNumberList.toSet()
        val purchaseLottoToSet = purchaseLotto.selectNumberList.toSet()
        val intersectNumber = winningLottoToSet.intersect(purchaseLottoToSet)

        return when (intersectNumber.size) {
            SIX -> FirstPlace
            FIVE -> SecondPlace
            FOUR -> ThirdPlace
            THREE -> FourthPlace
            else -> None
        }
    }
}
