package lotto.domain

internal object LottoNumbersFixtureMaker {
    internal fun createLottoNumbers(items: List<Int>) = items.map(LottoNumber::valueOf).toCollection(LinkedHashSet())

    internal fun createLottoNumbers(capacity: Int) = (1..capacity).map(LottoNumber::valueOf)
        .toCollection(LinkedHashSet())
}
