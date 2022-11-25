package lotto.domain

fun interface LottoBuyingStrategy {
    fun count(): Int

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
