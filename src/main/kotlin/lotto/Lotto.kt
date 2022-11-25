package lotto

class Lotto(val price: Int) {

    init {
        require(price % BASE_PRICE == 0) { "input incorrectly price" }
    }

    companion object {
        private const val BASE_PRICE = 1000
    }
}
