package presentation

class OutputView {

    companion object {
        fun printLottoCount(purchaseLottoCount: Long, change: Long) {
            println("$purchaseLottoCount 개를 구매했습니다. 거스름돈은 $change 입니다. 가져가세요.")
        }
    }
}
