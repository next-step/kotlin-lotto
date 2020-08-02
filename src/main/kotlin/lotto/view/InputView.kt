package lotto.view

object InputView {

    val NUMERIC_REGEX = Regex("[0-9]")

    fun purchasePrice(): Int {

        println("구입금액을 입력해 주세요.")
        val price = validate(readLine())

        return price
    }

    fun validate(price: String?): Int {
        if (price.isNullOrBlank()) {
            println("잘못된 구입 가격을 입력하셨습니다.")
            return 0
        }
        if (NUMERIC_REGEX.matches(price)) {
            return price.toInt()
        }

        println("잘못된 구입 가격을 입력하셨습니다.")
        return 0
    }
}
