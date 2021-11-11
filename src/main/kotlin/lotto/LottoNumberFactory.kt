package lotto

object LottoNumberFactory {
    const val NUMBER_FROM = 1
    const val NUMBER_TO = 45

    fun numbers() = (NUMBER_FROM..NUMBER_TO).map { LottoNumber(it) }
}
