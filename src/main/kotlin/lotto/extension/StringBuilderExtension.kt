package lotto.extension

fun StringBuilder.appendIf(any: Any, boolean: Boolean): StringBuilder {
    if (boolean) {
        return append(any)
    }
    return this
}
