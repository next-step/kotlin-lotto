package lotto.model

data class Game(
    val lottoNumbers: LottoNumbers,
) {
    companion object {
        fun autoTicket(): Game {
            return Game(LottoNumbers.random())
        }
    }
}
