package lotto

fun interface Generatable {
    fun generate(count: Int, minNumber: Int, maxNumber: Int): Lotto
}
