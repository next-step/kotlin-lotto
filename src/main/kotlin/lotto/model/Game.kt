package lotto.model

data class Game(
    val lottoNumbers: LinkedHashSet<LottoNumber>,
) {
    constructor(lottoNumbers: Set<LottoNumber>) : this(LinkedHashSet(lottoNumbers))

    override fun toString(): String {
        return lottoNumbers.map { it.value }
                .joinToString(prefix = "[", postfix = "]", separator = ", ")
    }

    companion object {
        fun autoTicket(): Game {
            return Game(LottoNumber.any6Numbers())
        }
    }
}
