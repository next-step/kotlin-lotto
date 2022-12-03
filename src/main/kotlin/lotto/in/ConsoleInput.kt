package lotto.`in`

class ConsoleInput {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")

        return readln().ifBlank { throw IllegalArgumentException("empty string is not allowed") }
            .toIntOrNull() ?: throw IllegalArgumentException("purchase amount should be number")
    }
}
