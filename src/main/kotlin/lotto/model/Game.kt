package lotto.model

data class Game(
    val lottoNumbers: LinkedHashSet<LottoNumber>,
) {
    init {
        require(lottoNumbers.size == 6) { "6개의 원소가 필요하지만 [${lottoNumbers.size}] 의 원소가 입력 되었습니다" }
    }

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
