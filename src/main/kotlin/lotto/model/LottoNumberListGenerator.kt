package lotto.model

/**
 * 로또를 생성하는 클래스
 * */
object LottoNumberListGenerator {
    private const val NUMBER_START = 0
    private const val NUMBER_END = 6

    fun generateAutoLottoList(count: Int, range: List<Int>): List<Lotto> =
        (0 until count)
            .map {
                Lotto(generateRandomNumbers(range))
            }

    fun generateManualLottoList(list: List<String?>?): List<Lotto> {
        if (list.isNullOrEmpty()) return emptyList()
        return list
            .filterNotNull()
            .map { Lotto.parsingTextToLotto(it) }
    }

    fun generateRandomNumbers(range: List<Int>): List<LottoNumber> {
        require(range.size >= 6)
        return (range)
            .shuffled()
            .subList(NUMBER_START, NUMBER_END)
            .sortedBy { it }
            .map { LottoNumber(it) }
    }
}
