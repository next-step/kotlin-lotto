package service

import model.DiceRandom
import model.Lotto

class LottoService() {
    private val lottoListMutable = mutableListOf<Lotto>()
    val lottoList
        get() = lottoListMutable.toList()

    fun create(diceRandom: DiceRandom) {
        lottoListMutable.add(Lotto(diceRandom))
    }
}
