package lotto.filter

interface Filter {

    fun verify(value: Int): Any

}