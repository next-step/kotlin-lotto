package lotto.numbers

abstract class LottoNumbersGenerator {
    protected val lottoNumberPool = (1..45)
    protected val lottoNumberSize = 6

    abstract fun generate(): List<Int>
}
