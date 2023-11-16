fun <T : Any> T.requireAndPass(predicate: (T) -> Boolean, lazyMessage: () -> Any): T {
    require(predicate(this)) { lazyMessage }
    return this
}

fun String?.requireNotNullAndNotBlank(lazyMessage: () -> Any): String {
    require(!isNullOrBlank()) { lazyMessage }
    return this
}

fun String?.toIntOrThrow(lazyMessage: () -> Any): Int {
    return requireNotNullAndNotBlank(lazyMessage)
        .toIntOrNull()
        ?: throw IllegalArgumentException(lazyMessage().toString())
}

fun List<Int>.isSortedAsc() = zipWithNext().all { (a, b) -> a < b }

fun <T> List<T>.hasDuplicate() = size != toSet().size
