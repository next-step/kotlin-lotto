package model

class Lotto(diceRandom: DiceRandom) {
    val lottoNumber = diceRandom.diceList.sorted()

    companion object {
        const val MAKE_NUMBER_COUNT = 6
    }
}
