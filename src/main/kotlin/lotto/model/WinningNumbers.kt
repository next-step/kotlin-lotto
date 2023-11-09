package lotto.model

data class WinningNumbers(
    val lottoNumbers: LottoNumbers,
) {

    fun countOfMatch(game: Game): Int {
        return lottoNumbers.countOfMatchNumbers(game.lottoNumbers)
    }

    constructor(input: String) : this(
        LottoNumbers(
            input.split(",")
                .map { it.toInt() }
        )
    )
}
