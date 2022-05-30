package lotto.view.inputconverter

object StringToIntConverter : InputConverter<Int> {
    override fun convert(input: String): Int = input.toInt()
}
