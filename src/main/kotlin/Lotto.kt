
fun main() {
    val lotto = Lotto()
    val price = lotto.validatePrice(inputPrice())
    val lottoCnt = lotto.buy(price)
    val lottoCards = lotto.extractNumber(lottoCnt)
    printLottoCards(lottoCards)
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

    fun extractNumber(cnt: Int): List<LottoCard> {
        return (1..cnt).map {
            LottoCard(LOTTO_NUMBERS.shuffled().subList(0, LOTTO_NUMBER_CNT))
        }
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_NUMBER_CNT = 6
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        val LOTTO_NUMBERS = (LOTTO_START_NUMBER..LOTTO_LAST_NUMBER).toList()
    }
}
