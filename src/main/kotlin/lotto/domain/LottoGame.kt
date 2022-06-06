package lotto.domain

class LottoGame(val lottoNumbers: List<LottoNumber>) {

    fun buy(): List<LottoNumber> {
        return lottoNumbers.shuffled().take(GAME_NUMBERS).sortedBy { it.value }
    }

    companion object {
        private const val GAME_NUMBERS = 6
    }
}
