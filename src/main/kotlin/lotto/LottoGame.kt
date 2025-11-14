package lotto

fun main() {
    println("구입금액을 입력해 주세요.")
    val input = readln()
    try {
        val money = Money(input)
        val buyLotto = LottoShop().buyLotto(money)
        println("${buyLotto.size}개를 구매했습니다.")
        buyLotto.forEach {
            println(it.numbers)
        }
    } catch (e: IllegalArgumentException) {
        println(e.message)
        main()
    }

//    지난 주 당첨 번호를 입력해 주세요.
//    1, 2, 3, 4, 5, 6
//
//    당첨 통계
//            ---------
//            3개 일치 (5000원)- 1개
//            4개 일치 (50000원)- 0개
//            5개 일치 (1500000원)- 0개
//            6개 일치 (2000000000원)- 0개
//            총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
}
