package lotto.model

object LottoCreator {

    fun random(price: Int = 0): Lotto = Lotto.auto(price = price)

    fun manual(price: Int = 0, vararg numbers: Int): Lotto = Lotto.manual(
        price = price,
        numbers = LottoNumbers.manual(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5])
    )

    fun manualZeroPrice(vararg numbers: Int): Lotto = Lotto.manual(
        price = 0,
        numbers = LottoNumbers.manual(numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5])
    )
}
