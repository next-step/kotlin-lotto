package calcaulator.util

fun <E> Collection<E>.validate(action: (E) -> Boolean): Collection<E> {
    val invalidValue = this.filterNot(action)
    if (invalidValue.isNotEmpty()) {
        throw RuntimeException()
    }
    return this
}
