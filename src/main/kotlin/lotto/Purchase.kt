package lotto

class Purchase (private val sumPrice: Int) {

    fun count() : Int{
        return sumPrice / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}