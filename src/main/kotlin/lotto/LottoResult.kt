package lotto

class LottoResult(
    private val lottos: List<Lotto>,
    private val winningNumber: WinningNumber
) {
    fun countByLottoMatch(): Map<LottoMatch, Int> {
        val initialMap = enumValues<LottoMatch>().associateWith { 0 }

        return initialMap + lottos.map { winningNumber.match(it) }
            .groupingBy { it }
            .eachCount()
    }
}
