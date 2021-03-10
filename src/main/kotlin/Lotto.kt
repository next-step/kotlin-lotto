
fun main() {
    val strPrice = inputPrice()

}

class Lotto {
    fun validatePrice(strPrice: String?): Int {
        require(!strPrice.isNullOrBlank()) { "구입금액을 반드시 입력해야합니다." }

        try {
            val price = strPrice.toInt()
            require(price > 1000) { "구입 금액은 1000원보다 커야합니다." }

            return price
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("자연수로 변환하는데 실패했습니다.")
        }
    }

    fun buy(price: Int): Int {
        return price / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
