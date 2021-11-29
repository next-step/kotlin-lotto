package lotto.domain

/**
 *
 * @author Leo
 */
fun interface NumberStrategy {

    fun numbers(): List<Int>

    companion object {
        val NUMBERS = IntRange(1, 45).toList()
    }

}
