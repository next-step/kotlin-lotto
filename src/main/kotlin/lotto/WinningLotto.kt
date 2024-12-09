package lotto

class WinningLotto(numbers: List<Int>) {
    private val _lottoNumbers: Set<Int> = numbers.toSortedSet()
    val lottoNumbers: Set<Int>
        get() = _lottoNumbers.toSet()

    constructor() : this(LottoTicket.generateLottoNumber().lottoNumbers.toList())

    fun matchedCount(lottoTicket: LottoTicket): LottoRank {
        val matchCount = lottoNumbers.intersect(lottoTicket.lottoNumbers).size
        return LottoRank.entries.find { it.matchCount == matchCount } ?: LottoRank.BLANK_PLACE
    }
}
