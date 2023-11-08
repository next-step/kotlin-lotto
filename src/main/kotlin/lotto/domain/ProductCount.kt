package lotto.domain

@JvmInline
value class ProductCount(
    val value: Int
) {

    fun <T> runForCount(
        action: () -> T
    ): List<T> = List(value) {
        action()
    }
}
