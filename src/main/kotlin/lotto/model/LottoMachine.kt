package lotto.model

class LottoMachine {

    fun auto(size: Int, price: Int): List<Lotto> {
        require(size >= 0)

        return List(size) {
            Lotto(
                price = price,
                numbers = LottoNumbers.random()
            )
        }
    }

    fun manual(numbers: List<LottoNumbers>, price: Int): List<Lotto> = numbers.map { Lotto(price, it) }
}
