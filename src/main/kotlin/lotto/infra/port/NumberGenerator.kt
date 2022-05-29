package lotto.infra.port

interface NumberGenerator<T> {

    fun generate(): T
}
