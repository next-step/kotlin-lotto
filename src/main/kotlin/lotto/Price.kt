package lotto

class Price(private val count: Int) {
    fun price(): Int{
        return count * LOTTO_PRICE
    }

    override fun toString(): String {
        return "$count"
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}