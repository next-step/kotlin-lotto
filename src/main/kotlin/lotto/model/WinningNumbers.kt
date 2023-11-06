package lotto.model

data class WinningNumbers(
    val lottoNumbers: LinkedHashSet<LottoNumber>,
) {
    constructor(input: String) : this(
        LinkedHashSet(
            input.split(",")
                .map { LottoNumber(it.toInt()) }
        )
    )
}
