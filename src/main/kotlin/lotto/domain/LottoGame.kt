package lotto.domain

class LottoGame(val lottoNumbers: List<LottoNumber>) {

    fun buy(): List<LottoNumber> {
        return lottoNumbers.shuffled().take(GAME_NUMBERS).sortedBy { it.value }
    }

    fun buy(n: Int): List<List<LottoNumber>> {
        return (1..n).map{ buy() }
    }

    companion object {
        private const val GAME_NUMBERS = 6
    }
}
