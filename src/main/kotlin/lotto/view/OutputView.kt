package lotto.view

object OutputView {

    private const val ENTER_MONEY = "구입금액을 입력해 주세요."
    private const val LOTTO_COUNT = "개를 구매했습니다."

    fun printEnterMoney() = println(ENTER_MONEY)
    fun printLottoCount(count: String) = println(count + LOTTO_COUNT)
}
