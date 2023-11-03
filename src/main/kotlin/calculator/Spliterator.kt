package calculator

fun interface Spliterator<TYPE> {

    fun split(value: TYPE): List<TYPE>
}
