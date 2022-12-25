package lotto.views

object Input {
    fun getPriceForBuying(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("It is not a number")
    }
}