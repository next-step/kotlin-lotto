package lotto

data class Lotto(val price: Int = LOTTO_PRICE) {

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
