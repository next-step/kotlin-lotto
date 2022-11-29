package lotto

fun createLotto(vararg numbers: Int): Lotto {
    return Lotto(numbers.map { LottoNumber(it) }.toSet())
}
