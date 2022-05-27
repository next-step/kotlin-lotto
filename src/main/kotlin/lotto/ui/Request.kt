package lotto.ui

object Request {

    private const val INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요."
    private const val INPUT_ROUND_COUNT = "시도할 횟수는 몇 회인가요?"

    fun requestPurchaseLotto() = println(INPUT_PURCHASE_PRICE)

}
