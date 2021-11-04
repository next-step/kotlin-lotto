package lotto.model

class LottoMachine {

    fun auto(size: Size, price: Price): List<Lotto> = List(size.value) { Lotto.auto(price = price) }

    fun manual(numbers: List<LottoNumbers>, price: Price): List<Lotto> = numbers.map { Lotto.manual(price, it) }
}
