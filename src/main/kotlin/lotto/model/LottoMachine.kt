package lotto.model

class LottoMachine {

    fun auto(size: Int, price: Int): List<Lotto> {
        require(size >= 0)

        return List(size) {
            Lotto.auto(price = price)
        }
    }

    fun manual(numbers: List<LottoNumbers>, price: Int): List<Lotto> = numbers.map { Lotto.manual(price, it) }
}
