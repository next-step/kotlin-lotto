package calculator

fun interface Converter<IN, OUT> {

    fun convert(input: IN): OUT
}
