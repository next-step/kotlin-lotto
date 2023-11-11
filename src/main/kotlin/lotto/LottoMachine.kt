package lotto

object LottoMachine {

    fun createLotto(numberList: List<Int>): Lotto {
        return Lotto(numberList)
    }

    fun checkLotto(winningLotto: Lotto, purchaseLotto1: Lotto): LottoRanking {
        val winningLottoToSet = winningLotto.selectNumberList.toSet()
        val purchaseLotto1ToSet = purchaseLotto1.selectNumberList.toSet()
        val intersectNumber = winningLottoToSet.intersect(purchaseLotto1ToSet)

        return when (intersectNumber.size) {
            6 -> FirstPlace
            5 -> SecondPlace
            4 -> ThirdPlace
            3 -> FourthPlace
            else -> None
        }
    }
}
