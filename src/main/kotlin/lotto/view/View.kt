package lotto.view

object InputView {
    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val inputMoney = readln()

        return inputMoney.toIntOrNull() ?: throw IllegalArgumentException("올바른 금액을 입력해 주세요. 입력: $inputMoney")
    }

    fun inputWinningLotto(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readln().split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자만 입력하실 수 있습니다. 입력: $it") }
    }
}

object ResultView {
    fun printPurchaseLottos(purchaseLottos: LottoResponses) {
        purchaseLottos.lottos.forEach {
            println(it.numbers.joinToString(prefix = "[", postfix = "]"))
        }
    }

    fun printResult(calculateResult: LottoResultResponse) {
        println(
            """
            당첨 통계
            ---------
            3개 일치 (5000원)- ${calculateResult.matchCounts.count { it == 3 }}개
            4개 일치 (50000원)- ${calculateResult.matchCounts.count { it == 4 }}개
            5개 일치 (1500000원)- ${calculateResult.matchCounts.count { it == 5 }}개
            6개 일치 (2000000000원)- ${calculateResult.matchCounts.count { it == 6 }}개
            총 수익률은 ${calculateResult.profit}입니다.(기준이 1이기 때문에 결과적으로 ${if (calculateResult.profit >= 1) "이득이" else "손해"}라는 의미임)
            """.trimIndent()
        )
    }
}
