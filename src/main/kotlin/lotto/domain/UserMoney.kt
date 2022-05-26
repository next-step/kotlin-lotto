package lotto.domain

@JvmInline
value class UserMoney(val money: Int) {

    fun getLottoCount(): Int{
        return money / EACH_LOTTO_PRICE
    }

    companion object {
        private const val EACH_LOTTO_PRICE = 1000
    }
}
