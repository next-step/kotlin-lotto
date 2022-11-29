package lotto.domain

fun lottoNumberListOf(vararg elements: Int): Set<LottoNumber> {
    return elements.map { LottoNumber(it) }.toSet()
}

fun lottoNumbersListOf(vararg elements: List<Int>): List<LottoNumbers> {
    return elements.map {
        LottoNumbers(
            it.map { number ->
                LottoNumber(number)
            }.toSet()
        )
    }
}

fun lottoNumberOf(vararg elements: Int): LottoNumbers {
    return LottoNumbers(elements.map { LottoNumber(it) }.toSet())
}

fun winningLottoNumberOf(vararg elements: Int, bonus: Int = 0): WinningLottoNumbers {
    return WinningLottoNumbers(
        lottoNumbers = LottoNumbers(elements.map { LottoNumber(it) }.toSet()),
        bonusLottoNumber = LottoNumber(bonus)
    )
}
