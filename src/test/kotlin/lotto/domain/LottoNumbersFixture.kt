package lotto.domain

object LottoNumbersFixture {
    fun of(numberSet: Set<Int>): LottoNumbers = LottoNumbers(
        numberSet.map(LottoNumber.Companion::from)
            .toSet()
    )
}
