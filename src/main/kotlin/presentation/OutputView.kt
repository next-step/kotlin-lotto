package presentation

class OutputView {

    companion object {
        fun printLottoCount(purchaseLottoCount: Int, change: Int) {
            println("$purchaseLottoCount 개를 구매했습니다. 거스름돈은 $change 입니다. 가져가세요.")
        }

        fun printLotto(lotto: List<Int>) {
            println(lotto)
        }
    }
}
