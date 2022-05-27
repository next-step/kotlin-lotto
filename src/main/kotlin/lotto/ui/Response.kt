package lotto.ui

object Response {

    private const val RESPONSE_PURCHASE_LOTTO = "%s개를 구매했습니다."

    fun responsePurchase(count: Int) = println(RESPONSE_PURCHASE_LOTTO.format(count))
}
