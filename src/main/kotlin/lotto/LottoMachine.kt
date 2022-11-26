package lotto

class LottoMachine(val price: Int) {

    val purchaseCount: Int
    lateinit var winningNumbers: List<Int>
        private set

    init {
        require(price % LOTTO_BASE_PRICE == 0) { "input incorrectly price" }
        purchaseCount = price / LOTTO_BASE_PRICE
    }

    fun setWinningString(winningString: String) {
        val stringNumbers = winningString.split(",")
        require(stringNumbers.isNotEmpty()) { "input string delimiter" }
        require(stringNumbers.size == LOTTO_NUMBERS_COUNT) { "input string delimiter count" }

        this.winningNumbers = stringNumbers.map { numberString -> numberString.trim().toInt() }
            .filterNot { number -> number > MAX_RANDOM_VALUE || number <= 0 }

        require(this.winningNumbers.size == 6) { "input string numbers range" }
    }

    fun publishLotto(): List<Lotto> {
        return (0 until purchaseCount).map { Lotto(createNumbers()) }
    }

    fun createNumbers(): List<Int> {
        return (MIN_RANDOM_VALUE..MAX_RANDOM_VALUE).shuffled().take(6).sorted()
    }

    companion object {
        const val LOTTO_BASE_PRICE = 1000
        private const val LOTTO_NUMBERS_COUNT = 6
        private const val MIN_RANDOM_VALUE = 1
        private const val MAX_RANDOM_VALUE = 45
    }
}
