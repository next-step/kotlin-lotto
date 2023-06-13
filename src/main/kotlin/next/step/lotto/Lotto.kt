package next.step.lotto

data class Lotto(private val numbers: LottoNumbers) {
    fun numbers() = numbers.numbers()

    companion object {
        const val LOTTO_PRICE: Int = 1000

        fun buy(payment: Int): Lotto {
            require(canBuy(payment)) { "로또 가격을 지불해야 합니다." }
            return Lotto(LottoNumbers.random())
        }

        fun canBuy(payment: Int): Boolean = payment >= LOTTO_PRICE
    }

}