package lotto

const val LOTTO_SPLIT_PATTERN = ","
const val LOTTO_BASE_PRICE = 1000
object InputView {
    fun buyMoney(): Money {
        println("구입금액을 입력해 주세요.")
        val buyMoney = Money(readLine()!!.toInt())

        require(buyMoney.devideRemain(LOTTO_BASE_PRICE) == 0) { "구입 금액은 1천원 단위로 가능합니다." }
        println("${buyMoney.divide(LOTTO_BASE_PRICE)}개를 구매했습니다.")

        return buyMoney
    }

    fun prevPrizeLotto(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()!!.split(LOTTO_SPLIT_PATTERN).map { it.toInt() }
    }
}
