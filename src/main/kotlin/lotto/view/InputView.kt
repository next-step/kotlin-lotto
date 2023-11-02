package lotto.view

object InputView {

    fun inputPrice(): Int {
        println("구입금액을 입력해 주세요.")
        val price = readln()
        require(price.isNotBlank()) { "입력값이 없습니다." }
        return try {
            price.toInt()
        } catch (e: NumberFormatException) {
            println("숫자를 입력해주세요.")
            inputPrice()
        }
    }
}
