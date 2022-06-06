package lotto.view

class LottoGameView {

    companion object {

        fun printPurchaseAmountInput() {
            println(PURCHASE_AMOUNT_MESSAGE)
        }

        fun printBuyAmount(n: Int) {
            println(n.toString() + BUY_AMOUNT_MESSAGE)
        }

        private const val PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val BUY_AMOUNT_MESSAGE = "개를 구매했습니다."
    }
}
