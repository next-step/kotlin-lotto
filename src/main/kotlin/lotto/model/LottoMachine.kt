package lotto.model

class LottoMachine {

    fun createLotto(size: Int): List<Lotto> {
        require(size > 0)
        return List(size) { Lotto(LottoNumbers.generateRandomNumbers()) }
    }
}
