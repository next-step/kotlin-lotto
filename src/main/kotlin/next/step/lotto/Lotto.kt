package next.step.lotto

@JvmInline
value class Lotto(private val numbers: LottoNumbers) {
    fun numbers() = numbers.numbers()

    fun buy(payment: Int): Int {
        require(canBuy(payment)) { "로또 가격을 지불해야 합니다." }
        return payment - LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE: Int = 1000

        fun canBuy(payment: Int): Boolean = payment >= LOTTO_PRICE

        fun of(numbers: LottoNumbers): Lotto = Lotto(numbers)

        fun preview(): Lotto = Lotto(LottoNumbers.random())
    }

}