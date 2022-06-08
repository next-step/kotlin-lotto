package lotto.view

object InputView {
    fun inputPurchasedMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.also {
            require(it.isNotBlank()) { "구입금액은 null or 빈 값이 될 수 없습니다." }
            requireNotNull(it.toIntOrNull()) { "구입금액은 숫자만 허용됩니다. " }
        }!!.toInt()
    }
}
