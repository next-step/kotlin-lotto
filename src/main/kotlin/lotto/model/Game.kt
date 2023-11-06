package lotto.model

data class Game(
    val lottoNumbers: LinkedHashSet<LottoNumber>,
) {
    constructor(lottoNumbers: Set<LottoNumber>) : this(LinkedHashSet(lottoNumbers))

    companion object {
        fun autoTicket(): Game {
            return Game(LottoNumber.any6Numbers())
        }
    }
}
