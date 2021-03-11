package lotto

class Lotto(val numbers: List<Int>, val price: Int = DEFAULT_LOTTO_PRICE) {

    companion object {
        private const val DEFAULT_LOTTO_PRICE = 1000;
    }
}
