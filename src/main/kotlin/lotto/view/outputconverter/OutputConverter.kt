package lotto.view.outputconverter

interface OutputConverter<T> {
    fun convert(printable: T): String
}
