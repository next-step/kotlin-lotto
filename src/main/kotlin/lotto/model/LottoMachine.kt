package lotto.model

class LottoMachine {

    fun createLotto(size: Int, price: Int): List<Lotto> {
        require(size >= 0)

        return List(size) {
            Lotto(
                price = price,
                numbers = LottoNumbers.random()
            )
        }
    }
}
