package lotto.model

data class WinningNumbers(
    val lottoNumbers: LinkedHashSet<LottoNumber>,
) {
    init {
        require(lottoNumbers.size == 6) { "6개의 숫자가 필요 합니다" }
        lottoNumbers.sortedWith(compareBy { it.value })
    }

    fun countOfMatch(game: Game): Int {
        val linkedHashSet = LinkedHashSet(lottoNumbers)
        linkedHashSet.addAll(game.lottoNumbers)
        return 12 - linkedHashSet.size
    }

    constructor(input: String) : this(
        LinkedHashSet(
            input.split(",")
                .map { LottoNumber(it.toInt()) }
        )
    )
}
