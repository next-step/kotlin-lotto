package lotto.domain

class LottoMachine {
    fun createLottos(amount: Amount): List<Lotto> {
        val number = amount.divide(1_000)
        return List(number) { Lotto.fromRawNumbers(listOf(1, 2, 3, 4, 5, 6)) }
    }
}
