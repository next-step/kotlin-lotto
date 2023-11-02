package calculator.component

object Helper {
    fun <T> arrayDequeOf(vararg t: T): ArrayDeque<T> {
        return ArrayDeque(
            t.toList()
        )
    }
}
