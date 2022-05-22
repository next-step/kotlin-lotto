package lotto.domain

fun main() {
    val money = Money(14000)
    val store = Store(Issuer)
    val lottos = store.buy(money)

    println(lottos.map { it.numbers }.joinToString("\n"))

    val winNumbers = WinNumbers(listOf(1, 2, 3, 4, 5, 6))

    print(winNumbers.value.joinToString(","))

    val policies = listOf(
        WinPolicy(3, Money(5000)),
        WinPolicy(4, Money(50000)),
        WinPolicy(5, Money(1500000)),
        WinPolicy(6, Money(2000000000)),
    )
    val matcher = Matcher(winNumbers, policies)
    val result = matcher.makeResult(lottos)

    println()
    println(result.joinToString("\n"))

    val profits = Profit(money, result)
    println(profits.value)
}
