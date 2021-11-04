package lotto.model

class LottoMachine {

    fun auto(size: Size, price: Int): List<Lotto> = List(size.value) { Lotto.auto(price = price) }

    fun manual(numbers: List<LottoNumbers>, price: Int): List<Lotto> = numbers.map { Lotto.manual(price, it) }
}
